<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="_ui/js/jquery-3.0.0.min.js" ></script>
	<script src="_ui/js/angular.min.js" ></script>
    <script src="_ui/js/applications.js"></script>
	<script src="_ui/js/controllers.js" ></script>
</head>
<body ng-app="carDetails">
	<div class="container">
        <!-- Table to show the car details -->
		<table class="table table-bordered" ng-controller="details" ng-init="getCarDetail(${id})">
			<tr>
				<th>Make</th>
				<td>{{car.make}}</td>
			</tr>
			<tr>
				<th>Model</th>
				<td>{{car.model}}</td>
			</tr>
			<tr>
				<th>Engine In CC</th>
				<td>{{car.engineInCC}}</td>
			</tr>
			<tr>
				<th>Fuel Capacity</th>
				<td>{{car.fuelCapacity}}</td>
			</tr>
			<tr>
				<th>Milage</th>
				<td>{{car.milage}}</td>
			</tr>
			<tr>
				<th>Price</th>
				<td>{{car.price}}</td>
			</tr>
			<tr>
				<th>Road Tax</th>
				<td>{{car.roadTax}}</td>
			</tr>
			<tr>
				<th>AC</th>
				<td>{{car.ac}}</td>
			</tr>
			<tr>
				<th>Power Steering</th>
				<td>{{car.powerSteering}}</td>
			</tr>
			<tr>
				<th>Accessory Kit</th>
				<td>{{car.accessoryKit}}</td>
			</tr>
		</table>
		<a href="listCar">Back To List</a>
	</div>
</body>
</html>
