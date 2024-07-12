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
                    <li>
                    <c:if test="${empty sessionScope.cl}">
                        <form action="login.jsp" method="POST">
                            <input class="dec btn" type="submit" value="Login">
                          </form>
                    </c:if>
                    </li>
                     <li>
                      	<form action="<%= request.getContextPath() %>/carrello.jsp" method="POST">
    						<input type="hidden" />
    						<input class="dec btn" type="submit" value="Carrello">
						</form>
                    </li>
                </ul>
                <c:if test="${not empty sessionScope.cl}">
                <ul class="nav-links">
               		<li>
                    	<form action="Profilo.jsp" method="POST">
                            <input class="dec btn" type="submit" value="profilo">
                          </form>
                    </li>
                    <li>
                    	<form action="logout.jsp" method="POST">
                            <input class="dec btn" type="submit" value="Logout">
                          </form>
                    </li>
                    <%-- 
                    <%
                    clienteRegBean cl= (clienteRegBean) request.getAttribute("cl");
                    if((cl.getRuolo()).equals("admin")){ %>
                    --%> 
	                    <li style="margin-top: 5px">
						    <button onclick="toggleDropdown()" class="menuTendina">Admin</button>
						     <div id="dropdown-content" class="dropdown-content">
	                          	<a href="<%= request.getContextPath() %>/adminServlet">Prodotti</a>
	                          	<a href="<%= request.getContextPath() %>/adminOrdiniServlet">Ordini</a>
							</div>
	                    </li>
	                    <%--
	                 <%} %>
	                 --%>   
                 </ul>
                 </c:if>
                <div class="search-container">
                    <input type="text" placeholder="Search for products">
                    <button type="button">Cerca</button>
                </div>
               </nav>
		</header>
	</body>
</html>