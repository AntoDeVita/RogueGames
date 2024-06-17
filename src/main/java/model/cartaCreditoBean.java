package model;
import java.io.Serializable;

public class cartaCreditoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int sediciCif;
	private String scadenza;
	private int cvv;
	
	public cartaCreditoBean() {
		
	}
	
	public int getSediciCif() {
		return sediciCif;
	}
	
	public void setSediciCif(int sediciCif) {
		this.sediciCif= sediciCif;
	}
	
	public String getScadenza() {
		return scadenza;
	}
	
	public void setScadenza(String scadenza) {
		this.scadenza= scadenza;
	}
	
	public int getCvv() {
		return cvv;
	}
	
	public void setCvv(int cvv) {
		this.cvv= cvv;
	}
}