var app = angular.module('cabbookingsystem',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/QawSSO',
    BOOKING_SERVICE_API : 'http://localhost:8080/QawSSO/Booking/GetBookings',
    CREATE_BOOKING_SERVICE_API : 'http://localhost:8080/QawSSO/Booking/CreateBooking'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'BookingController',
                controllerAs:'bookingCtrl',
                resolve: {
                    users: function ($q, BookingService) {
                        console.log('Load all Bookings');
                        var deferred = $q.defer();
                        BookingService.loadAllBookings().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

