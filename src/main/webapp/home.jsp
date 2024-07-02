<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RogueGames.it</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <link rel="stylesheet" href="css/home.css" type="text/css">
</head>
<body>

	<jsp:include page="/header.jsp" />
    
    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleControls" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleControls" data-slide-to="1"></li>
            <li data-target="#carouselExampleControls" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="images\EldenringBanner.jpg" class="d-block w-100" alt="First slide">
            </div>
            <div class="carousel-item">
                <img src="https://via.placeholder.com/1920x900" class="d-block w-100" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img src="https://via.placeholder.com/1920x900" class="d-block w-100" alt="Third slide">
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
        
<jsp:include page="/Footer.jsp" />

<script src="https://kit.fontawesome.com/a076d05399.js"></script>

</body>
</html>