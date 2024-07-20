	
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
	
	function addPref(productId, btn) {
	        var xhr = new XMLHttpRequest();
			const action= 'add';
	        xhr.open("POST", "preferitiServlet", true);
	        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	        xhr.onreadystatechange = function() {
	            if (xhr.readyState === 4) {
	                if (xhr.status === 200) {
	                    var response = xhr.responseText;
	                    document.getElementById("response").innerText = "Response: " + response;
	                } else {
	                    document.getElementById("response").innerText = "Error: " + xhr.responseText;
	                }
	            }
	        };

	        var params = "act=" + encodeURIComponent(action) + "&param=" + encodeURIComponent(productId);
	        xhr.send(params);
	    }
	    
	function changeColor(id) {
		var btnName= 'btn'+id;
	    var btn = document.getElementById(btnName);
	    btn.classList.toggle('active');
	}
	
	function addCart(productId) {

	        var xhr = new XMLHttpRequest();
			const action= 'add';
	        xhr.open("POST", "carrelloServlet", true);
	        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	        xhr.onreadystatechange = function() {
	            if (xhr.readyState === 4) {
	                if (xhr.status === 200) {
	                    var response = xhr.responseText;
	                    document.getElementById("response").innerText = "Response: " + response;
	                } else {
	                    document.getElementById("response").innerText = "Error: " + xhr.responseText;
	                }
	            }
	        };

	        var params = "act=" + encodeURIComponent(action) + "&param=" + encodeURIComponent(productId);
	        xhr.send(params);
	    }
	