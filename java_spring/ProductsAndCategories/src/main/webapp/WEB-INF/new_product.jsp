<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
    	<a href="/" class="btn btn-secondary mb-3">Back to Home</a>
        <h1>Add New Product</h1>
        <form:form method="post" action="/products/new" modelAttribute="product" class="mt-4">
            <div class="mb-3">
                <label for="name" class="form-label">Product Name</label>
                <form:input path="name" id="name" class="form-control" />
                <form:errors path="name" class="text-danger" />
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <form:textarea path="description" id="description" class="form-control"></form:textarea>
                <form:errors path="description" class="text-danger" />
            </div>

            <div class="mb-3">
                <label for="price" class="form-label">Price</label>
                <form:input path="price" id="price" type="number" step="0.01" class="form-control" />
                <form:errors path="price" class="text-danger" />
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
</body>
</html>