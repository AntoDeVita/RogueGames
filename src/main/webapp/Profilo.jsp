<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="it">
<head>
	<link rel="shortcut icon" href="#">
    <meta charset="UTF-8">
    <title>Profilo Utente</title>
    <link rel="stylesheet" href="css/Profilo.css" type="text/css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,0,0">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	
</head>
<body>
<%@ include file="./fragments/header.jsp" %> 
<%
    clienteRegBean cl = (clienteRegBean) request.getSession().getAttribute("cl");
    if (cl != null) {
    	
%>
	
	
    <div class="profile-container">
        <div class="profile-header">
            <h1>Profilo Utente</h1>
        </div>
        <div class="profile-content">
            <div class="profile-image">
                <img src="images/profilo.jpg" alt="Immagine Profilo" class="profile-pic">
            </div>
            <div class="profile-details">
                <div class="detail-item">
                    <h2>Nome:</h2>
                    <p><%= cl.getNome() %></p>
                    <a href="modificaCampo.jsp?field=nome" type="button"  class="modify-btn">Modifica</a>
                </div>
                <div class="detail-item">
                    <h2>Cognome:</h2>
                    <p><%= cl.getCognome() %></p>
                    <a href="modificaCampo.jsp?field=cognome" type="button" class="modify-btn">Modifica</a>
                </div>
                <div class="detail-item">
                    <h2>Email:</h2>
                    <p><%= cl.getEmail() %></p>
                </div>
                <div class="detail-item">
                    <h2>Telefono:</h2>
                    <p><%= cl.getTelefono() %></p>
                    <a href="modificaCampo.jsp?field=telefono" type="button" class="modify-btn">Modifica</a>
                </div>
                <div class="detail-item">
                    <h2>Password:</h2>
                    <p>********</p>
                    <a href="modificaCampo.jsp?field=password" type="button" class="modify-btn">Modifica</a>
                </div>
                <div class="detail-item">
    				<h2>Carta di Credito:</h2>
    				<button type="button" class="modify-btn" data-toggle="modal" data-target="#creditCardModal">Aggiungi Carta di Credito</button>
    				<button type="button" class="modify-btn" id="deleteCardsBtn" data-toggle="modal" data-target="#deleteCardsModal">Cancella Carte di Credito</button> 
					</div>
				<div class="detail-item">
					<h2>Indirizzo Spedizione:</h2>
					<button type="button" class="modify-btn" data-toggle="modal" data-target="#shippingModal">Inserisci Indirizzo di Spedizione</button> 
					<button type="button" class="modify-btn" id="deleteAddressesBtn" data-toggle="modal" data-target="#addressModal">Elimina Indirizzi</button>
            	</div>
            	<div class="detail-item"> 
            		<h2>Visualizza Ordini:</h2>  				
					<form action="<%= request.getContextPath() %>/profiloServlet" method="POST">
						<input type="hidden" name="param" value="<%=cl.getEmail()%>">
						<input type="submit" class="adminBtn" value="Cronologia Ordini">
					</form>
				</div>
				<div class="detail-item">
    				<h2>Punti:</h2>
    				<p><%= cl.getPunti()%></p>
				</div>
					</div>
                </div>
           <div id="deleteCardsModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="deleteCardsModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteCardsModalLabel">Elimina Carte di Credito</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div id="card-container"></div> <!-- Will be filled with cards -->
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Chiudi</button>
            </div>
        </div>
    </div>
</div>

        </div>
        
    </div>
<script src="script/AJXCredit.js"></script>
    
    <div class="modal fade" id="creditCardModal" tabindex="-1" role="dialog" aria-labelledby="creditCardModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="creditCardModalLabel">Inserisci Carta di Credito</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="<%= request.getContextPath() %>/creditCardServlet" method="post">
                    <input type="hidden" name="field" value="1">
                        <div class="form-group">
                            <label for="cardNumber">Numero Carta</label>
                            <input type="text" class="form-control" id="cardNumber" name="Cif" required pattern="\d{16}" title="Inserisci un numero di carta valido di 16 cifre">
                        </div>
                        <div class="form-group">
                            <label for="cvv">CVV</label>
                            <input type="text" class="form-control" id="cvv" name="cvv" required pattern="\d{3}" title="Inserisci un CVV valido di 3 cifre">
                        </div>
                        <div class="form-group">
                            <label for="expiryDate">Data di Scadenza</label>
                            <input type="month" class="form-control" id="Scadenza" name="Scadenza" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Salva</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
   <script src="script/indirizzoProfilo.js"></script>
    <div id="addressModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="addressModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addressModalLabel">Indirizzi di Spedizione</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div id="address-container"></div>
            </div>
        </div>
    </div>
</div>

<div id="shippingModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="shippingModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="shippingModalLabel">Indirizzo di Spedizione</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="<%= request.getContextPath() %>/indirizzoSpedizioneProfiloServlet" method="post">
                <input type="hidden" name="action" value="add">
                    <div class="form-group">
                        <label for="via">Via</label>
                        <input type="text" class="form-control" id="via" name="via" required>
                    </div>
                    <div class="form-group">
                        <label for="civico">Civico</label>
                        <input type="text" class="form-control" id="civico" name="civico" required>
                    </div>
                    <div class="form-group">
                        <label for="cap">CAP</label>
                        <input type="text" class="form-control" id="cap" name="cap" required>
                    </div>
                    <div class="form-group">
                        <label for="provincia">Provincia</label>
                        <input type="text" class="form-control" id="provincia" name="provincia" required>
                    </div>
                    <div class="form-group">
                        <label for="citta">Città</label>
                        <input type="text" class="form-control" id="citta" name="citta" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Salva Indirizzo</button>
                </form>
            </div>
        </div>
    </div>
</div>
    
<%
    } else {
%>
    <div class="no-profile">
        <h2>Profilo non trovato. Effettua il login per visualizzare i dettagli del tuo profilo.</h2>
    </div>
<%
    }
%>
 <%@ include file="./fragments/Footer.jsp" %> 


</body>
</html>