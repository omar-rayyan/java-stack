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
    <title>Add Book | Books Club</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>

<body class="bg-light">
    <div class="container my-5">
        <header class="mb-4">
            <h1 class="text-center">Book Share</h1>
            <div class="text-center">
                <a href="/books" class="btn btn-link">Back to the shelves</a>
            </div>
        </header>

        <main class="card shadow p-4">
            <h2 class="text-center mb-4">Add a Book to Your Shelf!</h2>

            <form:form modelAttribute="book" action="/books/new" method="post">
                <!-- Title Input -->
                <div class="mb-3">
                    <form:label path="title" cssClass="form-label">Title</form:label>
                    <form:input path="title" cssClass="form-control" />
                    <form:errors path="title" cssClass="text-danger small" />
                </div>

                <!-- Author Input -->
                <div class="mb-3">
                    <form:label path="author" cssClass="form-label">Author</form:label>
                    <form:input path="author" cssClass="form-control" />
                    <form:errors path="author" cssClass="text-danger small" />
                </div>

                <!-- My Thoughts Input -->
                <div class="mb-3">
                    <form:label path="thoughts" cssClass="form-label">My thoughts</form:label>
                    <form:textarea path="thoughts" cssClass="form-control" rows="3"></form:textarea>
                    <form:errors path="thoughts" cssClass="text-danger small" />
                </div>

                <!-- Submit Button -->
                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form:form>
        </main>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
