<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Store</title>
    <link rel="stylesheet" type="text/css" href="css/header.css">
</head>
<body>
    <header>
        <div class="logo">
            <h1>RogueGames</h1>
        </div>
        <nav>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="products.jsp">Products</a></li>
                <li><a href="about.jsp">About Us</a></li>
                <li><a href="contact.jsp">Contact</a></li>
            </ul>
        </nav>
        <div class="search-bar">
            <form action="search.jsp" method="get">
                <input type="text" name="query" placeholder="Search products...">
                <button type="submit">Search</button>
            </form>
        </div>
    </header>
</body>
</html>

