<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<body ng-app="listOfCars">
	<div class="container">
        <!-- Table to show different cars list -->
		<table class="table table-bordered" ng-controller="carList" ng-init="loadCars()">

			<tr>
				<th>Model</th>
				<th>Make</th>
				<th>Edit</th>
				<th>View</th>
			</tr>
			<tr ng-repeat="car in cars">
				<td>
					{{car.model}}
				</td>
				<td>
					{{car.make}}
				</td>
				<td>
					<a href="caredit?id={{car.id}}">Edit</a>
				</td>
				<td>
					<a href="cardetails?id={{car.id}}">View</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
