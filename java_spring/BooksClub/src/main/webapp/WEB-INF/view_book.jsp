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
    <title>View Book | Books Club</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>

<body class="bg-light">
    <div class="container py-4">
        <!-- Header Section -->
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h1 class="text-primary" style="font-style: italic;">${book.title}</h1>
            <a href="/books" class="btn btn-link text-danger">Back to the shelves</a>
        </div>

        <h2 class="mb-3">
            <span class="text-danger" style="font-weight: bold;">${book.user.userName}</span> read 
            <span class="text-purple" style="font-weight: bold;">${book.title}</span> by 
            <span class="text-success" style="font-weight: bold;">${book.author}</span>.
        </h2>

        <h4 class="mb-3">Here are ${book.user.userName}'s thoughts:</h4>

        <hr class="my-4"> 

        <p class="fst-italic">${book.thoughts}</p> 
        
        <hr class="my-4"> 
    </div>

    <!-- Bootstrap 5 JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>


</html>
