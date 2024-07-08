<%@ page contentType="text/html; charset=UTF-8" language="java" import="model.*, java.util.*"%>

<%prodottoBean p= (prodottoBean) request.getAttribute("p"); %>

<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link rel="stylesheet" href="css/dettagliProdotto.css" type="text/css">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,0,0">
	</head>
	
	
	<body>   
	
		<%@ include file="./fragments/header.jsp" %>   
		
		<%
            if (p != null) {
        %>
		<div class="main">
			<strong class="titoloProd"><%=p.getNome() %></strong>
			<p class="sottoTitoloProd">by <strong style="color: #949494"><%=p.getCasaProduttrice() %></strong></p>
			<div class="gridMainInfo">
				<div class="imgContainer">
					<img src="<%=p.getImmagine() %>" class="img" alt="prodotto">
				</div>
				<div class="info">
					<p>Prezzo: <span style="font-size: 20px; color: black" ><%=p.getPrezzo() %>&euro;</span></p>
					<p>Genere: <span style="font-size: 20px; color: black" ><%=p.getGenere() %></span></p>
					<%if(p.getPiattaforma()!=null){ %>
					<p>Piattaforma: <span style="font-size: 20px; color: black" ><%=p.getPiattaforma() %></span></p>
					<%}%>
					<p>Data Rilascio: <span style="font-size: 20px; color: black" ><%=p.getDataRilascio() %></span></p>
					<p>Tipo: <span style="font-size: 20px; color: black" ><%=p.getTipo() %></span></p>
					<div class="btnAggiungi">
						<%if(p.getQuantita()>1) {%>
				      	<form action="<%= request.getContextPath() %>/carrelloServlet" method="POST">
                    		<button id="carrello" type="submit">Aggiungi 
                    			<img src="images/imgCarrello.png" style="width:30px; height: 30px" alt="carrello">
								<input type="hidden" name="param" value="<%=p.getIdProdotti() %>"/>
                    			<input type="hidden" name="act" value="add"/>
                    		</button>
               		 	</form>
               		 	<%}else{ 
							%>
                    		<button id="carrello" type="submit">Non Disponibile</button>
               		 	<%} %>
					</div>
				</div>
			</div>
			<div class="descrizione">
				<p class="titoloDescrizione">DESCRIZIONE</p>
				<p><%=p.getDescrizione() %></p>
			</div>
		</div>
		<%
			}
        %>
		
		<%@ include file="./fragments/Footer.jsp" %>
	</body>
</html>