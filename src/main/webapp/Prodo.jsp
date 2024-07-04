<%@ page contentType="text/html; charset=UTF-8" language="java" import="model.*, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    List<prodottoBean> products = (List<prodottoBean>) request.getAttribute("products");
%>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Catalogo Prodotti</title>
    <link rel="stylesheet" href="css/prod.css" type="text/css">
</head>
<body>
    <%@ include file="./fragments/header.jsp" %>
    <h1 class="company-name">Catalogo<span class="highlight">Prodotti</span></h1>

    <div class="catalogo">
        <%
            if (products != null && !products.isEmpty()) {
                for (prodottoBean bean : products) {
        %>
        <div class="prodotto">
            <img src="<%=bean.getImmagine()%>" alt="<%=bean.getNome()%>">
            <h3><%=bean.getNome() %></h3>
            <p class="descrizione">Una breve descrizione del prodotto.</p>
            <p class="prezzo"><%=bean.getPrezzo()%>&euro;</p>
            <div class="button">
                <%
                    if (bean.getQuantita() > 0) {
                %>
                <form action="<%= request.getContextPath() %>/carrelloServlet" method="POST">
                    <input type="hidden" name="param" value="<%=bean.getIdProdotti() %>" />
                    <input type="submit" value="Carrello">
                </form>
                <%
                    } else {
                %>
                <h2>Esaurito</h2>
                <%
                    }
                %>
            </div>
            <div class="item-grid">
                <h2><%=bean.getPrezzo()%>&euro;</h2>
            </div>
        </div>
        <%
                }
            } else {
        %>
        <h2>No products available</h2>
        <%
            }
        %>
    </div>

    <%@ include file="./fragments/Footer.jsp" %>
</body>
</html>
