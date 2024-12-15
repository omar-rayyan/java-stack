<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Omikuji</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="card shadow">
            <div class="card-header text-center bg-primary text-white">
                <h2>Here's Your Omikuji!</h2>
            </div>
            <div class="card-body bg-light text-center">
                <div class="p-3">
                    <p class="lead">
                        In <span class="font-weight-bold"><c:out value="${number}" /></span> years, 
                        you will live in <span class="font-weight-bold"><c:out value="${city}" /></span> 
                        with <span class="font-weight-bold"><c:out value="${person}" /></span> 
                        as your roommate, <span class="font-weight-bold"><c:out value="${hobby}" /></span> for a living.
                    </p>
                    <p class="lead">
                        The next time you see a <span class="font-weight-bold"><c:out value="${animal}" /></span>, 
                        you will have good luck.
                    </p>
                    <p class="lead">
                        Also, <span class="font-weight-bold"><c:out value="${message}" /></span>
                    </p>
                </div>
                <div class="mt-4">
                    <a href="/omikuji" class="btn btn-primary">Go Back</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.4.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
