	
	function decrementButton(idProdotti) {
	    fetch('carrelloServlet', {
	        method: 'POST',
	        body: new URLSearchParams({
	            act: 'dec',
	            param: idProdotti
	        })
	    })
	    .then(response => response.text())
	    .then(data => {
	        // Optionally handle response, e.g., update the UI or redirect
	        console.log(data);
	        // For example, you can redirect to another page after successful request
	        window.location.href = 'carrello.jsp';  // change 'somePage.html' to your desired page
	    })
	    .catch(error => {
	        console.error('Error:', error);
	    });
	}

	function incrementButton(idProdotti) {
		fetch('carrelloServlet', {
			        method: 'POST',
			        body: new URLSearchParams({
			            act: 'inc',
			            param: idProdotti
			        })
			    })
	    .then(response => response.text())
	    .then(data => {
	        // Optionally handle response, e.g., update the UI or redirect
	        console.log(data);
	        // For example, you can redirect to another page after successful request
	        window.location.href = 'carrello.jsp';  // change 'somePage.html' to your desired page
	    })
	    .catch(error => {
	        console.error('Error:', error);
	    });
	}
	
	function deleteButton(idProdotti) {
		fetch('carrelloServlet', {
			        method: 'POST',
			        body: new URLSearchParams({
			            act: 'delete',
			            param: idProdotti
			        })
			    })
	    .then(response => response.text())
	    .then(data => {
	        // Optionally handle response, e.g., update the UI or redirect
	        console.log(data);
	        // For example, you can redirect to another page after successful request
	        window.location.href = 'carrello.jsp';  // change 'somePage.html' to your desired page
	    })
	    .catch(error => {
	        console.error('Error:', error);
	    });
	}

	function deleteAllButton() {
		fetch('carrelloServlet', {
			        method: 'POST',
			        body: new URLSearchParams({
			            act: 'deleteAll',
			        })
			    })
	    .then(response => response.text())
	    .then(data => {
	        // Optionally handle response, e.g., update the UI or redirect
	        console.log(data);
	        // For example, you can redirect to another page after successful request
	        window.location.href = 'carrello.jsp';  // change 'somePage.html' to your desired page
	    })
	    .catch(error => {
	        console.error('Error:', error);
	    });
	}