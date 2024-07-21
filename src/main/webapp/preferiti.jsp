<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  import="model.*, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<link rel="shortcut icon" href="#">
	<title>Preferiti</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/preferiti.css" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,0,0">
	<script src="script/Popup.js"></script>
	<script src="script/btnQuantita.js"></script>
</head>

<body>

		<%@ include file="./fragments/header.jsp" %>   
		<p class="cat">Preferiti</p>
		<%
		preferiti ppref = (preferiti) request.getSession().getAttribute("ppref");
		if(ppref != null && !ppref.isEmpty()){%>
		<div class="carrelloBtnContainer">
			<h3><button class="carrelloBtn" onclick="deleteAllButtonPref()">Rimuovi Tutto</button></h3>
		</div>
		
		<% 	List <pPreferitiBean> pref=ppref.getProdotti();
		Iterator<?> it = pref.iterator();
		while (it.hasNext()) {
			pPreferitiBean bean = (pPreferitiBean) it.next();
	%>

		<div class="contenitore-grid">
				<div class="item-grid" data-name="immagine">
	      		<img src="images/<%=bean.getProdotto().getImmagine()%>" class="img" alt="prod">
      		</div>
      		<div class="item-grid">
				<h1><%=bean.getProdotto().getNome() %></h1>
      		</div>
			<div class="item-grid">
		      	<h4><input class="set-prezzo" type="text" value="<%=bean.getPrezzo()%>" readonly>&#8364;</h4>
	      	</div>
	      	
	      	<div class="item-grid">
		      	<h5><button class="functionButton" onclick="deleteButtonPref('<%=bean.getIdProdotti() %>')">Rimuovi</button></h5>
	      	</div>
	      	</div>
	      		<%	}
		}
		else{
		%>
		<div class="contenitore-grid">
			<h2 style="margin: 20px">Nessun prodotto nei preferiti</h2>
		</div>	
		<% 
			}
		%>
		<%@ include file="./fragments/Footer.jsp" %>  
		
</body>
</html>