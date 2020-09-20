'use strict';

angular.module('cabbookingsystem').controller('BookingController',
    ['BookingService', '$scope',  function( BookingService, $scope) {

        var self = this;
        self.booking = {};
        self.bookings=[];

        self.submit = submit;
        self.getAllBookings = getAllBookings;
        self.createBooking = createBooking;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Submitting');
            console.log('Create Booking ', self.booking);
            createBooking(self.booking);
        }

        function createBooking(booking) {
            console.log('About to create Booking');
            BookingService.createBooking(booking)
                .then(
                    function (response) {
                        console.log('Booking created successfully');
                        self.successMessage = 'Booking created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.booking={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while Booking');
                        self.errorMessage = 'Error while Booking: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function getAllBookings(){
        	self.bookings.push(BookingService.getAllBookings());
            return BookingService.getAllBookings();
        }

        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.bookings={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);