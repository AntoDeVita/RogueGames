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
	<script src="script/Popup.js"></script>
</head>

<body>

		<%@ include file="./fragments/header.jsp" %>   
		<p class="cat">Carrello</p>
		<%
	    String sessionToken = UUID.randomUUID().toString();
	    session.setAttribute("sessionToken", sessionToken);
	    
		carrello pcart = (carrello) request.getSession().getAttribute("pcart");
		if(pcart != null && !pcart.isEmpty()){%>
		<div class="carrelloBtnContainer">
			<h3><button class="carrelloBtn" onclick="deleteAllButton()">Rimuovi Tutto</button></h3>
			<h3><button style="margin-left: 10px" class="carrelloBtn" onclick="showPopupOrdine()">Conferma Ordine</button></h3>
		</div>
		
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

				    <button class="functionButton" onclick="decrementButton('<%=bean.getIdProdotti() %>')"><</button>
				    <input class="set-quantita" id="myTextBox<%=bean.getProdotto().getIdProdotti()%>" type="text" value="<%=bean.getIdQuantita() %>" readonly="readonly">
				    <button class="functionButton" onclick="incrementButton('<%=bean.getIdProdotti() %>')">></button>
				
		    </div>
			<div class="item-grid">
		      	<h4><input class="set-prezzo" type="text" value="<%=bean.getPrezzo() %>" readonly></h2>
	      	</div>
	      	
	      	<div class="item-grid">
		      	<h5><button class="functionButton" onclick="deleteButton('<%=bean.getIdProdotti() %>')">Rimuovi</button></h2>
	      	</div>
	      	</div>
	      		<%	}
		}
		else{
		%>
		<div class="contenitore-grid">
			<h2 style="margin: 20px">No products available</h2>
		</div>	
		<% 
			}
		%>
		<%clienteRegBean cl=(clienteRegBean) request.getSession().getAttribute("cl");
		if(cl!=null){
		%>
		<div id="overlayOrdine" onclick="hidePopupOrdine()"></div>
		<div id="popupOrdine">
			<h2 id="prodTit">Vuoi confermare l'ordine</h2>
			 <a id="confirmOrderLink" class="cartBtn" href="#" onclick="confirmOrder()">Conferma</a>
		</div>	 
		<script>
		    function confirmOrder() {
		        // Ottieni il token di sessione dalla pagina
		        var sessionToken = '<%= session.getAttribute("sessionToken") %>';
		        
		        // Costruisci l'URL della servlet con il token di sessione come parametro
		        var servletUrl = 'Ordine?sessionToken=' + encodeURIComponent(sessionToken);
		        
		        // Modifica dinamicamente l'attributo href del link per puntare all'URL costruito
		        document.getElementById('confirmOrderLink').href = servletUrl;
		        
		        // Nascondi il popup o esegui altre azioni necessarie
		        hidePopupOrdine();
		    }
		</script>
		<%}else{%>
		<div id="overlayOrdine" onclick="hidePopupOrdine()"></div>
		<div id="popupOrdine">
			<h2 id="prodTit">Devi effettuare la login per poter acquistare i prodotti</h2>
			
		</div>
				<% 
			}
		%>
		
		<%@ include file="./fragments/Footer.jsp" %>  
		
</body>
</html>