<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Prodotti Disponibili</title>
</head>
<body>
    <h1>Prodotti Disponibili</h1>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Descrizione</th>
                <th>Prezzo</th>
                <th>Casa Produttrice</th>
                <th>Piattaforma</th>
                <th>Genere</th>
                <th>Tipo</th>
                <th>Data di Rilascio</th>
                <th>Quantità</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.idProdotti}</td>
                    <td>${product.nome}</td>
                    <td>${product.descrizione}</td>
                    <td>${product.prezzo}</td>
                    <td>${product.casaProduttrice}</td>
                    <td>${product.piattaforma}</td>
                    <td>${product.genere}</td>
                    <td>${product.tipo}</td>
                    <td>${product.dataRilascio}</td>
                    <td>${product.quantita}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
