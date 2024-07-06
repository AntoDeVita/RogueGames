<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>    
    <link rel="shortcut icon" href="#">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- Altri script JavaScript -->
</head>
	 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script>
        document.addEventListener("DOMContentLoaded", function() {
            fetchProducts();
        });

        function fetchProducts() {
            console.log('Fetching products...'); // Log per verificare l'inizio della chiamata

            $.ajax({
                url: "genreServlet",
                type: "GET",
                dataType: "xml",  // Imposta il tipo di dati atteso
                success: function(data) {
                    console.log('Data received:', data); // Log per verificare i dati ricevuti
                    displayProducts(data);
                },
                error: function(xhr, status, error) {
                    console.error('Errore nella richiesta:', error);
                }
            });
        }

        function displayProducts(xmlDoc) {
            console.log('Displaying products:', xmlDoc); // Log per verificare il documento XML
                const products = $(xmlDoc).find('product');
                const carouselInner = $('#carouselInner');

                products.each(function(index) {
                    const name = $(this).find('name').text();
                    const price = $(this).find('price').text();
                    const img = $(this).find('img').text();

                    const carouselItem = $('<div>').addClass('carousel-item');
                    const productHTML = `
                        <div class="d-block w-100">
                    	<img src="${img}" alt="${name}" class="img-fluid">
                            <h3>Name: ${name}</h3>
                            <p>Price: ${price}</p>
                        </div>
                    `;

                    carouselItem.html(productHTML);
                    carouselInner.append(carouselItem);
                });

                // Imposta il primo elemento come attivo
                carouselInner.children().first().addClass('active');
            }

    </script>
</head>
<body>
    <h1>Home Page</h1>

    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner" id="carouselInner"></div>
    
    <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>



</body>
</html>
