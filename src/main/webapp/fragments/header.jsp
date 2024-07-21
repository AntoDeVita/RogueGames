<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.clienteRegBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String sessionToken = (String) session.getAttribute("sessionToken");
%>

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
			<div class="search-container">
                <img src="images/lenteSymbol.png" alt="Search" class="search-icon" onclick="toggleSearchBar()">
                <input type="search" name="search" id="searchbar" class="searchbar-hidden" placeholder="Cerca nel catalogo..." onkeyup="cercaProdotti(this.value)">
                <div class="risultati-search" id="risultati-search"></div>
            </div>
                <ul class="nav-links">
                    <li>
                        <form action="<%= request.getContextPath() %>/prodottiServlet" method="POST">
                            <input type="hidden" name="param" value="idProdotti" />
                            <input class="dec btn" type="submit" value="Prodotti">
                            <input type="hidden" name="stampa" value="tutto">
                          </form>
                    </li>
                    <c:if test="${empty sessionScope.sessionToken}">
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
                <c:if test="${not empty sessionScope.sessionToken}">
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
		                <li>
							<button onclick="toggleDropdown()" class="dec btn menuTendina">Admin</button>
								<div id="dropdown-content" class="dropdown-content">
		                        	<a href="<%= request.getContextPath() %>/adminServlet">Prodotti</a>
		                          	<a href="adminOrdiniServlet?num=0"> Ordini</a>
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
               </nav>
		</header>
		<script>
		
			function toggleSearchBar() {
	            var searchBar = document.getElementById("searchbar");
	            if (searchBar.classList.contains("searchbar-hidden")) {
	                searchBar.classList.remove("searchbar-hidden");
	                searchBar.classList.add("searchbar-visible");
	            } else {
	                searchBar.classList.remove("searchbar-visible");
	                searchBar.classList.add("searchbar-hidden");
	            }
	        }
		
			function cercaProdotti(query) {
				if (query.trim() !== "") {
					var xhttp = new XMLHttpRequest();
					xhttp.onreadystatechange = function() {
						if (this.readyState == 4 && this.status == 200) {
							mostraProdotti(JSON.parse(this.responseText));
						}
					};
					xhttp.open("GET", "<%=request.getContextPath()%>/ricercaAction?query=" + query, true);
					xhttp.send();
				} else {
					mostraProdotti([]);
				}
			} 
			
			function mostraProdotti(prodotti) {
				var risultatiContainer = document.getElementById("risultati-search");
				risultatiContainer.innerHTML = "";

				if (prodotti.length === 0) {
					risultatiContainer.style.display = 'none';
					return;
				}

				prodotti.forEach(function(prodotto) {
					var prodottoDiv = document.createElement("div");
					prodottoDiv.classList.add("risultato-item");

					var nomeLink = document.createElement("a");
	                nomeLink.textContent = prodotto.nome;
	                nomeLink.href = "<%=request.getContextPath()%>/dettagliServlet?param=" + prodotto.idProdotti;
	                nomeLink.classList.add("risultato-link");
	                prodottoDiv.appendChild(nomeLink);

					// Puoi aggiungere ulteriori dettagli del prodotto qui, come immagini, descrizioni, ecc.

					risultatiContainer.appendChild(prodottoDiv);
				});

				risultatiContainer.style.display = 'block';
				}
		</script>
		
	</body>
</html>