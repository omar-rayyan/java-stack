<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
    	<a href="/" class="btn btn-secondary mb-3">Back to Home</a>
        <h1>Product Details</h1>
        <p><strong>Name:</strong> ${product.name}</p>
        <p><strong>Description:</strong> ${product.description}</p>
        <p><strong>Price:</strong> $${product.price}</p>
        <p><strong>Categories:</strong> ${product.categories.size()}</p>

        <div class="container mt-3">
		    <h3>Categories</h3>
		    <table class="table table-striped table-bordered">
		        <thead class="table-dark">
		            <tr>
		                <th scope="col">#</th>
		                <th scope="col">Category Name</th>
		                <th scope="col">Actions</th>
		            </tr>
		        </thead>
		        <tbody>
		            <c:forEach var="category" items="${product.categories}" varStatus="status">
		                <tr>
		                    <td>${status.count}</td>
		                    <td><a href="/categories/${category.id}" class="text-decoration-none text-primary">
                                ${category.name}
                            </a></td>
		                    <td>
		                        <form method="post" action="/products/${product.id}/removeCategory" style="display: inline;">
		                            <input type="hidden" name="categoryId" value="${category.id}">
		                            <button type="submit" class="btn btn-danger btn-sm">Remove</button>
		                        </form>
		                    </td>
		                </tr>
		            </c:forEach>
		        </tbody>
		    </table>
		    <c:if test="${empty product.categories}">
		        <div class="alert alert-info">
		            No categories assigned to this product yet.
		        </div>
		    </c:if>
		</div>

        <h3 class="mt-4">Add Category</h3>
        <form method="post" action="/products/${product.id}/addCategory" class="mt-4">
		    <div class="mb-3">
		        <label for="category" class="form-label">Select Category</label>
		        <select name="categoryId" id="category" class="form-select">
		            <option value="">-- Select Category --</option>
		            <c:forEach items="${availableCategories}" var="category">
		                <option value="${category.id}">${category.name}</option>
		            </c:forEach>
		        </select>
		    </div>
		    <button type="submit" class="btn btn-primary">Add</button>
		</form>
    </div>
</body>
</html>