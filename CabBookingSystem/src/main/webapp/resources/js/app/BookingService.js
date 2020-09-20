'use strict';

angular.module('cabbookingsystem').factory('BookingService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
            	loadAllBookings: loadAllBookings,
            	getAllBookings: getAllBookings,
                createBooking: createBooking,
            };

            return factory;

            function loadAllBookings() {
                console.log('Fetching all Bookings');
                var deferred = $q.defer();
                $http.get(urls.BOOKING_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all Bookings');
                            $localStorage.bookings = response.data;
                            console.log($localStorage.bookings);
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading Bookings');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllBookings(){
                return $localStorage.bookings;
            }

            function createBooking(booking) {
                console.log('Creating booking');
                var deferred = $q.defer();
                $http.post(urls.CREATE_BOOKING_SERVICE_API, booking)
                    .then(
                        function (response) {
                        	loadAllBookings();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating booking : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
        }
    ]);