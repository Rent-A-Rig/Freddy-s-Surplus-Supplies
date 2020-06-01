<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Orders</h1>
<!-- model data = "requests" type = List of requestedInventory -->
	<table>
		<tr>
			<th>ProductID</th>
			<th>Product Name</th>
			<th>Quantity</th>
		</tr>
		<c:forEach var="inventory" items="${requests}">
		<tr>
			<td>${inventory.product_id}</td>
			<td>${inventory.product_name}</td>
			<td>${inventory.request_qty}</td>
		</tr>
		</c:forEach>
	</table>
	<button type="button">Approve</button>
	<button type="button">Deny</button><br>
	
<a href="home">Get back home</a>


</body>
</html>