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
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/home.css" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/15.8.0/noUiSlider.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/15.8.0/noUiSlider.min.js"></script>
    <script src="script/slider.js" defer></script>
    <script src="script/sliderAjax.js" defer></script>
    <script src="script/prodottiRandom.js" defer></script>
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
    
    <div class="container">
        <div class="row">
            <div class="col-6 col-md-3">
                <div class="item-grid" data-name="Xbox">
                    <a href="Piattaforma?piattaforma=Xbox">
                        <img src="images/xboxLogo.png" class="img-fluid" alt="Xbox">
                    </a>
                </div>
            </div>
            <div class="col-6 col-md-3">
                <div class="item-grid" data-name="Ps5">
                    <a href="Piattaforma?piattaforma=PlayStation">
                        <img src="images/ps5Logo.png" class="img-fluid" alt="Ps5">
                    </a>
                </div>
            </div>
            <div class="col-6 col-md-3">
                <div class="item-grid" data-name="Switch">
                    <a href="Piattaforma?piattaforma=Nintendo Switch">
                        <img src="images/switchLogo.jpg" class="img-fluid" alt="Switch">
                    </a>
                </div>
            </div>
            <div class="col-6 col-md-3">
                <div class="item-grid" data-name="Pc">
                    <a href="Piattaforma?piattaforma=Pc">
                        <img src="images/pcLogo.jpg" class="img-fluid" alt="Pc">
                    </a>
                </div>
            </div>
        </div>
    </div>

    <!--<hr class="divider">
    
    <div class="container">
        <h1 class="miniTitle">Fantasy</h1>
        <div class="slider-wrapper">
            <div id="productContainerFantasy" class="slider-content"></div>
            <div id="sliderBarFantasy" class="slider-bar"></div>
        </div>
    </div>
    
    <hr class="divider">
    
    <div class="container">
        <h1 class="miniTitle">Console</h1>
        <div class="slider-wrapper">
            <div id="productContainerConsole" class="slider-content"></div>
            <div id="sliderBarConsole" class="slider-bar"></div>
        </div>
    </div>-->
    
    <hr class="divider">

    <!-- Slider Fantasy -->
    <div class="container">
        <h1 class="miniTitle">Fantasy</h1>
        <div class="slider-wrapper">
            <div id="productContainerFantasy" class="slider-content">
                <!-- Products will be loaded here -->
            </div>
            <div id="sliderBarFantasy" class="slider-bar">
                <!-- The scrollbar and handle will be added dynamically -->
            </div>
            <div id="productControlsFantasy" class="slider-controls">
                <button id="prev-slide-fantasy" class="slide-button">❮</button>
                <button id="next-slide-fantasy" class="slide-button">❯</button>
            </div>
        </div>
    </div>

    <hr class="divider">

    <!-- Slider Console -->
    <div class="container">
        <h1 class="miniTitle">Console</h1>
        <div class="slider-wrapper">
            <div id="productContainerConsole" class="slider-content">
                <!-- Products will be loaded here -->
            </div>
            <div id="sliderBarConsole" class="slider-bar">
                <!-- The scrollbar and handle will be added dynamically -->
            </div>
            <div id="productControlsConsole" class="slider-controls">
                <button id="prev-slide-console" class="slide-button">❮</button>
                <button id="next-slide-console" class="slide-button">❯</button>
            </div>
        </div>
    </div>

    <input type="hidden" id="genreParamFantasy" value="fantasy">
    <input type="hidden" id="genreParamConsole" value="Console">  
    
    <hr class="divider">
    
    <div class="llallero" id="productContainerElectronics">
    </div>

    <%@ include file="./fragments/Footer.jsp" %>  

    <script src="https://kit.fontawesome.com/a076d05399.js"></script>

</body>
</html>
