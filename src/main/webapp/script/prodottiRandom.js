document.addEventListener("DOMContentLoaded", function() {
    trovaProdotti("prodottiHomeServlet", "#productContainerElectronics");

    function trovaProdotti(url, containerSelector) {
        console.log('Fetching products');

        $.ajax({
            url: url,
            type: "POST",
            dataType: "xml",
            success: function(data) {
                console.log('Data received:', data);
                mostraProdotti(data, containerSelector);
            },
            error: function(xhr, status, error) {
                console.error('Errore nella richiesta:', error);
            }
        });
    }

    function mostraProdotti(xmlDoc, containerSelector) {
        console.log('Displaying products:', xmlDoc);
        const products = $(xmlDoc).find('product');
        const productContainer = $(containerSelector);

        products.each(function() {
            const id = $(this).find('id').text();
            const name = $(this).find('name').text();
            const price = $(this).find('price').text();
            const imgSrc = $(this).find('img').text();

            const productHTML = `
                <div class="product">
                    <img src="images/${imgSrc}" alt="${name}" />
                    <h2>${name}</h2>
                    <p class="price">${price}€</p>
                    <a class="pbutton" style="text-decoration: none" href="dettagliServlet?param=${id}">Dettagli</a>
                </div>
            `;

            productContainer.append(productHTML);
        });
    }
});