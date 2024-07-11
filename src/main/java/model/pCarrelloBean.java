package model;
import java.io.Serializable;


public class pCarrelloBean implements  Serializable{
	private static final long serialVersionUID = 1L;
	
	private prodottoBean p;
	private int idCar;
	private int idProdotti;
	private String email;
	private int quantita;
	
	public pCarrelloBean(prodottoBean pc) {
		this.p=pc;
		this.quantita=1;
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
		return p.getPrezzo()*this.quantita;
	}	

	
	public int getIdQuantita() {
		return this.quantita;
	}
	
	public void incrementaQnt(){
		if(this.quantita< p.getQuantita())
		this.quantita=this.quantita+1;
	}
	public void decrementaQnt(){
		if(this.quantita>1)
		this.quantita=this.quantita-1;
	}
}