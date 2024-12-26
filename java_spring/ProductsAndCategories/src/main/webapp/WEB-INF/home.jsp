<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>Home Page</h1>
        <a href="/products/new" class="btn btn-primary">Add New Product</a>
        <a href="/categories/new" class="btn btn-primary ms-2">Add New Category</a>

        <h2 class="mt-4">Products</h2>
        <table class="table table-striped table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Product Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Categories</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.id}</td>
                        <td>
                            <a href="/products/${product.id}" class="text-decoration-none text-primary">
                                ${product.name}
                            </a>
                        </td>
                        <td>${product.description}</td>
                        <td>$${product.price}</td>
                        <td>${product.categories.size()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <h2 class="mt-4">Categories</h2>
        <table class="table table-striped table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Category Name</th>
                    <th>Products</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="category" items="${categories}">
                    <tr>
                        <td>${category.id}</td>
                        <td>
                            <a href="/categories/${category.id}" class="text-decoration-none text-primary">
                                ${category.name}
                            </a>
                        </td>
                        <td>${category.products.size()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>

</html>
