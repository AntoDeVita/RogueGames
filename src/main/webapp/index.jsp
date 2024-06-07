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
              <img src="https://i.postimg.cc/y8TYJX7B/immagine1.jpg">
              <img src="https://i.postimg.cc/kMhJKgr6/immagine2.jpg">
              <img src="https://i.postimg.cc/WbF2ncj9/immagine3.jpg">
              <img src="https://i.postimg.cc/15h9JYts/immagine4.jpg">
              <img src="https://i.postimg.cc/rmD8YBxF/immagine5.jpg">
          </div>
          <button onclick="succ()">></button>
       </div>
</body>
</html>