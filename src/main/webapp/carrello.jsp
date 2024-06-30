<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Carrello</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/carrello.css" type="text/css">
</head>

<body>

	<section>
		<c:forEach var="product" items="${products}">
			<div class="contenitore-grid">
	      		<div class="item-grid" data-name="immagine">
		      		<img src="${product.immagine}" class="img" alt="prod">
	      		</div>
	      		<div class="item-grid">
					<h1>${product.nome}</h1>
	      		</div>
	      		<div class="item-grid" data-name="quantita">
			      	<button onclick="decrementButton('myTextBox${product.idProdotti}')"><</button>
			      	<input class="set-quantita" id="myTextBox${product.idProdotti}" type="text" value="1">
			      	<button onclick="incrementButton('myTextBox${product.idProdotti}')">></button>
			      	<script src="script/btnQuantita.js"></script>
		      	</div>
				<div class="item-grid">
			      	<h2>${product.prezzo}$</h2>
		      	</div>
			</div>
		</c:forEach>
	</section>	
	
</body>
</html>
