/*function incrementButton(idCasellaTesto, idCasella, prezzo, pc) {
      var casellaTesto = document.getElementById(idCasellaTesto);
	  var casella = document.getElementById(idCasella);
      var valoreAttuale = parseInt(casellaTesto.value);
	  //var valore = parseFloat(casella.value);
	  var p= parseInt(prezzo);
      // Incrementa il valore solo se è un numero valido
	  var Url="carrelloServlet?act=inc&param="+ encodeURIComponent(prezzo);
      if (!isNaN(valoreAttuale)) {
        //casellaTesto.value = valoreAttuale + 1;
		//casella.value=valore
		window.location.href=Url;
      } else {
        casellaTesto.value = 1; // Imposta a 1 se non è un numero valido
      }
    }
    
    function decrementButton(idCasellaTesto, idCasella, prezzo, pc) {
      var casellaTesto = document.getElementById(idCasellaTesto);
	  var casella = document.getElementById(idCasella);
      var valoreAttuale = parseInt(casellaTesto.value);
	  //var valore = parseFloat(casella.value);
	  var p= parseInt(prezzo)
      // Incrementa il valore solo se è un numero valido
	  var Url="carrelloServlet?act=dec&param="+ encodeURIComponent(prezzo);
      if (!isNaN(valoreAttuale)) {
		if(valoreAttuale>1){
        	//casellaTesto.value = valoreAttuale - 1;
		    //casella.value = valore;
			window.location.href=Url;
		}
      } else {
        casellaTesto.value = 1; // Imposta a 1 se non è un numero valido
		casella.value = p;
      }
    }
	
	function decrementButton(idProdotti) {
	    window.location.href = `carrelloServlet?act=dec&param=${idProdotti}`;
	}

	function incrementButton(idProdotti) {
	    window.location.href = `carrelloServlet?act=inc&param=${idProdotti}`;
	}*/
	
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