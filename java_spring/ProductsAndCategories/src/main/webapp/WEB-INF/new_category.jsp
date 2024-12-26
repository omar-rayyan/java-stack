<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
    	<a href="/" class="btn btn-secondary mb-3">Back to Home</a>
        <h1>Add New Category</h1>
        <form:form method="post" action="/categories/new" modelAttribute="category" class="mt-4">
            <div class="mb-3">
                <label for="name" class="form-label">Category Name</label>
                <form:input path="name" id="name" class="form-control" />
                <form:errors path="name" class="text-danger" />
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
</body>
</html>