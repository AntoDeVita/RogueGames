<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.*, java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="#">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RogueGames.it</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,0,0">
    <link rel="stylesheet" href="css/home.css" type="text/css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/home.css" type="text/css">
	<script src="script/slider.js" defer></script> 
	<script src="script/sliderAjax.js" defer></script>
</head>
	<body>
	
	    <%@ include file="./fragments/header.jsp" %>  
	
	    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
	        <ol class="carousel-indicators">
	            <li data-target="#carouselExampleControls" data-slide-to="0" class="active"></li>
	            <li data-target="#carouselExampleControls" data-slide-to="1"></li>
	            <li data-target="#carouselExampleControls" data-slide-to="2"></li>
	            <li data-target="#carouselExampleControls" data-slide-to="3"></li>
	        </ol>
	        <div class="carousel-inner">
	            <div class="carousel-item active" id="fant">
	                <img src="images/XboxBanner.jpg" class="d-block w-100" alt="First slide">
	            </div>
	            <div class="carousel-item">
	                <img src="images/DragonsBanner.jpg" class="d-block w-100" alt="Second slide">
	            </div>
	            <div class="carousel-item">
	                <img src="images/SwitchGame.jpg" class="d-block w-100" alt="Third slide">
	            </div>
	             <div class="carousel-item">
	                <img src="images/funkoBanner.jpg" class="d-block w-100" alt="Fourth slide">
	            </div>
	        </div>
	        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
	            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	            <span class="sr-only">Previous</span>
	        </a>
	        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
	            <span class="carousel-control-next-icon" aria-hidden="true"></span>
	            <span class="sr-only">Next</span>
	        </a>
	    </div>
	    
	    <hr class="divider">
	    
			    <div class="contenitore-grid">
		    <div class="item-grid" data-name="Xbox">
		        <a href="Piattaforma?piattaforma=Xbox">
		            <img src="images/xboxLogo.png" class="img" alt="Xbox">
		        </a>
		    </div>
		    <div class="item-grid" data-name="Ps5">
		        <a href="Piattaforma?piattaforma=PlayStation">
		            <img src="images/ps5Logo.png" class="img" alt="Ps5">
		        </a>
		    </div>
		    <div class="item-grid" data-name="Switch">
		        <a href="Piattaforma?piattaforma=Nintendo Switch">
		            <img src="images/switchLogo.jpg" class="img" alt="Switch">
		        </a>
		    </div>
		    <div class="item-grid" data-name="Pc">
		        <a href="Piattaforma?piattaforma=Pc"> 
		            <img src="images/pcLogo.jpg" class="img" alt="Pc">
		        </a>
		    </div>
		</div>

	
	    <hr class="divider">
	
	        <div class="container">
	        <h1 class="miniTitle">Fantasy</h1>
	        <div class="slider-wrapper">
	            <button id="prev-slide-fantasy" class="slide-button material-symbols-rounded">chevron_left</button>
	            <div class="image-list">
	                <div id="productContainerFantasy" class="slider-content"></div>
	            </div>
	            <button id="next-slide-fantasy" class="slide-button material-symbols-rounded">chevron_right</button>
	        </div>
	        <div class="slider-scrollbar">
	            <div class="scrollbar-track">
	                <div class="scrollbar-thumb"></div>
	            </div>
	        </div>
	    </div>
	    
	    <hr class="divider">
	    
	    <div class="container">
	        <h1 class="miniTitle">Console</h1>
	        <div class="slider-wrapper">
	            <button id="prev-slide-Console" class="slide-button material-symbols-rounded">chevron_left</button>
	            <div class="image-list">
	                <div id="productContainerConsole" class="slider-content"></div>
	            </div>
	            <button id="next-slide-Console" class="slide-button material-symbols-rounded">chevron_right</button>
	        </div>
	        <div class="slider-scrollbar">
	            <div class="scrollbar-track">
	                <div class="scrollbar-thumb"></div>
	            </div>
	        </div>
	    </div>
	
		<input type="hidden" id="genreParamFantasy" value="fantasy">
		<input type="hidden" id="genreParamConsole" value="Console">  
		
		<hr class="divider">
	
	    <main>
	        <section class="catalog">
	            <div class="product">
	            	<a style="text-decoration: none" href="<%= request.getContextPath() %>/dettagliServlet?param=5">
	                <img src="images/EldenRing.jpg" alt="Product 1">
	                <h3>EldenRing</h3>
	                <p>39.99&euro;</p>
	            </div>
	            <div class="product">
	            	<a style="text-decoration: none" href="<%= request.getContextPath() %>/dettagliServlet?param=8">
	                <img src="images/Happy.jpg" alt="Product 2">
	                <h3>Fairytail Happy Peluche</h3>
	                <p>10.97&euro;</p>
	            </div>
	            <div class="product">
	            	<a style="text-decoration: none" href="<%= request.getContextPath() %>/dettagliServlet?param=2">            
	                <img src="images/LinkAF.jpg" alt="Product 3">
	                <h3>The legend of Zelda Action figure Link</h3>
	                <p>651.57&euro;</p>
	            </div>
	            <div class="product">
	            	<a style="text-decoration: none" href="<%= request.getContextPath() %>/dettagliServlet?param=3">  
	                <img src="images/PS5.png" alt="Product 4">
	                <h3>PlayStation 5 Digital Edition</h3>
	                <p>399.99&euro;</p>
	            </div>
	            <div class="product">
	            	<a style="text-decoration: none" href="<%= request.getContextPath() %>/dettagliServlet?param=9">  
	                <img src="images/Xbox.jpg" alt="Product 5">
	                <h3>Xbox Series X</h3>
	                <p>479.99&euro;</p>
	            </div>
	            <div class="product">
	            	<a style="text-decoration: none" href="<%= request.getContextPath() %>/dettagliServlet?param=7">  	
	                <img src="images/R6S.jpg" alt="Product 6">
	                <h3>Tom Clancy's Rainbow Six Siege</h3>
	                <p>19.99&euro;</p>
	            </div>
	        </section>
	    </main>
	
	    <%@ include file="./fragments/Footer.jsp" %>  
	
	    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
	
	</body>
</html>