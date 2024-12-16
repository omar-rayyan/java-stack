<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reading Books</title>
</head>
<body>
<h1>${book.getTitle()}</h1>
<p>Description: ${book.getDescription()}</p>
<p>Language: ${book.getLanguage()}</p>
<p>Number of Pages: ${book.getNumberOfPages()}</p>
</body>
</html>