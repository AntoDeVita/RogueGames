<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.*, java.util.*"%>
<!DOCTYPE html>
<%
    List<prodottoBean> products = (List<prodottoBean>) request.getAttribute("products");
%>
<html lang="en">
	<head>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>RogueGames.it</title>
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,0,0">
	    <link rel="stylesheet" href="css/admin.css" type="text/css">
		<script src="script/Popup.js" defer></script>
	</head>
	<body>
	    <%@ include file="./fragments/header.jsp" %>  
	    <div class="btnCont" id="top"> 
			<button style="margin-top: 25px" class="adminBtn" onclick="showPopupElimina()">Elimina Un Prodotto</button>
			<button style="margin-top: 25px" class="adminBtn" onclick="showPopupAggiungi()">Aggiungi Un Prodotto</button>
		    <p id="cat">Catalogo</p>
	    </div>
			<table border="1">
			    <thead>
			        <tr>
			            <th id="a">Id Prodotto</th>
			            <th id="b">Nome</th>
			            <th id="a">Immagine</th>
			            <th id="b">Descrizione</th>
			            <th id="a">CoV</th>
			            <th id="b">Prezzo</th>
			            <th id="a">Casa Produttrice</th>
			            <th id="b">Piattaforma</th>
			            <th id="a">Genere</th>
			            <th id="b">Tipo</th>
			            <th id="a">Data Rilascio</th>
			            <th id="b">Quantità</th>
			            <th id="a"></th>
			        </tr>
			    </thead>
			    <tbody>
			    <%
            		if (products != null && !products.isEmpty()) {
                		for (prodottoBean bean : products) {
      			%>
			        <tr>
			            <td><%=bean.getIdProdotti() %></td>
			            <td><%=bean.getNome() %></td>
			            <td><%=bean.getImmagine() %></td>
			            <td><%=bean.getDescrizione() %></td>
			            <td><%=bean.getCoV() %></td>
			            <td><%=bean.getPrezzo() %></td>
			            <td><%=bean.getCasaProduttrice() %></td>
			            <td><%=bean.getPiattaforma() %></td>
			            <td><%=bean.getGenere() %></td>
			            <td><%=bean.getTipo() %></td>
			            <td><%=bean.getDataRilascio() %></td>
			            <td><%=bean.getQuantita() %></td>
			            <td><button class="adminBtn" onclick="showPopupModifica('<%=bean.getIdProdotti() %>','<%=bean.getNome() %>','<%=bean.getImmagine() %>','<%=bean.getDescrizione() %>','<%=bean.getCoV() %>','<%=bean.getPrezzo() %>','<%=bean.getCasaProduttrice() %>','<%=bean.getPiattaforma() %>','<%=bean.getGenere() %>','<%=bean.getTipo() %>','<%=bean.getDataRilascio() %>','<%=bean.getQuantita() %>')">Modifica</button></td>
			        </tr>
			    <%
                	}
            		} else {
        		%>
        			<h2>No products available</h2>
        		<%
            		}
       	 		%>
			    </tbody>
			</table>
			
		<div id="overlayModifica" onclick="hidePopupModifica()"></div>
		<div id="popupModifica">
		    <h2 id="prodTit">Prodotto</h2>
	        <p>Id Prodotto: <span id="idProdotto"></span></p>
	        <p>Nome: <input type="text" id="nome"></input></p>
	        <p>Immagine: <input type="text" id=img></input></p>
	        <p>Descrizione: <input type="text" id="dsc"></input></p>
	        <p>CoV: <select id="cov">
					  <option value="true">True</option>
					  <option value="false">False</option>
					</select></p>
	        <p>Prezzo: <input type="text" id="prz"></input></p>
	        <p>Casa Produttrice: <input type="text" id="casaPrd"></input></p>
	        <p>Piattaforma: <input type="text" id="pltf"></input></p>
	        <p>Genere: <input type="text" id="gnr"></input></p>
	        <p>Tipo: <input type="text" id="tipo"></input></p>
	        <p>Data Rilascio: <input type="text" id="releaseDate"></input></p>
	        <p>Quantità: <input type="text" id="qnt"></input></p>
	        <div class="btnCont">
		        <button class="adminBtn" onclick="hidePopupModifica()">Chiudi</button>
		        <form action="" method="POST"><%--Bottone Conferma Modifica act= 3 --%>
		       		<input type="submit" class="adminBtn" value="Conferma"></input>
		        </form>
	        </div>
		</div>
		
		<div id="overlayElimina" onclick="hidePopupElimina()"></div>
		<div id="popupElimina">
		    <h2 id="prodTit">Elimina Prodotto</h2>
	        
		        
		        <form action="<%= request.getContextPath() %>/adminOperationServlet?act=1" method="POST"><%--Bottone Conferma Eliminazione act= 1 --%>
		        	<p>Inserisci l'id del prodotto: <input type="text" id="idProdotto" placeholder="Id Prodotto"></input></p>
		        	<div class="btnCont">
			       		<a class="adminBtn" onclick="hidePopupElimina()">Chiudi</a>
			       		<input type="submit" class="adminBtn" value="Conferma"></input>
					</div>
		        </form>
	        </div>
		
		<div id="overlayAggiungi" onclick="hidePopupAggiungi()"></div>
		<div id="popupAggiungi">
		    <h2 id="prodTit">Aggiungi Prodotto</h2>
	        <p>Nome: <input type="text" id="nome" placeholder="Nome"></input></p>
	        <p>Immagine: <input type="text" id=img placeholder="images/img.jpg"></input></p>
	        <p>Descrizione: <input type="text" id="dsc" placeholder="Descrizione"></input></p>
	        <p>CoV: <select id="cov">
						<option value="true">True</option>
						<option value="false">False</option>
					</select></p>
	        <p>Prezzo: <input type="text" id="prz" placeholder="Prezzo"></input></p>
	        <p>Casa Produttrice: <input type="text" id="casaPrd" placeholder="Casa Produttrice"></input></p>
	        <p>Piattaforma: <select id="pltf">
								<option value="PlayStation">PlayStation</option>
								<option value="Xbox">Xbox</option>
								<option value="Pc">Pc</option>
								<option value="Nintendo Switch">Nintendo Switch</option>
								<option value="null">Nessuna</option>
							</select></p>
	        <p>Genere: <select id="gnr">
							<option value="Funko">Funko</option>
							<option value="Statuette">Statuette</option>
							<option value="Console">Console</option>
							<option value="Azione">Azione</option>
							<option value="RPG">RPG</option>
							<option value="Fantasy">Fantasy</option>
							<option value="Sport">Sport</option>
							<option value="Sparatutto">Sparatutto</option>
							<option value="Horror">Horror</option>
							<option value="Tazza">Tazza</option>
							<option value="Peluche">Peluche</option>
						</select></p>
	        <p>Tipo: <select id="tipo">
					 	<option value="Videogiochi">Videogiochi</option>
						<option value="Console">Console</option>
						<option value="AF">AF</option>
						<option value="Accessori">Accessori</option>
					 </select></p>
	        <p>Data Rilascio: <input type="text" id="releaseDate" placeholder="AA-MM-GG"></input></p>
	        <p>Quantità: <input type="text" id="qnt" placeholder="Quantità"></input></p>
	        <div class="btnCont">
		        <button class="adminBtn" onclick="hidePopupAggiungi()">Chiudi</button>
		        <form action="" method="POST"><%--Bottone Conferma Aggiunta act= 2 --%>
		       		<input type="submit" class="adminBtn" value="Conferma"></input>
		        </form>
	        </div>
		</div>
		
	    <%@ include file="./fragments/Footer.jsp" %>   
	</body>
</html>
