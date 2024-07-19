package model;

import java.util.ArrayList;
import java.util.List;

public class preferiti {


    private List<pPreferitiBean> pref;
    public preferiti(){
        pref = new ArrayList<pPreferitiBean>();
    }

    public void addPref(pPreferitiBean p) {
        int i=0;
        for(pPreferitiBean prod : pref) {
            if(prod.getIdProdotti()==p.getIdProdotti()) {
                i=1;
                break;
            }
        }
        if(i==0)
        	pref.add(p);
    }

    public void removePref(pPreferitiBean p) {
        for(pPreferitiBean prod : pref) {
            if(prod.getIdProdotti()==p.getIdProdotti()) {
                pref.remove(prod);
                break;
            }
        }
    }

    public void svuota() {
        pref.removeAll(pref);
    }

    public boolean isEmpty() {
        return pref.isEmpty();
    }

    public pPreferitiBean getProd(int id) {
        for(pPreferitiBean prod : pref) {
            if(prod.getIdProdotti()==id) {
                return prod;
            }
        }
        return null;
    }

    public List getProdotti() {
        return pref;
    }

    public double prezzoTot() {
        if(isEmpty()) {
            return 0;
        }
        double som=0;
        for(pPreferitiBean prod : pref) {
                som+=prod.getPrezzo();
            }
        return som;
    }
}

