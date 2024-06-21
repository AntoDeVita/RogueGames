<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Prodotti Disponibili</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h1>Prodotti Disponibili</h1>
    
    <table border="1" id="productsTable">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Descrizione</th>
                <th>Prezzo</th>
                <th>CoV</th>
                <th>Casa Prod</th>
                <th>Piattaforma</th>
                <th>Genere</th>
                <th>Tipo</th>
                <th>Data di Rilascio</th>
                <th>Quantità</th>
            </tr>
        </thead>
        <tbody id="productsBody">
            <!-- Qui vengono inseriti dinamicamente i dati -->
        </tbody>
    </table>
    
    <script>
        $(document).ready(function() {
            // Esegue una chiamata AJAX per ottenere i dati dalla servlet
            $.getJSON("testbd", function(data) {
                // Aggiorna la tabella con i dati ottenuti
                var productsBody = $("#productsBody");
                productsBody.empty();
                
                $.each(data, function(index, product) {
                    var row = "<tr>" +
                              "<td>" + product.idProdotti + "</td>" +
                              "<td>" + product.nome + "</td>" +
                              "<td>" + product.descrizione + "</td>" +
                              "<td>" + product.prezzo + "</td>" +
                              "<td>" + product.CoV + "</td>" +
                              "<td>" + product.casaProduttrice + "</td>" +
                              "<td>" + product.piattaforma + "</td>" +
                              "<td>" + product.genere + "</td>" +
                              "<td>" + product.tipo + "</td>" +
                              "<td>" + product.dataRilascio + "</td>" +
                              "<td>" + product.quantita + "</td>" +
                            "</tr>";
                    productsBody.append(row);
                });
            });
        });
    </script>
</body>
</html>
