<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, java.util.ArrayList, com.model.VehicleVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<table class="table table-bordered">
			<tr>
				<th>Model</th>
				<th>Make</th>
				<th>Edit</th>
				<th>View</th>
			</tr>
			<%
			@SuppressWarnings("unchecked")
			List<VehicleVO> carList = (ArrayList<VehicleVO>)application.getAttribute("listOfCars");
			for(VehicleVO v : carList) {
			%>
			<tr>
				<td>
					<%=
					v.getModel()
					%>
				</td>
				<td>
					<%=
					v.getMake()
					%>
				</td>
				<td>
					<a href="carform?id=<%=v.getId()%>">Edit</a>
				</td>
				<td>
					<a href="details?id=<%=v.getId()%>">View</a>
				</td>
			</tr>
			<%
			}
			application.removeAttribute("listOfCars");
			%>
		</table>
	</div>
</body>
</html>