document.addEventListener("DOMContentLoaded", function() {
    const deleteCardsBtn = document.getElementById("deleteCardsBtn");
    const cardContainer = document.getElementById("card-container");

    if (deleteCardsBtn) {
        deleteCardsBtn.addEventListener("click", function() {
            fetchCards('AJXCreditservlet', '#card-container');
        });
    }
});

function fetchCards(url, containerSelector) {
    console.log('Fetching cards from:', url);

    $.ajax({
        url: url,
        type: "GET",
        dataType: "xml",
        success: function(data) {
            console.log('Data received:', data);
            displayCards(data, containerSelector);
        },
        error: function(xhr, status, error) {
            console.error('Error in request:', error);
        }
    });
}

function displayCards(xmlDoc, containerSelector) {
    console.log('Displaying cards:', xmlDoc);
    const cards = $(xmlDoc).find('Card');
    const cardContainer = $(containerSelector);

    // Clear previous cards
    cardContainer.empty();

    cards.each(function() {
        const cif = $(this).find('Cif').text();
        
        // Log the card information to the console
        console.log('Card CIF:', cif);
        
        const cardHTML = `
            <div class="card-item" data-cif="${cif}">
                <p>Carta di Credito: ${cif}</p>
                <button class="btn btn-danger delete-card-btn" data-cif="${cif}">Elimina</button>
            </div>
        `;

        cardContainer.append(cardHTML);
    });

    // Show the card container
    cardContainer.show();
}

// Deleting a card
$(document).on('click', '.delete-card-btn', function() {
    const cif = $(this).data('cif');
    
    console.log('Deleting card with CIF:', cif); // Log CIF before making request

    $.ajax({
        url: 'creditCardServlet',
        type: "POST",
        data: {
            field: 2, // Assuming this indicates deletion
            Cif: cif
        },
        success: function(response) {
            console.log('Card deleted successfully:', response);
            fetchCards('AJXCreditservlet', '#card-container'); // Refresh card list
        },
        error: function(xhr, status, error) {
            console.error('Error deleting card:', error);
        }
    });
});










