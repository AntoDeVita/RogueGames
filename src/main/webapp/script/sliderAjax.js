//document.addEventListener("DOMContentLoaded", function() {
window.onload = function() {
            const genreFantasy = document.getElementById("genreParamFantasy")?.value || "fantasy";
            const genreConsole = document.getElementById("genreParamConsole")?.value || "console";

            fetchProducts("genreServlet", "#productContainerFantasy", { genre: genreFantasy });
            fetchProducts("genreServlet", "#productContainerConsole", { genre: genreConsole });

            initializeSlider("#productContainerFantasy", "#prev-slide-fantasy", "#next-slide-fantasy");
            initializeSlider("#productContainerConsole", "#prev-slide-Console", "#next-slide-Console");
        };

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
        }

        function initializeSlider(containerSelector, prevButtonSelector, nextButtonSelector) {
            let currentIndex = 0;
            const items = $(containerSelector).children('.product-item');
            const totalItems = items.length;

            if (totalItems <= 1) {
                $(prevButtonSelector).hide();
                $(nextButtonSelector).hide();
            } else {
                $(prevButtonSelector).show();
                $(nextButtonSelector).show();
            }

            $(prevButtonSelector).click(function() {
                if (currentIndex > 0) {
                    currentIndex--;
                } else {
                    currentIndex = totalItems - 1;
                }
                updateSlider(containerSelector);
            });

            $(nextButtonSelector).click(function() {
                if (currentIndex < totalItems - 1) {
                    currentIndex++;
                } else {
                    currentIndex = 0;
                }
                updateSlider(containerSelector);
            });

            function updateSlider(containerSelector) {
                const translateX = -currentIndex * (items.outerWidth(true));
                $(containerSelector).css('transform', 'translateX(' + translateX + 'px)');
            }
        }