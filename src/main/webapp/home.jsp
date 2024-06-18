<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/home.css" type="text/css">
    <script src="script/slider.js"></script>
</head>
<body>
        
        <div id="slider">
          <button onclick="prec()"><</button>
          <div id="img_slider">
              <img src="images/DragonsBanner.jpg">
              <img src="images/EldenringBanner.jpg">
              <img src="images/XboxBanner.jpg">
              <img src="images/SwitchBanner.jpg">
              <img src="images/Ps5Banner.jpg">
          </div>
          <button onclick="succ()">></button>
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
        
        <footer>
            <p>&copy; 2024 Product Store. All rights reserved.</p>
        </footer>
    </div>
</body>
</html>
