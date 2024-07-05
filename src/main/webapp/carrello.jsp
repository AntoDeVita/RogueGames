<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  import="model.*, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>

<head>
	<title>Carrello</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/carrello.css" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,0,0">
	<script src="script/btnQuantita.js"></script>
</head>

<body>
		<%@ include file="./fragments/header.jsp" %>   
		<div class="contenitore-grid">
		<%
		carrello pcart = (carrello) request.getSession().getAttribute("pcart");
		if(pcart != null && !pcart.isEmpty()){
			List <prodottoBean> cart=pcart.getProdotti();
			Iterator<?> it = cart.iterator();
			while (it.hasNext()) {
				prodottoBean bean = (prodottoBean) it.next();
	%>


				<div class="item-grid" data-name="immagine">
	      		<img src=<%=bean.getImmagine()%> class="img" alt="prod">
      		</div>
      		<div class="item-grid">
				<h1><%=bean.getNome() %></h1>
      		</div>
      		<div class="item-grid">	
				<button onclick="decrementButton('myTextBox<%=bean.getIdProdotti()%>', 'myTextBx<%=bean.getIdProdotti()%>', '<%=bean.getPrezzo()%>')"><</button>
			      	<input class="set-quantita" id="myTextBox<%=bean.getIdProdotti()%>" type="text" value="1" readonly="readonly">
			      	<button onclick="incrementButton('myTextBox<%=bean.getIdProdotti()%>', 'myTextBx<%=bean.getIdProdotti()%>', '<%=bean.getPrezzo()%>')">></button>

			    </div>
			<div class="item-grid">
		      	<h2><input class="set-prezzo" id="myTextBx<%=bean.getIdProdotti()%>" type="text" value="<%=bean.getPrezzo() %>" readonly="readonly"></h2>
	      	</div>
	      		<%	}
		}
		else{
		%>
	
		<h2>No products available</h2>
		<% 
			}
		%>
		</div>
		<%@ include file="./fragments/Footer.jsp" %>  
		
</body>
</html>
