<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Fruit Store</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.css" />
</head>
<body>
	<div class="container mt-5">
		<h1 class="text-center mb-4">Fruit Store</h1>
		<table class="table table-striped table-hover">
			<thead class="table-dark">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="fruit" items="${fruits}">
					<tr>
						<td>${fruit.name}</td>
						<td>$${fruit.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="/webjars/bootstrap/js/bootstrap.js"></script>
</body>
</html>