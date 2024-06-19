<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RogueGames.it</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">	
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,0,0">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/home.css" type="text/css">
    <script src="script/slider.js" defer></script>
</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-light">
        <div class="collapse navbar-collapse" id="navbarNav">
            <img src="images\RogueGameLogo.png	" class="logo" alt="Logo">
        	<p class="navbar2">Rogue</p>
        	<p class="navbar1">Games</p>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#"><i class="fas fa-heart "></i> Preferiti</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><i class="fas fa-user"></i> Account</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><i class="fas fa-shopping-cart"></i> Carrello</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search for products" aria-label="Search">
                <button class="btn my-2 my-sm-0" type="submit">Cerca</button>
            </form>
        </div>
    </nav>
    

    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleControls" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleControls" data-slide-to="1"></li>
            <li data-target="#carouselExampleControls" data-slide-to="2"></li>
            <li data-target="#carouselExampleControls" data-slide-to="3"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="images/XboxBanner.jpg" class="d-block w-100" alt="First slide">
            </div>
            <div class="carousel-item">
                <img src="images\DragonsBanner.jpg" class="d-block w-100" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img src="images\SwitchGame.jpg" class="d-block w-100" alt="Third slide">
            </div>
             <div class="carousel-item">
                <img src="images\funkoBanner.jpg" class="d-block w-100" alt="Fourth slide">
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

 		<div class="container">
 			<h1 class="miniTitle">Fantasy</h1>
 			<div class="slider-wrapper">
 				<button id="prev-slide" class="slide-button material-symbols-rounded">chevron_left</button>
 				<div class="image-list">
 					<img src="images/EldenRing.jpg" alt="Product 1" class="image-item">
 					<img src="images/Happy.jpg" alt="Product 2" class="image-item">
 					<img src="images/LinkAF.jpg" alt="Product 3" class="image-item">
 					<img src="images/PS5.png" alt="Product 4" class="image-item">
 					<img src="images/Xbox.jpg" alt="Product 5" class="image-item">
 					<img src="images/R6S.jpg" alt="Product 6" class="image-item">
 					<img src="images/R6S.jpg" alt="Product 7" class="image-item">
 				</div>
 				<button id="next-slide" class="slide-button material-symbols-rounded">chevron_right</button>
 			</div>
 			<div class="slider-scrollbar">
 				<div class="scrollbar-track">
 					<div class="scrollbar-thumb"> </div>
 				</div>
 			</div>
 		</div>
        
        <hr class="divider">
        
        <main>
            <section class="catalog">
                <div class="product">
                    <img src="images/EldenRing.jpg" alt="Product 1">
                    <h3>EldenRing</h3>
                    <p>$10.00</p>
                </div>
                <div class="product">
                    <img src="images/Happy.jpg" alt="Product 2">
                    <h3>Happy</h3>
                    <p>$20.00</p>
                </div>
                <div class="product">
                    <img src="images/LinkAF.jpg" alt="Product 3">
                    <h3>Link</h3>
                    <p>$30.00</p>
                </div>
                <div class="product">
                    <img src="images/PS5.png" alt="Product 4">
                    <h3>PS5</h3>
                    <p>$40.00</p>
                </div>
                <div class="product">
                    <img src="images/Xbox.jpg" alt="Product 5">
                    <h3>XBOX SX</h3>
                    <p>$50.00</p>
                </div>
                <div class="product">
                    <img src="images/R6S.jpg" alt="Product 6">
                    <h3>R6S</h3>
                    <p>$60.00</p>
                </div>
            </section>
        </main>
        
<footer class="footer bg-dark text-light text-center py-3">
    <div class="contenitoreFooter">
        <span>@2024 RogueGames.it</span>
    </div>
</footer>

<script src="https://kit.fontawesome.com/a076d05399.js"></script>

</body>
</html>