<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
  			<h1>Active Orders</h1>
	<!-- model data = "requests" type = List of requestedInventory -->
	<table id="products">
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Qty</th>
			<th>
			<th>
		</tr>
		<c:forEach var="inventory" items="${requests}">
			<form:form modelAttribute="returnRequest" action="requestInventory">
				<tr>
					<td>${inventory.product_id}</td>
					<td>${inventory.product_name}</td>
					<td>${inventory.request_qty}</td>
					<td><input type="submit" name="accept" value="accept"></td>
					<td><input type="submit" name="deny" value="deny"></td>
					<form:hidden path="product_id" value="${inventory.product_id}"/>
					<form:hidden path="product_name" value="${inventory.product_name}"/>
					<form:hidden path="request_qty" value="${inventory.request_qty}"/>
					<form:hidden path="request_id" value="${inventory.request_id}"/>
					<form:hidden path="request_date" value="${inventory.request_date}"/>
					<form:hidden path="fulfilled" value="${inventory.fulfilled}"/>
				</tr>
			</form:form>
		</c:forEach>
	</table>
	<div>
</body>
</html>
