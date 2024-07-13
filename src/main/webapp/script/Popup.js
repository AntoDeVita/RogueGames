		function showPopupElimina() {
            document.getElementById('popupElimina').style.display = 'block';
            document.getElementById('overlayElimina').style.display = 'block';
	    }
	    
	    function hidePopupElimina() {
            document.getElementById('popupElimina').style.display = 'none';
            document.getElementById('overlayElimina').style.display = 'none';
        }
	    
	    function showPopupAggiungi(idProdotto) {
            document.getElementById('popupAggiungi').style.display = 'block';
            document.getElementById('overlayAggiungi').style.display = 'block';
	    	
	    }
	    
	    function hidePopupAggiungi() {
            document.getElementById('popupAggiungi').style.display = 'none';
            document.getElementById('overlayAggiungi').style.display = 'none';
        }
	    
        function showPopupModifica(idProdotto, nome, img, dsc, cov, prz, casaPrd, pltf, gnr, tipo, releaseDate, qnt) {
            document.getElementById('popupModifica').style.display = 'block';
            document.getElementById('overlayModifica').style.display = 'block';
            document.getElementById('idProdotto').innerText = idProdotto;
            document.getElementById('nome').value = nome;
            document.getElementById('img').value = img;
            document.getElementById('dsc').value = dsc;
            document.getElementById('cov').value = cov;
            document.getElementById('prz').value = prz;
            document.getElementById('casaPrd').value = casaPrd;
            document.getElementById('pltf').value = pltf;
            document.getElementById('gnr').value = gnr;
            document.getElementById('tipo').value = tipo;
            document.getElementById('releaseDate').value = releaseDate;
            document.getElementById('qnt').value = qnt;
        }

        function hidePopupModifica() {
            document.getElementById('popupModifica').style.display = 'none';
            document.getElementById('overlayModifica').style.display = 'none';
        }
        

		

       