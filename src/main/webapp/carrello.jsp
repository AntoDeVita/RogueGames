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
		
		<%
		carrello pcart = (carrello) request.getSession().getAttribute("pcart");
		if(pcart != null && !pcart.isEmpty()){%>
	
		<h3><button class="deleteAll" onclick="deleteAllButton()">Rimuovi Tutto</button></h3>
		
		<% 	List <pCarrelloBean> cart=pcart.getProdotti();
		Iterator<?> it = cart.iterator();
		while (it.hasNext()) {
			pCarrelloBean bean = (pCarrelloBean) it.next();
	%>

		<div class="contenitore-grid">
				<div class="item-grid" data-name="immagine">
	      		<img src=<%=bean.getProdotto().getImmagine()%> class="img" alt="prod">
      		</div>
      		<div class="item-grid">
				<h1><%=bean.getProdotto().getNome() %></h1>
      		</div>
      		<div class="item-grid">	

				    <button onclick="decrementButton('<%=bean.getIdProdotti() %>')"><</button>
				    <input class="set-quantita" id="myTextBox<%=bean.getProdotto().getIdProdotti()%>" type="text" value="<%=bean.getIdQuantita() %>" readonly="readonly">
				    <button onclick="incrementButton('<%=bean.getIdProdotti() %>')">></button>
				
		    </div>
			<div class="item-grid">
		      	
		      	<h4><input class="set-prezzo" type="text" value="<%=bean.getPrezzo() %>" readonly="readonly"></h2>
	      	</div>
	      	
	      	<div class="item-grid">
		      	<h5><button class="delete" onclick="deleteButton('<%=bean.getIdProdotti() %>')">Rimuovi</button></h2>
	      	</div>
	      	</div>
	      		<%	}
		}
		else{
		%>
		<div class="contenitore-grid">
			<h2>No products available</h2>
			</div>
		</div>	
		<% 
			}
		%>
		<%@ include file="./fragments/Footer.jsp" %>  
		
</body>
</html>ml>