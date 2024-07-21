<%@ page contentType="text/html;charset=UTF-8" language="java" import="model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="#">
    <title>Logout</title>
    <link rel="stylesheet" href="css/logout.css" type="text/css">
</head>
<body>
<% session.invalidate(); %>

         <div class="logout-container">
        <h1>Sei stato disconnesso</h1>
        <p>Hai effettuato il logout con successo.</p>
        <a href="home.jsp">Torna alla Home</a>
        <a href="login.jsp">Torna al login</a>
    </div>
    
             
    
</body>
</html>
