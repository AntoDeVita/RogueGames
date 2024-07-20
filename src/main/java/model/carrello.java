package model;

import java.util.ArrayList;
import java.util.List;

public class carrello {


    private List<pCarrelloBean> cart;

    public carrello() {
        cart = new ArrayList<pCarrelloBean>();
    }

    public int addCarr(pCarrelloBean p) {
        int i=0;
        for(pCarrelloBean prod : cart) {
            if(prod.getIdProdotti()==p.getIdProdotti()) {
                i=1;
                break;
            }
        }
        if (i == 0) 
            cart.add(p);
       return i;
    }

    public boolean removeCarr(pCarrelloBean p) {
        for(pCarrelloBean prod : cart) {
            if(prod.getIdProdotti()==p.getIdProdotti()) {
                cart.remove(prod);
                return true;
            }
        }
        return false;
    }

    public void svuota() {
        cart.removeAll(cart);
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }

    public pCarrelloBean getProd(int id) {
        for (pCarrelloBean prod : cart) {
            if (prod.getIdProdotti() == id) {
                return prod;
            }
        }
        return null;
    }

    public List<pCarrelloBean> getProdotti() {
        return cart;
    }

    public double prezzoTot() {
        if (isEmpty()) {
            return 0;
        }
        double som = 0;
        for (pCarrelloBean prod : cart) {
            som += prod.getPrezzo();
        }
        return som;
    }

	public int getTotalQuantity() {
	    int totalQuantity = 0;
	    for (pCarrelloBean bean : cart) {
	        totalQuantity += bean.getIdQuantita();
	    }
	    return totalQuantity;
	}
}