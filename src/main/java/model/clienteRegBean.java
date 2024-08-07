package model;
import java.io.Serializable;

public class clienteRegBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	private String nome;
	private String cognome;
	private int eta;
	private int punti;
	private String indirizzo;
	private String telefono;
	private String ruolo;
	
	
	public clienteRegBean() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public void setPunti(int punti) {
        this.punti = punti;
    }
	
	public void addPunti(int punti) {
		this.punti += punti; 
    }
	    
    public int getPunti() {
    	return punti;
	}
}