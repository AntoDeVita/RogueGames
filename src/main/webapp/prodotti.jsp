<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  import="model.*, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
		List<prodottoBean> products = (List<prodottoBean>) request.getAttribute("products");
%>

<!DOCTYPE html>
<html>
<head>
	<title>Prodotti</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/carrello.css" type="text/css">
</head>

<body>
			<%@ include file="./fragments/header.jsp" %>   
			<div class="contenitore-grid">
	      		
		<%
			if (products != null && products.size() != 0) {
				Iterator<?> it = products.iterator();
				while (it.hasNext()) {
					prodottoBean bean = (prodottoBean) it.next();
		%>


					<div class="item-grid" data-name="immagine">
		      		<img src=<%=bean.getImmagine()%> class="img" alt="prod">
	      		</div>
	      		<div class="item-grid">
					<h1><%=bean.getNome() %></h1>
	      		</div>	
	      		 <div
	      		<%
					if (bean.getQuantita()>0) {	
				%>

	      			class="button">
		      	 <form action="<%= request.getContextPath() %>/carrelloServlet?act=addC&param=<%= bean.getIdProdotti() %>" method="GET">
    				<input type="submit" /> <!-- Esempio di bottone per l'azione "add" -->
				</form>

				<% 
				} else { 
				%>
					<h2>Esaurito</h2>
				<% 
					}
				%>				
		      	</div>
				<div class="item-grid">
			      	<h2><%=bean.getPrezzo()%>&euro;</h2>
		      	</div>
		      		<% }
			}
			else{
			%>
		
			<h2>No products available</h2>
			<% 
				}
			%>
			</div>

	
</body>
</html>
