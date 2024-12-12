<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Current visit count</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.css" />
</head>
<body>
	<div class="container text-center my-5">
		<h1 class="display-4">
			You have visited 
			<a href="/" class="text-primary">http://localhost:8080</a> 
			<span class="badge bg-success">${visits}</span> time(s).
		</h1>
		<div class="mt-4">
			<a href="/" class="btn btn-primary me-2">Test another visit?</a>
			<a href="/reset" class="btn btn-danger">Reset Counter</a>
		</div>
	</div>
	<script src="/webjars/bootstrap/js/bootstrap.js"></script>
</body>
</html>