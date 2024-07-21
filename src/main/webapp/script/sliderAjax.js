document.addEventListener("DOMContentLoaded", function() {
    const genreFantasy = document.getElementById("genreParamFantasy")?.value || "fantasy";
    const genreConsole = document.getElementById("genreParamConsole")?.value || "console";

    fetchProducts("genreServlet", "#productContainerFantasy", { genre: genreFantasy });
    fetchProducts("genreServlet", "#productContainerConsole", { genre: genreConsole });
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
        const id = $(this).find('id').text();
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

    initializeSlider(containerSelector);
}

function initializeSlider(containerSelector) {
    const sliderBarId = containerSelector === "#productContainerFantasy" ? "#sliderBarFantasy" : "#sliderBarConsole";
    const sliderBar = document.querySelector(sliderBarId);
    const productContainer = document.querySelector(containerSelector);
    const items = document.querySelectorAll(containerSelector + ' .product-item');
    const totalItems = items.length;

    if (totalItems > 0) {
        noUiSlider.create(sliderBar, {
            start: 0,
            range: {
                min: 0,
                max: totalItems - 1
            },
            step: 1,
            connect: [true, false]
        });

        sliderBar.noUiSlider.on('update', function(values, handle) {
            const currentIndex = Math.round(values[handle]);
            updateSlider(productContainer, currentIndex);
        });

        updateSliderRange(productContainer, sliderBar);
    }
}

function updateSliderRange(productContainer, sliderBar) {
    const items = $(productContainer).children('.product-item');
    const totalItems = items.length;

    if (totalItems > 0) {
        sliderBar.noUiSlider.updateOptions({
            range: {
                min: 0,
                max: totalItems - 1
            }
        });
    }
}

function updateSlider(productContainer, currentIndex) {
    const items = $(productContainer).children('.product-item');
    const translateX = -currentIndex * (items.outerWidth(true));
    $(productContainer).css('transform', 'translateX(' + translateX + 'px)');
}