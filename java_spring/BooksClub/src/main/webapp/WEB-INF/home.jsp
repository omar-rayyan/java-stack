<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home | Books Club</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>

<body class="bg-light">
    <div class="container py-4">
        <!-- Header Section -->
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h1 class="text-primary">Welcome, ${loggedUser.userName}!</h1>
            <a href="/logout" class="btn btn-link text-danger">Logout</a>
        </div>

        <!-- Table Section -->
        <h2 class="mb-3">Books from everyone's shelves:</h2>
        <table class="table table-striped table-bordered">
            <thead class="table-primary">
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Author Name</th>
                    <th>Posted By</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>${book.id}</td>
                        <td>
                            <a href="/books/${book.id}" class="text-decoration-none text-primary">
                                ${book.title}
                            </a>
                        </td>
                        <td>${book.author}</td>
                        <td>${book.user.userName}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Add to Shelf Button -->
        <div class="text-end mt-4">
            <a href="/books/new" class="btn btn-success">+ Add to my shelf!</a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
