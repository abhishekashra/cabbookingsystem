<!doctype html>
<html>
<head>
<title>Cab Management Portal</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- jQuery Modal -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
<style>
.modal p {
	margin: 1em 0;
}

.add_form.modal {
	border-radius: 0;
	line-height: 18px;
	padding: 0;
	font-family: "Lucida Grande", Verdana, sans-serif;
}

.add_form.modal p {
	padding: 20px 30px;
	border-bottom: 1px solid #ddd;
	margin: 0;
	background: -webkit-gradient(linear, left bottom, left top, color-stop(0, #eee),
		color-stop(1, #fff));
	overflow: hidden;
}

.add_form.modal p:last-child {
	border: none;
}

.add_form.modal p label {
	float: left;
	font-weight: bold;
	color: #333;
	font-size: 13px;
	width: 110px;
	line-height: 22px;
}

.add_form.modal p input[type="text"], .add_form.modal p input[type="submit"]
	{
	font: normal 12px/18px "Lucida Grande", Verdana;
	padding: 3px;
	border: 1px solid #ddd;
	width: 200px;
}

#msg {
	margin: 10px;
	padding: 30px;
	color: #fff;
	font-size: 18px;
	font-weight: bold;
	background: -moz-linear-gradient(top, #2e5764, #1e3d47);
	background: -webkit-gradient(linear, left bottom, left top, color-stop(0, #1e3d47),
		color-stop(1, #2e5764));
}
</style>
<script type="text/javascript">
$(document).ready(function() {
	$.getJSON('http://localhost:8080/CabBookingManagement/Driver/GetAll', function(json) {
		var tr=[];
		for (var i = 0; i < json.length; i++) {
			tr.push('<tr>');
			tr.push('<td>' + json[i].driverId + '</td>');
			tr.push('<td>' + json[i].driverName + '</td>');
			tr.push('<td>' + json[i].status + '</td>');
			tr.push('</tr>');
		}
		$('#bookingTable').append($(tr.join('')));
	});

	$(document).delegate('#addNew', 'click', function(event) {
		event.preventDefault();
		
		var name = $('#name').val();
		var currentLatitude = $('#currentLatitude').val();
		var customerLongitude = $('#currentLongitude').val();
		
		$.ajax({
			type: "POST",
			contentType: "application/json; charset=utf-8",
			url: "http://localhost:8080/CabBookingManagement/Order/CreateOrder",
			data: 
					{
						'customerName': name,
						'customerLatitude': currentLatitude,
						'customerLongitude': currentLongitude,
					},
			cache: false,
			success: function(result) {
				$("#msg").html( "<span style='color: green'>Cab Booked Successfully</span>" );
				window.setTimeout(function(){location.reload()},1000)
			},
			error: function(err) {
				$("#msg").html( "<span style='color: red'>Name is required</span>" );
			}
		});
	});
});
</script>
</head>
<body>

	<h2>Cab Management Portal</h2>

	<p>
		<a class='btn' href="#add" rel="modal:open">Book Cab</a>
	</p>

	<table id="bookingTable" border="1" cellspacing="0" cellpadding="5">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Status</th>
		</tr>
	</table>

	<form id="add" action="#" class="add_form modal" style="display: none;">
		<div id='msg' />
		<h3>Customer Details</h3>
		<table>
			<tr>
				<td><label>Name</label></td>
				<td><input type="text" id="name" name="name"></td>
			</tr>
			<tr>
				<td><label>Current Latitude</label></td>
				<td><input type="text" id="currentLatitude"
					name="currentLatitude"></td>
			</tr>
			<tr>
				<td><label>Current Longitude</label></td>
				<td><input type="text" id="currentLongitude"
					name="currentLongitude"></td>
			</tr>
		</table>
		<input type="submit" id="addNew" value="Submit">
	</form>

</body>
</html>