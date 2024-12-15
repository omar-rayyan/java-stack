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
                <h2>Send an Omikuji!</h2>
            </div>
            <div class="card-body">
                <form action="/sendOmikuji" method="POST">
                    <div class="form-group">
                        <label for="number">Pick any number from 5 to 25</label>
                        <input type="number" id="number" name="number" min="5" max="25" class="form-control" placeholder="0" required>
                    </div>
                    <div class="form-group">
                        <label for="city">Enter the name of any city</label>
                        <input type="text" id="city" name="city" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="person">Enter the name of any real person</label>
                        <input type="text" id="person" name="person" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="hobby">Enter professional endeavor or hobby</label>
                        <input type="text" id="hobby" name="hobby" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="animal">Enter any type of living thing</label>
                        <input type="text" id="animal" name="animal" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="message">Say something nice to someone</label>
                        <textarea id="message" name="message" rows="3" class="form-control" placeholder="You do not realize how happy you make others." required></textarea>
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">Send</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.4.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>