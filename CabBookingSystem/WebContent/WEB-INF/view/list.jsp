<div class="generic-container">
	<div class="panel panel-default">
		<!-- Default panel contents -->
		<div class="panel-heading">
			<span class="lead">Booking Board</span>
		</div>
		<div class="panel-body">
			<div class="formcontainer">
				<div class="alert alert-success" role="alert"
					ng-if="bookingCtrl.successMessage">{{bookingCtrl.successMessage}}</div>
				<div class="alert alert-danger" role="alert"
					ng-if="bookingCtrl.errorMessage">{{bookingCtrl.errorMessage}}</div>
				<form ng-submit="bookingCtrl.submit()" name="myForm"
					class="form-horizontal">
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="uname">Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="bookingCtrl.booking.name"
									id="uname" class="username form-control input-sm"
									placeholder="Enter your name" required ng-minlength="3" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="age">Current
								Latitude</label>
							<div class="col-md-7">
								<input type="text"
									ng-model="bookingCtrl.booking.currentLatitiude"
									id="currentLatitude" class="form-control input-sm"
									placeholder="Enter your Current Latitude." required
									ng-pattern="bookingCtrl.onlyIntegers" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="salary">Current
								Longitude</label>
							<div class="col-md-7">
								<input type="text"
									ng-model="bookingCtrl.booking.currentLongitude"
									id="currentLongitude" class="form-control input-sm"
									placeholder="Enter your Current Longitude" required
									ng-pattern="bookingCtrl.onlyNumbers" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit"
								value="{{!bookingCtrl.user.id ? 'Add' : 'Update'}}"
								class="btn btn-primary btn-sm"
								ng-disabled="myForm.$invalid || myForm.$pristine">
							<button type="button" ng-click="bookingCtrl.reset()"
								class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset
								Form</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="panel panel-default">
		<!-- Default panel contents -->
		<div class="panel-heading">
			<span class="lead">List of Bookings</span>
		</div>
		<div class="panel-body">
			<div class="table-responsive">
				<table class="table table-hover">
					<thead>
						<tr>
							<th id="driverName">Driver Name</th>
							<th id="customerName">Customer Name</th>
							<th id="driverStatus">Driver Status</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="b in bookingCtrl.getAllBookings()">
							<td>{{b.driverName}}</td>
							<td>{{b.customerName}}</td>
							<td>{{b.driverStatus}}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>