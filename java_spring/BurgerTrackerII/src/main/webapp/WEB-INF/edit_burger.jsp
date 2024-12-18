<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Burger | Burger Tracker</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
	    <h1 class="header">Edit Burger ${burger.getId()}</h1>
	    <form:form action="/updateburger/${burger.getId()}" method="post" modelAttribute="burger">
            <form:hidden path="id"/>
		    <div class="form-group">
		        <form:label path="name">Burger Name</form:label>
		        <form:input class="form-control mb-3" path="name" value="${burger.getName()}"/>
		        <form:errors path="name" cssClass="alert alert-danger mb-4" />
		    </div>
		    <div class="form-group">
		        <form:label path="restaurantName">Restaurant Name</form:label>
		        <form:input class="form-control mb-3" path="restaurantName" value="${burger.getRestaurantName()}" />
		        <form:errors path="restaurantName" cssClass="alert alert-danger mb-4" />
		    </div>
		    <div class="form-group">
		        <form:label path="rating">Rating</form:label>
		        <form:input class="form-control mb-3" path="rating" type="number" value="${burger.getRating()}" />
		        <form:errors path="rating" cssClass="alert alert-danger mb-4" />
		    </div>
		    <div class="form-group">
		        <form:label path="notes">Notes</form:label>
		        <form:input class="form-control mb-3" path="notes" value="${burger.getNotes()}"/>
		        <form:errors path="notes" cssClass="alert alert-danger mb-4" />
		    </div>
		    <input type="submit" class="btn btn-primary" value="Submit" />
		</form:form>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>