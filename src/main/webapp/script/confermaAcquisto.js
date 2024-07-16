document.addEventListener("DOMContentLoaded", function() {
    const acquistaBtn = document.getElementById("acquistaBtn");
    const thankYouPopup = document.getElementById("thankYouPopup");
    const closePopupBtn = document.getElementById("closePopupBtn");
    const existingAddressSelect = document.getElementById("existingAddressSelect");
    const existingCardSelect = document.getElementById("existingCardSelect");

    function updateAcquistaButtonState() {
        acquistaBtn.disabled = !(existingAddressSelect.value && existingCardSelect.value);
    }

    existingAddressSelect.addEventListener("change", updateAcquistaButtonState);
    existingCardSelect.addEventListener("change", updateAcquistaButtonState);

    acquistaBtn.addEventListener("click", function() {
        if (existingAddressSelect.value && existingCardSelect.value) {
            // Show the thank you popup
            thankYouPopup.style.display = "flex";

            // Create and submit the form
            let numberOfProducts = document.querySelectorAll(".product-item").length; // Adjust selector as needed
            let form = document.createElement("form");
            form.method = "POST";
            form.action = "aggiungiPuntiServlet";

            let input = document.createElement("input");
            input.type = "hidden";
            input.name = "numberOfProducts";
            input.value = numberOfProducts;

            form.appendChild(input);
            document.body.appendChild(form);
            form.submit();
        }
    });

    closePopupBtn.addEventListener("click", function() {
        thankYouPopup.style.display = "none";
    });
});

let cart = {};

// Funzione per aggiungere prodotti al carrello
function addProductToCart(productId) {
    if (cart[productId]) {
        cart[productId].quantity += 1; // Incrementa la quantità se già presente
    } else {
        cart[productId] = { quantity: 1 }; // Aggiungi nuovo prodotto con quantità 1
    }
}

// Funzione per aggiornare il numero totale di prodotti
function updateTotalProducts() {
    let totalProducts = Object.values(cart).reduce((sum, product) => sum + product.quantity, 0);
    
    // Aggiorna il campo hidden nel form
    document.getElementById("numberOfProducts").value = totalProducts;
}

// Esempio di utilizzo della funzione al click di un prodotto
document.querySelectorAll(".add-to-cart-btn").forEach(button => {
    button.addEventListener("click", function() {
        const productId = this.dataset.productId; // Assicurati di avere un data attribute
        addProductToCart(productId);
        updateTotalProducts(); // Aggiorna il numero totale di prodotti
    });
});






