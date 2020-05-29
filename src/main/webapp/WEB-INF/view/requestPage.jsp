<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>HTML Table</h2>

	<table>
		<tr>
			<th>ProductID</th>
			<th>Product Name</th>
			<th>Quantity</th>
		</tr>
		<tr>
			<td>${inventory.productID}</td>
			<td>${inventory.productName }</td>
			<td>${inventory.quantity}</td>
		</tr>
		<tr>
			<td>2</td>
			<td>Desktop</td>
			<td>20</td>
		</tr>
		<tr>
			<td>3</td>
			<td>Desktop</td>
			<td>20</td>
		</tr>
		<tr>
			<td>4</td>
			<td>Desktop</td>
			<td>20</td>
		</tr>
	</table>
	<button type="button">Approve</button>
	<button type="button">Deny</button>


</body>
</html>