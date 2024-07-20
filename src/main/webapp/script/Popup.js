function showPopupElimina(id, nome) {
            document.getElementById('popupElimina').style.display = 'block';
            document.getElementById('overlayElimina').style.display = 'block';
            document.getElementById('Nome').innerText = nome;
            document.getElementById('id').value= id;
	    }
	    
	    function hidePopupElimina() {
            document.getElementById('popupElimina').style.display = 'none';
            document.getElementById('overlayElimina').style.display = 'none';
        }
	    
	    function showPopupAggiungi() {
            document.getElementById('popupAggiungi').style.display = 'block';
            document.getElementById('overlayAggiungi').style.display = 'block';
	    	
	    }
	    
	    function hidePopupAggiungi() {
            document.getElementById('popupAggiungi').style.display = 'none';
            document.getElementById('overlayAggiungi').style.display = 'none';
        }
	    
        function showPopupModifica(idProdotto, nome, dsc, cov, prz, casaPrd, pltf, gnr, tipo, releaseDate, qnt) {
            document.getElementById('popupModifica').style.display = 'block';
            document.getElementById('overlayModifica').style.display = 'block';
            document.getElementById('idProdotto').innerText = idProdotto;
            document.getElementById('nome').value = nome;
            document.getElementById('dsc').value = dsc;
            document.getElementById('cov').value = cov;
            document.getElementById('prz').value = prz;
            document.getElementById('casaPrd').value = casaPrd;
            document.getElementById('pltf').value = pltf;
            document.getElementById('gnr').value = gnr;
            document.getElementById('tipo').value = tipo;
            document.getElementById('releaseDate').value = releaseDate;
            document.getElementById('qnt').value = qnt;
            document.getElementById('id2').value= idProdotto;

        }

        function hidePopupModifica() {
            document.getElementById('popupModifica').style.display = 'none';
            document.getElementById('overlayModifica').style.display = 'none';
        }
        
        function showPopupDescrizione(descr){
			document.getElementById('popupDescrizione').style.display = 'block';
            document.getElementById('overlayDescrizione').style.display = 'block';
            document.getElementById('descrizione').innerText = descr;
		}
		
		function hidePopupDescrizione() {
            document.getElementById('popupDescrizione').style.display = 'none';
            document.getElementById('overlayDescrizione').style.display = 'none';
        }
        
        function showPopupOrdinaData(){
			document.getElementById('popupOrdinaData').style.display = 'block';
            document.getElementById('overlayOrdinaData').style.display = 'block';
		}
		
		function hidePopupOrdinaData() {
            document.getElementById('popupOrdinaData').style.display = 'none';
            document.getElementById('overlayOrdinaData').style.display = 'none';
        }
        
        function showPopupConfermaOrdine(){
			document.getElementById('popupConfermaOrdine').style.display = 'block';
            document.getElementById('overlayConfermaOrdine').style.display = 'block';
		}
		
		function hidePopupConfermaOrdine() {
            document.getElementById('popupConfermaOrdine').style.display = 'none';
            document.getElementById('overlayConfermaOrdine').style.display = 'none';
        }
        
        function showPopupCronologia(Email){
			document.getElementById('popupCronologia').style.display = 'block';
            document.getElementById('overlayCronologia').style.display = 'block';
            
		}
		
		function hidePopupCronologia() {
            document.getElementById('popupCronologia').style.display = 'none';
            document.getElementById('overlayCronologia').style.display = 'none';
        }
	        
		function showPopupError(message){
			document.getElementById('popupError').style.display = 'block';
            document.getElementById('overlayError').style.display = 'block';
            document.getElementById('message').innerText = message;
		}
		
		function hidePopupError() {
            document.getElementById('popupError').style.display = 'none';
            document.getElementById('overlayError').style.display = 'none';
        }
