<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <a href="/" class="btn btn-secondary mb-3">Back to Home</a>
        
        <h1>Category Details</h1>
        <p><strong>Name:</strong> ${category.name}</p>
        <p><strong>Products:</strong> ${category.products.size()}</p>

        <div class="container mt-3">
            <h3>Products</h3>
            <table class="table table-striped table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Product Name</th>
                        <th scope="col">Price</th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${category.products}" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td><a href="/products/${product.id}" class="text-decoration-none text-primary">
                                ${product.name}
                            </a></td>
                            <td>$${product.price}</td>
                            <td>
                                <form method="post" action="/categories/${category.id}/removeProduct" style="display: inline;">
                                    <input type="hidden" name="productId" value="${product.id}">
                                    <button type="submit" class="btn btn-danger btn-sm">Remove</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            
            <c:if test="${empty category.products}">
                <div class="alert alert-info">
                    No products assigned to this category yet.
                </div>
            </c:if>
        </div>

        <h3 class="mt-4">Add Product</h3>
        <form method="post" action="/categories/${category.id}/addProduct" class="mt-4">
            <div class="mb-3">
                <label for="product" class="form-label">Select Product</label>
                <select name="productId" id="product" class="form-select">
                    <option value="">-- Select Product --</option>
                    <c:forEach items="${availableProducts}" var="product">
                        <option value="${product.id}">${product.name} - $${product.price}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    </div>
</body>
</html>