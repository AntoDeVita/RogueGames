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
    productContainer.empty(); // Clear any existing products

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
    const productContainer = $(containerSelector);
    const productItems = productContainer.children();
    const numItems = productItems.length;

    if (numItems === 0) return; // No items to display

    const itemWidth = productItems.first().outerWidth(true);
    const sliderWidth = productContainer.width();
    
    productContainer.css('width', `${itemWidth * numItems}px`); // Set the width of the slider content

    // Slider controls
    const controlsId = containerSelector === "#productContainerFantasy" ? '#productControlsFantasy' : '#productControlsConsole';
    const prevBtnId = `${controlsId} #prev-slide-${containerSelector.includes('Fantasy') ? 'fantasy' : 'console'}`;
    const nextBtnId = `${controlsId} #next-slide-${containerSelector.includes('Fantasy') ? 'fantasy' : 'console'}`;

    let currentIndex = 0;

    $(prevBtnId).on('click', function() {
        if (currentIndex > 0) {
            currentIndex--;
            updateSlider();
        }
    });

    $(nextBtnId).on('click', function() {
        if (currentIndex < numItems - 1) {
            currentIndex++;
            updateSlider();
        }
    });

    function updateSlider() {
        const newTransform = -currentIndex * itemWidth;
        productContainer.css('transform', `translateX(${newTransform}px)`);
    }
}
