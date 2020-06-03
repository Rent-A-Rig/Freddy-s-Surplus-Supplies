<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="<c:url value='/resources/css/mainStyles.css'/>"
	type="text/css">
	
	<link rel="stylesheet" href="<c:url value='/resources/css/table.css'/>"
	type="text/css">
<title>Freddy's Surplus Supply</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="sidenav">
		<a href="home">Home</a>
  		<a href="activeRequest">Active Requests</a>
  		<a href="previousRequest">Fulfilled Requests</a>
  		<a href="inventory">Inventory</a>
  		<a href="logout">Log out</a>
  		
	</div>
	
	<div class="content">
  			<h1>Fulfilled Orders</h1>
	<!-- model data = "requests" type = List of requestedInventory -->
	<table id="products">
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Qty</th>
			<th>Status</th>
		</tr>
			<c:forEach var="inventory" items="${requests}">
				<form:form modelAttribute="inventory" action="requestInventory">
					<tr>
						<td>${inventory.product_id}</td>
						<td>${inventory.product_name}</td>
						<td>${inventory.request_qty}</td>
						<td>${inventory.fulfilled}
					</tr>
				</form:form>
			</c:forEach>
		</table>
	</div>
</body>
</html>