/*document.addEventListener("DOMContentLoaded", function() {
		CellProd();
    });*/

function CellProd() {
	fetch('ordineProdServlet', {
		        method: 'GET',
		    })
    .then(response => response.text())
    .then(data => {
        // Optionally handle response, e.g., update the UI or redirect
        console.log(data);
        // For example, you can redirect to another page after successful request
        window.location.href = 'ordineUtente.jsp';  // change 'somePage.html' to your desired page
    })
    .catch(error => {
        console.error('Error:', error);
    });
}