<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link href="css/head.css" rel="stylesheet" type="text/css">
	</head>
	
	<body>
		<header>
			<div class="logo-container">
				<a href="home.jsp">
	            <img src="images/RogueGameLogo.png" alt="RogueGames Logo" class="logo">
	            </a>
	            <h1 class="company-name">Rogue<span class="highlight">Games</span></h1>
        	</div>
<nav>
                <ul class="nav-links">
                    <li>
                        <form action="<%= request.getContextPath() %>/prodottiServlet" method="POST">
                            <input type="hidden" name="param" value="idProdotti" />
                            <input class="dec btn" type="submit" value="Prodotti">
                          </form>
                    </li>
                    <li>

                        <form action="login.jsp" method="POST">
                            <input type="hidden" name="param" value="idProdotti" />
                            <input class="dec btn" type="submit" value="Account">
                          </form>
                       </li>
                    <li>
                      	<form action="<%= request.getContextPath() %>/carrello.jsp" method="POST">
    				<input type="hidden" />
    				<input class="dec btn" type="submit" value="Carrello">
				</form>
                       </li>
                </ul>
                <div class="search-container">
                    <input type="text" placeholder="Search for products">
                    <button type="button">Cerca</button>
                </div>
               </nav>
		</header>
		
	</body>
	
	
	
</html>