<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ora Prova Slidere</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<script src="script/slider.js"></script>
</head>
<body>

      <div id="slider">
          <button onclick="prec()"><</button>
          <div id="img_slider">
              <img src="images/EldenRing.jpg">
              <img src="images/Happy.jpg">
              <img src="images/LinkAF.jpg">
              <img src="images/PS5.png">
              <img src="images/Xbox.jpg">
          </div>
          <button onclick="succ()">></button>
       </div>
       
       <div class="divider"></div> 
  <div id="content">
    <p>Altre cose </p>
  </div>
</body>
</html>