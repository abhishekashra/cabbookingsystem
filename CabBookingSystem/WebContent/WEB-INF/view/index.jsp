<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en" ng-app="cabbookingsystem">
<head>
<title>Cab Booking System</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet" />
<link href="css/app.css" rel="stylesheet" />
<style>
body, #mainWrapper {
	height: 100%;
	background-color:rgb(245, 245, 245);
}

body, .form-control{
	font-size:12px!important;
}

.floatRight{
	float:right;
	margin-right: 18px;
}

.has-error{
	color:red;
}

.generic-container {
  width:80%;
  margin-left: 20px;
  margin-top: 20px;
  margin-bottom: 20px;
  padding: 20px;
  background-color: #EAE7E7;
  border: 1px solid #ddd;
  border-radius: 4px;
  box-shadow: 0 0 30px black;
}

.custom-width {
    width: 80px !important;
}
</style>
</head>
<body>
Cab Booking by abhishek
	<div ui-view></div>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.3.1/angular-ui-router.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/localforage/1.4.2/localforage.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/ngStorage/0.3.10/ngStorage.min.js"></script>
	<script src="resources/js/app/app.js"></script>
	<script src="resources/js/app/BookingService.js"></script>
	<script src="js/appBookingController.js"></script>
</body>
</html>