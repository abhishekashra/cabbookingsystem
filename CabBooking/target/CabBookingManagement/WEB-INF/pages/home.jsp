<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cab Management</title>
</head>
<body>
	<div align="center">
		<h1>Cab Booking Management</h1>
		<div align="center">
			<h1>Booking Cab</h1>
			<form:form action="saveEmployee" method="post"
				modelAttribute="employee">
				<table>
					<form:hidden path="id" />
					<tr>
						<td>Name:</td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td>Address:</td>
						<td><form:input path="address" /></td>
					</tr>
					<tr>
						<td>Telephone:</td>
						<td><form:input path="telephone" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Save"></td>
					</tr>
				</table>
			</form:form>
		</div>
		</br>
		<table border="1">
			<th>Driver</th>
			<th>Customer</th>
			<th>Status</th>

			<c:forEach var="driver" items="${driverList}">
				<tr>
					<td>${driver.Name}</td>
					<td>${driver.currentLatitude}</td>
					<td>${driver.status}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html> --%>


<html>
<head><title>Hello</title></head>
<body>
HOme
</body>
</html>