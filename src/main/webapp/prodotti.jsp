<%@ page contentType="text/html; charset=UTF-8" language="java" import="model.*, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    List<prodottoBean> products = (List<prodottoBean>) request.getAttribute("products");
    preferiti ppref= (preferiti) request.getSession().getAttribute("ppref");
%>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="#">
    <title>Catalogo Prodotti</title>
    <link rel="stylesheet" href="css/prod.css" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,0,0">
    <script src="script/btnQuantita.js"></script>
	<script src="script/Popup.js"></script>
	
</head>
<body>
    <%@ include file="./fragments/header.jsp" %>
    <h1 class="company-name">Catalogo<span class="highlight"> Prodotti</span></h1>
    <form action="<%= request.getContextPath() %>/prodottiServlet" method="POST">
        <input type="hidden" name="stampa" value="anno">
        <input type="hidden" name="param" value="DataRilascio">
        <input type="submit" style="margin-left: 60px" class="adminBtn" value="Ordina per Data Rilascio">
    </form>

    <div class="catalogo">
        <%
            if (products != null && !products.isEmpty()) {
                for (prodottoBean bean : products) {
        %>
        <div class="prodotto">
        	<div style="text-align: right">
                <form id="preferitiForm">
                    <%
                    boolean isFav= false;
                    if(ppref!=null){
                    	List <pPreferitiBean> pref=ppref.getProdotti();
                		Iterator<?> it = pref.iterator();
                    	while(it.hasNext()){
                    		pPreferitiBean controllo= (pPreferitiBean) it.next();
                    		if(controllo.getIdProdotti()==bean.getIdProdotti()){
                    			isFav=true;
                    		}
                    	}
                    }
                    if((ppref!=null) && (isFav==true)){%>
                    	<button type="button" class="star active" onclick="deleteButtonPref('<%=bean.getIdProdotti() %>')">&#9733;</button>
        			<%}else{%>
                    	<button type="button" id="btn<%=bean.getIdProdotti()%>" class="star" onclick="addPref(<%=bean.getIdProdotti()%>); changeColor(<%=bean.getIdProdotti()%>);">&#9733;</button>
        			<%}%>
        		</form>
        	</div>
        	<a style="text-decoration: none" href="<%= request.getContextPath() %>/dettagliServlet?param=<%=bean.getIdProdotti() %>">
            <img src="images/<%=bean.getImmagine()%>" alt="<%=bean.getNome()%>">
            <h3><%=bean.getNome() %></h3> </a>
            <p class="descrizione"><%if(bean.getPiattaforma()==null){%>
            	<%=bean.getGenere()%>
            	<%}else{ %>
            	<%=bean.getPiattaforma()%>
            	<%} %>
            </p>
            <p class="prezzo"><%=bean.getPrezzo()%>&euro;</p>
            <div class="button"></a>
                <%
                    if (bean.getQuantita() > 0) {
                %>
				<button id="carrello"  onclick="addCart(<%=bean.getIdProdotti()%>);">Add to cart</button>
                <%
                    } else {
                    	
                %>
                <h2>Esaurito</h2>
                <%
                    }
                %> 
            </div>
            	<div class="item-grid">
                
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
		 <div id="response"></div>
    <%@ include file="./fragments/Footer.jsp" %>
    
</body>
</html>