<%@ page contentType="text/html; charset=UTF-8" language="java" import="model.*, java.util.*"%>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Riepilogo Acquisto</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/checkout.css" type="text/css">
    <link rel="stylesheet" href="css/confermaAcquisto.css" type="text/css">
    <script src="script/Popup.js"></script>
</head>
<body>
    <%@ include file="./fragments/header.jsp" %>

    <div class="container">
        <h1 class="text-center my-4">Riepilogo Acquisto</h1>
        <%
            carrello pcart = (carrello) request.getSession().getAttribute("pcart");
            if (pcart != null && !pcart.isEmpty()) {
                List<pCarrelloBean> cart = pcart.getProdotti();
                Iterator<?> it = cart.iterator();
                double totalPrice = 0;
        %>
        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-header">Prodotti nel Carrello</div>
                    <ul class="list-group list-group-flush">
                        <%
                            while (it.hasNext()) {
                                pCarrelloBean bean = (pCarrelloBean) it.next();
                                totalPrice += bean.getPrezzo();
                        %>
                        <li class="list-group-item">
                            <div class="row">
                                <div class="col-md-2">
                                    <img src="<%=bean.getProdotto().getImmagine() %>" class="img-fluid" alt="prod">
                                </div>
                                <div class="col-md-4">
                                    <h5><%=bean.getProdotto().getNome() %></h5>
                                </div>
                                <div class="col-md-2">
                                    <input class="form-control text-center" type="number" value="1" readonly>
                                </div>
                                <div class="col-md-2">
                                    <h5>€ <%=bean.getPrezzo() %></h5>
                                </div>
                                <div class="col-md-2 text-right">
                                    <a href="carrelloServlet?act=delete&param=<%=bean.getProdotto().getIdProdotti() %>" class="btn btn-danger">X</a>
                                </div>
                            </div>
                        </li>
                        <%
                            }
                        %>
                    </ul>
                </div>
            </div>
        </div>
        
        <div class="row">
        	<div class="col-lg-12">
        		
        	</div>
        </div>
        
        <div class="row mt-4">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <div class="total-price">Prezzo Totale: € <%=totalPrice %></div>
						<button class="btn-purchase" onclick="showPopupConfermaOrdine()">Acquista</button>
                    </div>
                </div>
            </div>
        </div>
        <%
            } else {
        %>
        <h2 class="text-center my-4">Il tuo carrello è vuoto.</h2>
        <%
            }
        %>
    </div>

	<div id="overlayConfermaOrdine" onclick="hidePopupConfermaOrdine()"></div>
		<div id="popupConfermaOrdine">
		    <h2 id="prodTit">Grazie per il tuo acquisto!</h2>
		        <div class="btnCont">
					<a class="adminBtn" onclick="hidePopupConfermaOrdine()">Chiudi</a>
				</div>
	    </div>

    <%@ include file="./fragments/Footer.jsp" %>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

