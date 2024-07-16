package model;
import java.io.Serializable;


public class pCarrelloBean implements  Serializable{
	private static final long serialVersionUID = 1L;
	
	private prodottoBean p;
	private int idCar;
	private int idProdotti;
	private String email;
	private int quantita;
	private double prezzo;
	
	public pCarrelloBean(prodottoBean p) {
		this.p=p;
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
	
	public void setIdProdotti(int idProdotti) {
		this.idProdotti=idProdotti;
		
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String nome) {
		this.email= email;
	}
	
	public double getPrezzo() {
		return p.getPrezzo()*this.quantita;
	}	

	public void setPrezzo(double prezzo) {
		this.prezzo=prezzo;
	}	
	
	public int getIdQuantita() {
		return this.quantita;
	}
	
	public void setIdQuantita(int quantita) {
		this.quantita=quantita;
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