<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.*, java.util.*"%>
<!DOCTYPE html>
<%
    List<ordineBean> ordini = (List<ordineBean>) request.getAttribute("ordini");
%>
<html lang="en">
	<head>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>RogueGames.it</title>
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,0,0">
	    <link rel="stylesheet" href="css/ordine.css" type="text/css">
		<script src="script/Popup.js" defer></script>
		<script src="script/checktext.js" defer></script>
	</head>
	<body>
		<%@ include file="./fragments/header.jsp" %>
		<p class="cat">Catalogo<span class="cat" id="cat2"> Ordini</span></p>
			<table border="1">
			    <thead>
			        <tr>
			            <th id="a">Id Ordine</th>
			            <th id="b">Id Prodotto</th>
			            <th id="a">Email</th>
			            <th id="b">Prezzo Totale</th>
			            <th id="a">Quantità</th>
			            <th id="b">Data</th>
			        </tr>
			    </thead>
			    <tbody>
			    <%
            		if (!ordini.isEmpty()) {
                		for (ordineBean bean : ordini) {
      			%>
			        <tr>
			            <td><%=bean.getIdOrdine() %></td>
			            <td><%=bean.getIdProdotto() %></td>
			            <td><%=bean.getEmail() %></td>
			            <td><%=bean.getPrezzoTot() %></td>
			            <td><%=bean.getQuantita() %></td>
			            <td><%=bean.getData() %></td>
			            </tr>
			    <%
                	}
            		} else {
        		%>
        			<h2>No orders available</h2>
        		<%
            		}
       	 		%>
			    </tbody>
			</table>
		<%@ include file="./fragments/Footer.jsp" %>   
	</body>
</html>