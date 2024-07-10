<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Profilo Utente</title>
    <link rel="stylesheet" href="css/Profilo.css" type="text/css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,0,0">
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
                    <a href="modificaCampo.jsp?field=nome" class="modify-btn">Modifica</a>
                </div>
                <div class="detail-item">
                    <h2>Cognome:</h2>
                    <p><%= cl.getCognome() %></p>
                    <a href="modificaCampo.jsp?field=cognome" class="modify-btn">Modifica</a>
                </div>
                <div class="detail-item">
                    <h2>Email:</h2>
                    <p><%= cl.getEmail() %></p>
                </div>
                <div class="detail-item">
                    <h2>Telefono:</h2>
                    <p><%= cl.getTelefono() %></p>
                    <a href="modificaCampo.jsp?field=telefono" class="modify-btn">Modifica</a>
                </div>
                <div class="detail-item">
                    <h2>Password:</h2>
                    <p>********</p>
                    <a href="modificaCampo.jsp?field=password" class="modify-btn">Modifica</a>
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