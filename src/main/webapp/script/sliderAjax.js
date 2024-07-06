document.addEventListener("DOMContentLoaded", function() {
    fetchProducts();
});

function fetchProducts() {
    console.log('Fetching products...');

    $.ajax({
        url: "genreServlet",
        type: "GET",
        dataType: "xml",
        success: function(data) {
            console.log('Data received:', data);
            displayProducts(data);
        },
        error: function(xhr, status, error) {
            console.error('Errore nella richiesta:', error);
        }
    });
}

function displayProducts(xmlDoc) {
    console.log('Displaying products:', xmlDoc);
    const products = $(xmlDoc).find('product');
    const productContainer = $('#productContainer');

    products.each(function(index) {
        const name = $(this).find('name').text();
        const price = $(this).find('price').text();
        const imgSrc = $(this).find('img').text();

        const productHTML = 
            '<div class="product-item">' +
                '<img src="' + imgSrc + '" alt="' + name + '" class="product-image">' +
                '<h5>' + name + '</h5>' +
                '<h5>' + price + '€</h5>' +
            '</div>';

        productContainer.append(productHTML);
    });

    initializeSlider();
}

function initializeSlider() {
    let currentIndex = 0;
    const items = $('.product-item');
    const totalItems = items.length;

    $('#next-slide').click(function() {
        if (currentIndex < totalItems - 1) {
            currentIndex++;
        } else {
            currentIndex = 0;
        }
        updateSlider();
    });

    $('#prev-slide').click(function() {
        if (currentIndex > 0) {
            currentIndex--;
        } else {
            currentIndex = totalItems - 1;
        }
        updateSlider();
    });

    function updateSlider() {
        const translateX = -currentIndex * (items.outerWidth(true));
        $('#productContainer').css('transform', 'translateX(' + translateX + 'px)');
    }
}
