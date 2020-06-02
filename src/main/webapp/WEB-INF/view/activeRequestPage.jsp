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
			<form:form modelAttribute="inventory" action="requestInventory">
				<tr>
					<td>${inventory.product_id}</td>
					<td>${inventory.product_name}</td>
					<td>${inventory.request_qty}</td>
					<td><input type="submit" name="accept" value="accept"></td>
					<td><input type="submit" name="deny" value="deny"></td>
				</tr>
			</form:form>
		</c:forEach>
	</table>

	<a href="home">Go back home</a>


</body>
</html>