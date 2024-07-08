<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.*" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Modifica Campo</title>
    <link rel="stylesheet" href="css/Profilo.css" type="text/css">
</head>
<body>
<%@ include file="./fragments/header.jsp" %> 
<%
    clienteRegBean cl = (clienteRegBean) request.getSession().getAttribute("cl");
    if (cl != null) {
        String field = request.getParameter("field");
        String fieldValue = "";
        switch (field) {
            case "nome":
                fieldValue = cl.getNome();
                break;
            case "cognome":
                fieldValue = cl.getCognome();
                break;
            case "email":
                fieldValue = cl.getEmail();
                break;
            case "telefono":
                fieldValue = cl.getTelefono();
                break;
            case "password":
                fieldValue = ""; // Non mostrare la password
                break;
            default:
                fieldValue = "Campo non valido";
                break;
        }
%>
    <div class="profile-container">
        <div class="profile-header">
            <h1>Modifica <%= field %></h1>
        </div>
        <div class="profile-content">
            <form action="modificaProfiloServlet" method="post">
                <input type="hidden" name="field" value="<%= field %>">
                <div class="detail-item">
                    <label for="newValue"><%= field.substring(0, 1).toUpperCase() + field.substring(1) %>:</label>
                    <input type="text" id="newValue" name="newValue" value="<%= fieldValue %>">
                </div>
                <div class="detail-item">
                    <button type="submit" class="modify-btn">Salva</button>
                </div>
            </form>
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
