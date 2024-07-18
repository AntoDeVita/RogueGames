package model;
import java.io.Serializable;

public class prodottoBean implements  Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idProdotti;
	private String nome;
	private String immagine;
	private String video;
	private String descrizione;
	private boolean CoV; //True0=Vendita False1=Cancellato
	private double prezzo;
	private String casaProduttrice;
	private String piattaforma;
	private String genere;
	private String tipo;
	private String dataRilascio;
	private int quantita;
	
	public prodottoBean() {
	
	}
	
	public int getIdProdotti() {
		return idProdotti;
	}
	
	public void setIdProdotti(int idProdotti) {
		this.idProdotti= idProdotti;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome= nome;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione= descrizione;
	}
	
	public boolean getCoV() {
		return CoV;
	}
	
	public void setCoV(boolean CoV) {
		this.CoV= CoV;
	}
	
	public double getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo= prezzo;
	}
	
	public String getCasaProduttrice() {
		return casaProduttrice;
	}
	
	public void setCasaProduttrice(String casaProduttrice) {
		this.casaProduttrice= casaProduttrice;
	}
	
	public String getPiattaforma() {
		return piattaforma;
	}
	
	public void setPiattaforma(String piattaforma) {
		this.piattaforma= piattaforma;
	}
	
	public String getGenere() {
		return genere;
	}
	
	public void setGenere(String genere) {
		this.genere= genere;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo= tipo;
	}
	
	public String getDataRilascio() {
		return dataRilascio;
	}
	
	public void setDataRilascio(String dataRilascio) {
		this.dataRilascio= dataRilascio;
	}
	public int getQuantita() {
		return quantita;
	}
	
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}	
	
	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}	

}