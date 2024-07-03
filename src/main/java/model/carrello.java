package model;

import java.util.ArrayList;
import java.util.List;

public class carrello {
	
	private List<prodottoBean> cart;
	public carrello(){
	    cart = new ArrayList<prodottoBean>();
	}
	
	public void addCarr(prodottoBean p) {
		int i=0;
		for(prodottoBean prod : cart) {
			if(prod.getIdProdotti()==p.getIdProdotti()) {
				i=1;
				break;
			}
		}
		if(i==0)
			cart.add(p);
	}
	
	public void removeCarr(prodottoBean p) {
		for(prodottoBean prod : cart) {
			if(prod.getIdProdotti()==p.getIdProdotti()) {
				cart.remove(prod);
				break;
			}
		}
	}
	
	public void svuota() {
		cart.removeAll(cart);
	}
	
	public boolean isEmpty() {
		return cart.isEmpty();
	}
	
	public prodottoBean getProd(int id) {
		for(prodottoBean prod : cart) {
			if(prod.getIdProdotti()==id) {
				return prod;
			}
		}
		return null;
	}
	
	public List getProdotti() {
		return cart;
	}
	
	public double prezzoTot() {
		if(isEmpty()) {
			return 0;
		}
		double som=0;
		for(prodottoBean prod : cart) {
				som+=prod.getPrezzo();
			}
		return som;
	}
}
