<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <title>Add Ninja - Dojos and Ninjas</title>
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <div class="card-header bg-primary text-white">
                <h2 class="mb-0">Add a New Ninja</h2>
            </div>
            <div class="card-body">
                <form:form action="/add_ninja" method="post" modelAttribute="ninja">
                    <!-- First Name -->
                    <div class="mb-3">
                        <form:label path="firstName" class="form-label"><strong>First Name:</strong></form:label>
                        <form:input path="firstName" class="form-control" placeholder="Enter first name" />
                        <form:errors path="firstName" class="text-danger small" />
                    </div>
                    
                    <!-- Last Name -->
                    <div class="mb-3">
                        <form:label path="lastName" class="form-label"><strong>Last Name:</strong></form:label>
                        <form:input path="lastName" class="form-control" placeholder="Enter last name" />
                        <form:errors path="lastName" class="text-danger small" />
                    </div>
                    
                    <!-- Age -->
                    <div class="mb-3">
                        <form:label path="age" class="form-label"><strong>Age:</strong></form:label>
                        <form:input path="age" class="form-control" placeholder="Enter age" type="number" />
                        <form:errors path="age" class="text-danger small" />
                    </div>
                    
                    <!-- Dojo -->
                    <div class="mb-3">
                        <form:label path="dojo" class="form-label"><strong>Dojo:</strong></form:label>
                        <form:select path="dojo" class="form-select">
                            <form:options items="${dojos}" itemValue="id" itemLabel="name" />
                        </form:select>
                        <form:errors path="dojo.id" class="text-danger small" />
                    </div>
                    
                    <!-- Submit Button -->
                    <div class="text-end">
                        <button type="submit" class="btn btn-primary">Add Ninja</button>
                        <a href="/" class="btn btn-secondary">Cancel</a>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>