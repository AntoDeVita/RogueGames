function incrementButton(idCasellaTesto) {
      var casellaTesto = document.getElementById(idCasellaTesto);
      var valoreAttuale = parseInt(casellaTesto.value);

      // Incrementa il valore solo se è un numero valido
      if (!isNaN(valoreAttuale)) {
        casellaTesto.value = valoreAttuale + 1;
      } else {
        casellaTesto.value = 1; // Imposta a 1 se non è un numero valido
      }
    }
    
    function decrementButton(idCasellaTesto) {
      var casellaTesto = document.getElementById(idCasellaTesto);
      var valoreAttuale = parseInt(casellaTesto.value);

      // Incrementa il valore solo se è un numero valido
      if (!isNaN(valoreAttuale)) {
		if(valoreAttuale>1)
        	casellaTesto.value = valoreAttuale - 1;
      } else {
        casellaTesto.value = 1; // Imposta a 1 se non è un numero valido
      }
    }