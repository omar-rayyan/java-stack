<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save Travels</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Save Travels</h1>
        <table class="table table-striped text-center">
            <thead>
                <tr>
                    <th scope="col">Expense</th>
                    <th scope="col">Vendor</th>
                    <th scope="col">Amount</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="expense" items="${expenses}">
                    <tr>
                        <td><a href="/expenses/${expense.getId()}">${expense.getName()}</a></td>
                        <td>${expense.getVendor()}</td>
                        <td>$${expense.getAmount()}</td>
                        <td>
                            <a href="/expenses/edit/${expense.getId()}" class="btn btn-primary btn-sm">Edit</a>
                            <form action="/expenses/delete/${expense.getId()}" method="post" class="d-inline">
                                <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="container">
	    <h1 class="header">Add an expense</h1>
	    <form:form action="/createexpense" method="post" modelAttribute="expense">
		    <div class="form-group">
		        <form:label path="name">Expense Name</form:label>
		        <form:input class="form-control mb-3" path="name" />
		        <form:errors path="name" cssClass="alert alert-danger mb-4" />
		    </div>
		    <div class="form-group">
		        <form:label path="vendor">Vendor</form:label>
		        <form:input class="form-control mb-3" path="vendor" />
		        <form:errors path="vendor" cssClass="alert alert-danger mb-4" />
		    </div>
		    <div class="form-group">
		        <form:label path="amount">Amount</form:label>
		        <form:input class="form-control mb-3" path="amount" type="number" />
		        <form:errors path="amount" cssClass="alert alert-danger mb-4" />
		    </div>
		    <div class="form-group">
		        <form:label path="description">Description</form:label>
		        <form:input class="form-control mb-3" path="description" />
		        <form:errors path="description" cssClass="alert alert-danger mb-4" />
		    </div>
		    <input type="submit" class="btn btn-primary" value="Add" />
		</form:form>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>