<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RogueGames.it</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">	
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,0,0">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/header.css">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-light">
        <div class="collapse navbar-collapse" id="navbarNav">
            <img src="images\RogueGameLogo.png	" class="logo" alt="Logo">
        	<p class="navbar2">Rogue</p>
        	<p class="navbar1">Games</p>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<%= request.getContextPath() %>/testbd?paramName=Quantita" method="POST"><i class="fas fa-heart "></i> Prodotti</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href=""><i class="fas fa-user"></i> Account</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href=""><i class="fas fa-shopping-cart"></i> Carrello</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search for products" aria-label="Search">
                <button class="btn my-2 my-sm-0" type="submit">Cerca</button>
            </form>
        </div>
    </nav>
    </header>
</body>
</html>

