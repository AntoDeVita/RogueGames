<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
	      		<div
	      			class="button">
			      	 <form action="<%= request.getContextPath() %>/testbd" method="POST">
    				<input type="hidden" name="param" value="prezzo" />
    				<input type="submit" value="Carrello">
				</form>
		      	</div>
				<div class="item-grid">
			      	<h2>${product.prezzo}€</h2>
		      	</div>
			</div>
		</c:forEach>
	</section>	
	
</body>
</html>
