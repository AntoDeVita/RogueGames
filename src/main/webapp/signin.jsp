<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/signin.css" type="text/css">
    <script src="script/checktext.js" defer></script>
</head>
<body>
    <%@ include file="./fragments/header.jsp" %>   
    <div class="corpo">
        <div class="contenitore">
            <div class="login-box">
                <h2>Sign In</h2>
                <%
                    String errorMessage = (String) request.getAttribute("errorMessage");
                    if (errorMessage != null) {
                %>
                <script>
                    window.onload = function() {
                        alert('<%= errorMessage %>');
                    }
                </script>
                <%
                    }
                %>
                <form action="<%= request.getContextPath() %>/signinServlet" method="post">
                    <div class="input-box">
                        <input type="email" required name="txtEmail" autofocus>
                        <label>Email</label>
                    </div>
                    <div class="input-box">
                        <input type="password" minlength="5" maxlength="15" required name="txtPass">
                        <label>Password</label>
                    </div>
                    <div class="input-box">
                        <input type="text" minlength="1" maxlength="45" required name="txtNome">
                        <label>Nome</label>
                    </div>
                    <div class="input-box">
                        <input type="text" minlength="1" maxlength="45" required name="txtCognome">
                        <label>Cognome</label>
                    </div>
                    <div class="input-box">
                        <input type="number" id="eta" onBlur="controllaEta(this)" required name="txtEta">
                        <label>Età</label>
                    </div>
                    <div class="input-box">
                        <input type="text" maxlength="45" required name="txtIndirizzo">
                        <label>Indirizzo</label>
                    </div>
                    <div class="input-box">
                        <input type="tel" required name="txtTelefono">
                        <label>Telefono</label> 
                    </div>
                    <button type="submit" class="btn">Sign in</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
