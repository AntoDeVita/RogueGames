function incrementButton(idCasellaTesto, idCasella, prezzo) {
      var casellaTesto = document.getElementById(idCasellaTesto);
	  var casella = document.getElementById(idCasella);
      var valoreAttuale = parseInt(casellaTesto.value);
	  var valore = parseFloat(casella.value);
	  var p= parseFloat(prezzo);
      // Incrementa il valore solo se è un numero valido
      if (!isNaN(valoreAttuale)) {
        casellaTesto.value = valoreAttuale + 1;
		casella.value=valore
		
      } else {
        casellaTesto.value = 1; // Imposta a 1 se non è un numero valido
      }
    }
    
    function decrementButton(idCasellaTesto, idCasella, prezzo) {
      var casellaTesto = document.getElementById(idCasellaTesto);
	  var casella = document.getElementById(idCasella);
      var valoreAttuale = parseInt(casellaTesto.value);
	  var valore = parseFloat(casella.value);
	  var p= parseFloat(prezzo)
      // Incrementa il valore solo se è un numero valido
      if (!isNaN(valoreAttuale)) {
		if(valoreAttuale>1){
        	casellaTesto.value = valoreAttuale - 1;
		    casella.value = valore;}
      } else {
        casellaTesto.value = 1; // Imposta a 1 se non è un numero valido
		asella.value = p;
      }
    }