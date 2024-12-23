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
    <title>Add Dojo - Dojos and Ninjas</title>
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Add a New Dojo</h1>
        
        <!-- Dojo Form -->
        <form:form action="/add_dojo" method="post" modelAttribute="dojo" class="mb-5">
            <div class="mb-3">
                <form:label path="name" class="form-label">Name:</form:label>
                <form:input path="name" class="form-control" />
                <form:errors path="name" cssClass="text-danger" />
            </div>
            <button type="submit" class="btn btn-primary">Add Dojo</button>
        </form:form>
        
        <h2 class="mb-4">All Dojos</h2>
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Dojo Name</th>
                    <th>Number of Ninjas</th>
                    <th>View Ninjas</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dojo" items="${dojos}">
                    <tr>
                        <td>${dojo.name}</td>
                        <td>${dojo.ninjas.size()}</td>
                        <td>
                            <a href="/dojos/${dojo.id}" class="btn btn-info btn-sm">View Ninjas</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>