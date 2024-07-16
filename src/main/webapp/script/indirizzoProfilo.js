$(document).ready(function() {
    $('#shippingForm').submit(function(event) {
        event.preventDefault(); // Impedisce il submit normale del form

        // Recupera i dati del form
        const formData = {
            via: $('#via').val(),
            civico: $('#civico').val(),
            cap: $('#cap').val(),
            provincia: $('#provincia').val(),
            citta: $('#citta').val()
        };

        console.log("Indirizzo salvato:", formData);
        
        // Esegui la chiamata AJAX
        $.ajax({
            type: 'POST',
            url: 'indirizzoSpedizioneProfiloServlet', // URL del servlet
            data: formData,
            success: function(response) {
                console.log('Indirizzo salvato con successo:', response);
                $('#shippingModal').modal('hide'); // Chiude il modal
                fetchAddresses('AJXAddressServlet', '#address-container'); // Ricarica gli indirizzi
            },
            error: function(xhr, status, error) {
                console.error('Errore durante il salvataggio dell\'indirizzo:', error);
            }
        });
    });

    const deleteAddressesBtn = document.getElementById("deleteAddressesBtn");
    const addressContainer = document.getElementById("address-container");

    if (deleteAddressesBtn) {
        deleteAddressesBtn.addEventListener("click", function() {
            fetchAddresses('AJXAddressServlet', '#address-container');
        });
    }
});

function fetchAddresses(url, containerSelector) {
    console.log('Fetching addresses from:', url);

    $.ajax({
        url: url,
        type: "GET",
        dataType: "xml",
        success: function(data) {
            console.log('Data received:', data);
            displayAddresses(data, containerSelector);
        },
        error: function(xhr, status, error) {
            console.error('Error in request:', error);
        }
    });
}

function displayAddresses(xmlDoc, containerSelector) {
    console.log('Displaying addresses:', xmlDoc);
    const addresses = $(xmlDoc).find('Address');
    const addressContainer = $(containerSelector);

    // Clear previous addresses
    addressContainer.empty();

    addresses.each(function() {
        const via = $(this).find('Via').text();
        const civico = $(this).find('Civico').text();
        const cap = $(this).find('Cap').text();
        const provincia = $(this).find('Provincia').text();
        const citta = $(this).find('Citta').text();
       

        const addressHTML = `
            <div class="address-item">
                <p>Indirizzo: ${via}, ${civico}, ${cap}, ${provincia}, ${citta}</p>
                <button class="btn btn-danger delete-address-btn" data-via="${via}" data-civico="${civico}">Elimina</button>
            </div>
        `;

        addressContainer.append(addressHTML);
    });

    // Show the address container
    addressContainer.show();
}

// Deleting an address
$(document).on('click', '.delete-address-btn', function() {
    const via = $(this).data('via');
    const civico = $(this).data('civico');
    
    console.log('Deleting address with Via:', via, 'and Civico:', civico);

    $.ajax({
        url: 'indirizzoSpedizioneProfiloServlet',
        type: "POST",
        data: {
            action: 'delete', // Specify the action for deletion
            via: via,
            civico: civico
        },
        success: function(response) {
            console.log('Address deleted successfully:', response);
            fetchAddresses('AJXAddressServlet', '#address-container'); // Refresh address list
        },
        error: function(xhr, status, error) {
            console.error('Error deleting address:', error);
        }
    });
});


