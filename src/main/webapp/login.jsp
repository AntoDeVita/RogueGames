<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link rel="stylesheet" href="css/login.css" type="text/css">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,0,0">
	  	<script src="script/Popup.js"></script>
	</head>
	
	
	<body>   
	
		<%@ include file="./fragments/header.jsp" %>  
		<div id="overlayError" onclick="hidePopupError()"></div>
		<div id="popupError">
		    <h2 class="errorTitle">Errore Inserimento Credenziali</h2>
	        <p id="message"></p>
			<a class="adminBtn" onclick="hidePopupError()">Chiudi</a>
	    </div> 
		<div class="corpo">
			<div class="contenitore">
				<div class="login-box">
					<h2> Login </h2>
					<form action="<%= request.getContextPath() %>/loginServlet" method="Post">
						<div class="input-box">
							<input type="email" required name="txtEmail" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$" title="Please enter a valid email address">
							<label id="Email"> Email </label>
						</div>
						<div class="input-box">
							<input type="password" required name="txtPass" minlength="5" maxlenght="15" title="Password must be at least 5 characters long">

							<label> Password </label>
						</div>
						<button type="submit" class="btn">Login</button>
						<div class="signup-link">
							<a href="signin.jsp">Registrati</a>
						</div>
					</form>
				</div>
					<span style="--i:0;">	</span>
					<span style="--i:1;">	</span>
					<span style="--i:2;">	</span>
					<span style="--i:3;">	</span>
					<span style="--i:4;">	</span>
					<span style="--i:5;">	</span>
					<span style="--i:6;">	</span>
					<span style="--i:7;">	</span>
					<span style="--i:8;">	</span>
					<span style="--i:9;">	</span>
					<span style="--i:10;">	</span>
					<span style="--i:11;">	</span>
					<span style="--i:12;">	</span>
					<span style="--i:13;">	</span>
					<span style="--i:14;">	</span>
					<span style="--i:15;">	</span>
					<span style="--i:16;">	</span>
					<span style="--i:17;">	</span>
					<span style="--i:18;">	</span>
					<span style="--i:19;">	</span>
					<span style="--i:20;">	</span>
					<span style="--i:21;">	</span>
					<span style="--i:22;">	</span>
					<span style="--i:23;">	</span>
					<span style="--i:24;">	</span>
					<span style="--i:25;">	</span>
					<span style="--i:26;">	</span>
					<span style="--i:27;">	</span>
					<span style="--i:28;">	</span>
					<span style="--i:29;">	</span>
					<span style="--i:30;">	</span>
					<span style="--i:30;">	</span>
					<span style="--i:31;">	</span>
					<span style="--i:32;">	</span>
					<span style="--i:33;">	</span>
					<span style="--i:34;">	</span>
					<span style="--i:35;">	</span>
					<span style="--i:36;">	</span>
					<span style="--i:37;">	</span>
					<span style="--i:38;">	</span>
					<span style="--i:39;">	</span>
					<span style="--i:40;">	</span>
					<span style="--i:41;">	</span>
					<span style="--i:42;">	</span>
					<span style="--i:43;">	</span>
					<span style="--i:44;">	</span>
					<span style="--i:45;">	</span>
					<span style="--i:46;">	</span>
					<span style="--i:47;">	</span>
					<span style="--i:48;">	</span>
					<span style="--i:49;">	</span>
			</div>
		</div>
		<%
	        String errorMessage = (String) request.getAttribute("errorMessage");
	        if (errorMessage != null) {
	    %>
	        <script type="text/javascript">
	        showPopupError("<%= errorMessage %>");
	        </script>
	    <%
	        }
	    %>
		<%@ include file="./fragments/Footer.jsp" %>  
	</body>
</html>