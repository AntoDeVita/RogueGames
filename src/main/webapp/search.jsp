<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Results</title>
    <link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
    <div class="container">
        <h2>Search Results</h2>
        <p>Showing results for: <%= request.getParameter("query") %></p>
        <div class="result-item">
                <h3>Product 1</h3>
                <p>Description of Product 1...</p>
                <p>Price: $10.00</p>
            </div>
    </div>
</body>
</html>