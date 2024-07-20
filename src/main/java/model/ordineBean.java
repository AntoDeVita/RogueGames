package model;
import java.io.Serializable;

public class ordineBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idOrdine;
	private int idProdotto;
	private String nome;
	private double prezzo;
	private String email;
	private double prezzoTot;
	private int quantita;
	private String data;
	
	public ordineBean() {
		
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getPrezzoTot() {
		return prezzoTot;
	}

	public void setPrezzoTot(double prezzoTot) {
		this.prezzoTot = prezzoTot;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}