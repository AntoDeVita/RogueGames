document.addEventListener("DOMContentLoaded", function() {
    const genreFantasy = document.getElementById("genreParamFantasy")?.value || "fantasy";
    const genreConsole = document.getElementById("genreParamConsole")?.value || "console";

    fetchProducts("genreServlet", "#productContainerFantasy", { genre: genreFantasy });
    fetchProducts("genreServlet", "#productContainerConsole", { genre: genreConsole });

    initializeSlider("#productContainerFantasy", "#slider-fantasy");
    initializeSlider("#productContainerConsole", "#slider-console");
});

function fetchProducts(url, containerSelector, params) {
    console.log('Fetching products with params:', params);

    $.ajax({
        url: url,
        type: "POST",
        data: params,
        dataType: "xml",
        success: function(data) {
            console.log('Data received:', data);
            displayProducts(data, containerSelector);
        },
        error: function(xhr, status, error) {
            console.error('Errore nella richiesta:', error);
        }
    });
}

function displayProducts(xmlDoc, containerSelector) {
    console.log('Displaying products:', xmlDoc);
    const products = $(xmlDoc).find('product');
    const productContainer = $(containerSelector);

    products.each(function(index) {
        const id = $(this).find('name').text();
        const name = $(this).find('name').text();
        const price = $(this).find('price').text();
        const imgSrc = $(this).find('img').text();

        const productHTML = 
            `<div class="product-item">
                <a style="text-decoration: none" href="dettagliServlet?param=${id}">
                    <img src="images/${imgSrc}" alt="${name}" class="product-image">
                    <h5>${name}</h5>
                    <h5>${price}€</h5>
                </a>
            </div>`;

        productContainer.append(productHTML);
    });

    updateSliderRange(containerSelector);
}

function initializeSlider(containerSelector, sliderSelector) {
    const slider = $(sliderSelector);

    slider.on("input", function() {
        const currentIndex = $(this).val();
        updateSlider(containerSelector, currentIndex);
    });
}

function updateSliderRange(containerSelector) {
    const items = $(containerSelector).children('.product-item');
    const slider = $(containerSelector).next('.slider-bar');
    const totalItems = items.length;

    slider.attr("max", totalItems - 1);
}

function updateSlider(containerSelector, currentIndex) {
    const items = $(containerSelector).children('.product-item');
    const translateX = -currentIndex * (items.outerWidth(true));
    $(containerSelector).css('transform', 'translateX(' + translateX + 'px)');
}