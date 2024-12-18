<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Expense | Save Travels</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body class="bg-light">
<div class="container mt-5">
	<h1 class="header text-center mb-4">View Expense</h1>
	<div class="card expense-card">
		<div class="card-header expense-card-header">
			Expense Details
		</div>
		<div class="card-body">
			<div class="expense-detail">
				<label for="expenseName">Expense Name:</label>
				<p class="form-control-plaintext" id="expenseName">${expense.getName()}</p>
			</div>
			<div class="expense-detail">
				<label for="expenseVendor">Vendor:</label>
				<p class="form-control-plaintext" id="expenseVendor">${expense.getVendor()}</p>
			</div>
			<div class="expense-detail">
				<label for="expenseAmount">Amount:</label>
				<p class="form-control-plaintext" id="expenseAmount">${expense.getAmount()}</p>
			</div>
			<div class="expense-detail">
				<label for="expenseDescription">Description:</label>
				<p class="form-control-plaintext" id="expenseDescription">${expense.getDescription()}</p>
			</div>
		</div>
		<div class="card-footer text-center">
			<a href="/" class="btn btn-custom">Back to Expenses</a>
		</div>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>