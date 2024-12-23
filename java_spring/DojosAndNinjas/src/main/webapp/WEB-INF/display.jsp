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
    <title>Display - Dojos and Ninjas</title>
</head>
<body>
    <div class="container mt-5">
        <div class="card mb-4">
            <div class="card-header bg-primary text-white">
                <h2>${dojo.name}</h2>
            </div>
            <div class="card-body">
                <p><strong>ID:</strong> ${dojo.id}</p>
                <p><strong>Number of Ninjas:</strong> ${dojo.ninjas.size()}</p>
                <p><strong>Established:</strong> ${dojo.getCreatedAt()}</p>
            </div>
        </div>
        
        <h3 class="mb-3">Ninjas in ${dojo.name}</h3>
        <table class="table table-striped table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Age</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ninja" items="${dojo.ninjas}">
                    <tr>
                        <td>${ninja.firstName}</td>
                        <td>${ninja.lastName}</td>
                        <td>${ninja.age}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <div class="d-flex justify-content-between mt-3">
            <a href="/" class="btn btn-secondary">Back to All Dojos</a>
            <a href="/add_ninja" class="btn btn-primary">Add New Ninja</a>
        </div>
    </div>
</body>
</html>