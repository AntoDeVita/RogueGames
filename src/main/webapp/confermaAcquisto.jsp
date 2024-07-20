<%@ page contentType="text/html; charset=UTF-8" language="java" import="model.*, java.util.*" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Riepilogo Acquisto</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/confermaAcquisto.css" type="text/css">
</head>
<body>
		
    <%@ include file="./fragments/header.jsp" %>
    
	
    <div class="container">
        <h1 class="text-center my-4">Riepilogo Acquisto</h1>
        <%
	    	String sessionToken = UUID.randomUUID().toString();
	    	session.setAttribute("sessionToken", sessionToken);
	    
            carrello pcart = (carrello) request.getSession().getAttribute("pcart");
            clienteRegBean cliente = (clienteRegBean) request.getSession().getAttribute("cl");
            IndirizzoSpedizioneDAO indirizzoDao = new IndirizzoSpedizioneDAO();
            CreditCardDao cartaDao = new CreditCardDao();
            List<IndirizzoSpedizioneBean> indirizzi = indirizzoDao.getIndirizziByEmail(cliente.getEmail());
            List<CreditCardBean> carte = cartaDao.getCarteByEmail(cliente.getEmail());

            if (pcart != null && !pcart.isEmpty()) {
                List<pCarrelloBean> cart = pcart.getProdotti();

        %>
        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-header">Prodotti nel Carrello</div>
                    <ul class="list-group list-group-flush">
                        <%
                        for (pCarrelloBean bean : cart) {
                           
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
                                    <input class="form-control text-center" type="number" value="<%=bean.getIdQuantita() %>" readonly>
                                </div>
                                <div class="col-md-2">
                                    <h5>€ <%=bean.getPrezzo() %></h5>
                                </div>
                                <div class="col-md-2 text-right">
                                    <a href="carrelloServlet?act=delete&param=<%=bean.getIdProdotti() %>" class="btn btn-danger">X</a>
                                </div>
                            </div>
                        </li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <div class="total-price">Prezzo Totale: € <%=pcart.prezzoTot()%></div>
                        <div class="form-punti">
                        <select id="punti" name="Punti">
                            <option value="0">Seleziona Sconto</option>
                            <%if(cliente.getPunti()>=100){%>
                                <option value="100">
                                   10&euro;
                                </option>
                                <% } %>
                            <%if(cliente.getPunti()>=200){%>
                                <option value="200">
                                   20&euro;
                                </option>
                                <% } %>
                            <%if(cliente.getPunti()>=300){%>
                                <option value="300">
                                   30&euro;
                              </option>
                             <% } %>
                                                    
                        </select>
                        </div>
                        
                       <h5>Seleziona un Indirizzo Esistente</h5>
                        <select class="form-control" id="existingAddressSelect" name="existingAddress">
                            <option value="">Seleziona Indirizzo</option>
                            <% for (IndirizzoSpedizioneBean indirizzo : indirizzi) { %>
                                <option value="<%= indirizzo.getVia() %>, <%= indirizzo.getCivico() %>, <%= indirizzo.getCap() %>, <%= indirizzo.getProvincia() %>, <%= indirizzo.getCitta() %>">
                                    <%= indirizzo.getVia() %>, <%= indirizzo.getCivico() %>, <%= indirizzo.getCap() %>, <%= indirizzo.getProvincia() %>, <%= indirizzo.getCitta() %>
                                </option>
                            <% } %>
                        </select>
                        <h5>Seleziona una Carta di Credito Esistente</h5>
                        <select class="form-control" id="existingCardSelect" name="existingCard">
                            <option value="">Seleziona Carta</option>
                            <% for (CreditCardBean carta : carte) { %>
                                <option value="<%= carta.getCif() %>">
                                    <%= carta.getCif() %>
                                </option>
                            <% } %>
                        </select>
                       				
						 <a id="confirmOrderLink" id="acquistaBtn" class="btn btn-purchase" text-align="center" href="#" onclick="confirmOrder()">Conferma</a>
					</div>	 
					<script>
				    function confirmOrder() {
				        
				    	var sc= document.getElementById('punti').value;
				    	console.log('Fetching:', sc);
				    	
				        var sessionToken = '<%= session.getAttribute("sessionToken") %>';
				        
				        var servletUrl = 'Ordine?sessionToken=' + encodeURIComponent(sessionToken)+'&sc='+sc;
				        
				        document.getElementById('confirmOrderLink').href = servletUrl;
				        
				        hidePopupOrdine();
				    }
					</script>

                        <hr>                   		                       
                        
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

    <%@ include file="./fragments/Footer.jsp" %>
</body>
</html>
>







