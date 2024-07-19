<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.clienteRegBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>	
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link href="css/head.css" rel="stylesheet" type="text/css">
	    <script src="script/menuTendina.js"></script>
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
                    <c:if test="${empty sessionScope.cl}">
                    <li>
                        <form action="login.jsp" method="POST">
                            <input class="dec btn" type="submit" value="Login">
                          </form>
                    </li>
                    </c:if>
                    <li>
                      	<form action="<%= request.getContextPath() %>/carrello.jsp" method="POST">
    						<input type="hidden" />
    						<input class="dec btn" type="submit" value="Carrello">
						</form>
                    </li>
                <c:if test="${not empty sessionScope.cl}">
                    <li>
                    	<form action="Profilo.jsp" method="POST">
                            <input class="dec btn" type="submit" value="Profilo">
                          </form>
                    </li>
                    <li>
                    	<form action="logout.jsp" method="POST">
                            <input class="dec btn" type="submit" value="Logout">
                          </form>
                    </li>
                    <c:if test="${sessionScope.cl.ruolo == 'admin'}">
		                <li style="margin-top: 5px">
							<button onclick="toggleDropdown()" class="menuTendina">Admin</button>
								<div id="dropdown-content" class="dropdown-content">
		                        	<a href="<%= request.getContextPath() %>/adminServlet">Prodotti</a>
		                          	<a href="<%= request.getContextPath() %>/adminOrdiniServlet?num=0">Ordini</a>
								</div>
		                </li>
		         	</c:if>
                 </c:if>
                 	<li>
                        <form action="<%= request.getContextPath() %>/preferiti.jsp" method="POST">
                            <input type="hidden" name="param" value="idProdotti" />
                            <input class="dec btn" type="submit" value="Preferiti">
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