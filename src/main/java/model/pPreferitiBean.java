package model;
import java.io.Serializable;


public class pPreferitiBean implements  Serializable{
	private static final long serialVersionUID = 1L;
	
	private prodottoBean p;
	private int idPref;
	private int idProdotti;
	private String email;
	
	public pPreferitiBean(prodottoBean p) {
		this.p=p;
	}
	
	public prodottoBean getProdotto() {
		return p;
	}
	
	public void setProdotto(prodottoBean p) {
		this.p = p;
	}
	
	public int getIdProdotti() {
		return p.getIdProdotti();
	}
	
	
	public String email() {
		return email;
	}
	
	public void email(String nome) {
		this.email= email;
	}
	
	public double getPrezzo() {
		return p.getPrezzo();
	}
}