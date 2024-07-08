<%@ page contentType="text/html;charset=UTF-8" language="java" import="model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Profilo Utente</title>
    <link rel="stylesheet" href="css/Profilo.css" type="text/css">
</head>
<body>
<%
    clienteRegBean cl = (clienteRegBean) request.getSession().getAttribute("cl");
    if (cl != null) {
%>
    <div class="profile-container">
        <div class="profile-header">
            <h1>Profilo Utente</h1>
        </div>
        <div class="profile-content">
            <div class="profile-details">
                <h2><%= cl.getNome() != null ? cl.getNome() : "Nome non disponibile" %></h2>
                <p class="email"><strong>Email:</strong> <%= cl.getEmail() != null ? cl.getEmail() : "Email non disponibile" %></p>
                <p class="address"><strong>Indirizzo:</strong> <%= cl.getIndirizzo() != null ? cl.getIndirizzo() : "Indirizzo non disponibile" %></p>
                <p class="phone"><strong>Telefono:</strong> <%=  cl.getTelefono() %></p>
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
</body>
</html>


