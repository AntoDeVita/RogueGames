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
            <c:forEach var="product" items="${genre}">
                <tr>
                    <td>${genre.idProdotti}</td>
                    <td>${genre.nome}</td>
                    <td>${genre.descrizione}</td>
                    <td>${genre.prezzo}</td>
                    <td>${genre.casaProduttrice}</td>
                    <td>${genre.piattaforma}</td>
                    <td>${genre.genere}</td>
                    <td>${genre.tipo}</td>
                    <td>${genre.dataRilascio}</td>
                    <td>${genre.quantita}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
