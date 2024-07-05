<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link rel="stylesheet" href="css/signin.css" type="text/css">
	    
	</head>
	
	
	<body>
		<%@ include file="./fragments/header.jsp" %>   
			<div class="corpo">
				<div class="contenitore">
					<div class="login-box">
						<h2> Sign In </h2>
						<form action="<%= request.getContextPath() %>/signinServlet"  method="Post">
							<div class="input-box">
								<input type="email" required name="txtEmail">
								<label> Email </label>
							</div>
							<div class="input-box">
								<input type="password" required name="txtPass">
								<label> Password </label>
							</div>
							<div class="input-box">
								<input type="text" required name="txtNome">
								<label> Nome </label>
							</div>
							<div class="input-box">
								<input type="text" required name="txtCognome">
								<label> Cognome </label>
							</div>
							<div class="input-box">
								<input type="number" required name="txtEta">
								<label> Età </label>
							</div>
							<div class="input-box">
								<input type="text" required name="txtIndirizzo">
								<label> Indirizzo </label>
							</div>
							<div class="input-box">
								<input type="tel" required name="txtTelefono">
								<label> telefono </label>
							</div>
							<button type="submit" class="btn">Sign in</button>
						</form>
							
					</div>
					
				</div>
			</div>
	</body>
</html>