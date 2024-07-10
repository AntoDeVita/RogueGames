package model;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface ClientBeanDAO<clienteRegBean> {
	
	public boolean doSave(String email, String password, String nome, String cognome, int eta, String indirizzo, String telefono) throws SQLException;//Salva il prodotto sul database
	public clienteRegBean doLogin(String email, String password) throws SQLException;//Cerca l'utente nel database
}