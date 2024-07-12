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
		<script src="script/checktext.js" defer></script>
	</head>
	<body>
	    <%@ include file="./fragments/header.jsp" %>
	    <p class="cat">Catalogo<span class="cat" id="cat2"> Prodotti</span></p>
		<button class="adminBtn" style="margin-left: 10px" onclick="showPopupAggiungi()">Aggiungi Un Prodotto</button>
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
            		if (!products.isEmpty()) {
                		for (prodottoBean bean : products) {
      			%>
			        <tr>
			            <td><%=bean.getIdProdotti() %></td>
			            <td><%=bean.getNome() %></td>
			            <td><%=bean.getImmagine() %></td>
			            <td><textarea readonly style="border: none"><%=bean.getDescrizione() %></textarea></td>
			            <td><%=bean.getCoV() %></td>
			            <td><%=bean.getPrezzo() %></td>
			            <td><%=bean.getCasaProduttrice() %></td>
			            <td><%=bean.getPiattaforma() %></td>
			            <td><%=bean.getGenere() %></td>
			            <td><%=bean.getTipo() %></td>
			            <td><%=bean.getDataRilascio() %></td>
			            <td><%=bean.getQuantita() %></td>
			            <td><button class="adminBtn" onclick="showPopupModifica('<%=bean.getIdProdotti() %>','<%=bean.getNome() %>','<%=bean.getImmagine() %>','<%=bean.getDescrizione() %>','<%=bean.getCoV() %>','<%=bean.getPrezzo() %>','<%=bean.getCasaProduttrice() %>','<%=bean.getPiattaforma() %>','<%=bean.getGenere() %>','<%=bean.getTipo() %>','<%=bean.getDataRilascio() %>','<%=bean.getQuantita() %>')">Modifica</button>
			        	<button style="margin-top:10px" class="adminBtn" onclick="showPopupElimina('<%=bean.getIdProdotti() %>','<%=bean.getNome() %>')">Elimina</button></td> 
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
			<form action="<%= request.getContextPath() %>/adminOperationServlet" method="POST"><%--Bottone Conferma Modifica act= 3 --%>
			    <h2 id="prodTit">Prodotto</h2>
		        <p>Id Prodotto: <span id="idProdotto"></span></p>
		        <p>Nome: <input type="text" id="nome" name="nome"></input></p>
		        <p>Immagine: <input type="text" id="img" name="img"></input></p>
		        	<div style="display:flex">
						<p>Descrizione: </p>
						<textarea style="margin-left:5px" id="dsc" name="dsc" placeholder="Descrizione"></textarea>
				    </div>
		        <p>CoV: <select id="cov" name="cov">
						  <option value="true">True</option>
						  <option value="false">False</option>
						</select></p>
		        <p>Prezzo: <input type="number" step="0.01" id="prz" name="prz" onblur="controllaPrezzo(this)"></input></p>
		        <p>Casa Produttrice: <input type="text" id="casaPrd" name="casaPrd"></input></p>
		        <p>Piattaforma: <select id="pltf" name="pltf">
											<option value="PlayStation">PlayStation</option>
											<option value="Xbox">Xbox</option>
											<option value="Pc">Pc</option>
											<option value="Nintendo Switch">Nintendo Switch</option>
											<option value="null">Nessuna</option>
										</select></p>
		        <p>Genere: <input type="text" id="gnr" name="gnr"></input></p>
		        <p>Tipo: <select id="tipo" name="tipo">
								 	<option value="Videogiochi">Videogiochi</option>
									<option value="Console">Console</option>
									<option value="AF">AF</option>
									<option value="Accessori">Accessori</option>
								 </select></p>
		        <p>Data Rilascio: <input type="date" id="releaseDate" name="releaseDate"></input></p>
		        <p>Quantità: <input type="number" id="qnt" name="qnt" onblur="controllaQuantita(this)"></input></p>
		        <div class="btnCont">
			        <button class="adminBtn" onclick="hidePopupModifica()">Chiudi</button>
					<input type="hidden" name="act" value="3">
					<input type="hidden" id="id2" name="idProdotto" value="">
			       	<input type="submit" class="adminBtn" value="Conferma"></input>
		        </div>
	        </form>
		</div>
		
		<div id="overlayElimina" onclick="hidePopupElimina()"></div>
		<div id="popupElimina">
		    <h2 id="prodTit">Elimina Prodotto</h2>
		        <form action="<%= request.getContextPath() %>/adminOperationServlet" method="POST"><%--Bottone Conferma Eliminazione act= 1 --%>
	        		<p>Vuoi eliminare il prodotto: <span id="Nome"></span> ?</p>
		        	<div class="btnCont">
		        		<input type="hidden" name="act" value="1">
		        		<input type="hidden" id="id" name="idProdotto" value="">
			       		<a class="adminBtn" onclick="hidePopupElimina()">Chiudi</a>
			       		<input type="submit" class="adminBtn" value="Conferma"></input>
					</div>
		        </form>
	        </div>
		
		<div id="overlayAggiungi" onclick="hidePopupAggiungi()"></div>
			<div id="popupAggiungi">
				<form action="<%= request.getContextPath() %>/adminOperationServlet" method="POST"><%--Bottone Conferma Aggiunta act= 2 --%>
				    <h2 id="prodTit">Aggiungi Prodotto</h2>
			        <p>Nome: <input type="text" name="nome" placeholder="Nome"></input></p>
			        <p>Immagine: <input type="file" name=img placeholder="Es.images/img.jpg"></input></p>
			        <div style="display:flex">
				        <p>Descrizione: </p>
				        <textarea style="margin-left:5px" name="dsc" placeholder="Descrizione"></textarea>
			        </div>
			        <p>CoV: <select name="cov">
								<option value="true">True</option>
								<option value="false">False</option>
							</select></p>
			        <p>Prezzo: <input type="number" name="prz" step="0.01" placeholder="Prezzo" onblur="controllaPrezzo(this)"></input></p>
			        <p>Casa Produttrice: <input type="text" name="casaPrd" placeholder="Casa Produttrice"></input></p>
			        <p>Piattaforma: <select name="pltf">
										<option value="PlayStation">PlayStation</option>
										<option value="Xbox">Xbox</option>
										<option value="Pc">Pc</option>
										<option value="Nintendo Switch">Nintendo Switch</option>
										<option value="null">Nessuna</option>
									</select></p>
			        <p>Genere: <input type="text" name="gnr" maxlenght="45" title="Genere troppo lungo" placeholder="Es.Fantasy"></input></p>
			        <p>Tipo: <select name="tipo">
							 	<option value="Videogiochi">Videogiochi</option>
								<option value="Console">Console</option>
								<option value="AF">AF</option>
								<option value="Accessori">Accessori</option>
							 </select></p>
			        <p>Data Rilascio: <input type="date" name="releaseDate"></input></p>
			        <p>Quantità: <input type="number" name="qnt" onBlur="controllaQuantita(this)" placeholder="Quantità"></p>
			        <div class="btnCont">
				        <a class="adminBtn" onclick="hidePopupAggiungi()">Chiudi</a>
				       	<input type="submit" class="adminBtn" value="Conferma"></input>
				       	<input type="hidden" name="act" value="2">
					</div>
		    </form>
			</div>
		
	    <%@ include file="./fragments/Footer.jsp" %>   
	</body>
</html>
