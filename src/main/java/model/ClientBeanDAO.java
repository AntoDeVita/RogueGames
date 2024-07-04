package model;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface ClientBeanDAO<clienteRegBean> {
	
	public void doSave(clienteRegBean bean) throws SQLException;//Salva il prodotto sul database
	public clienteRegBean doLogin(String email, String password) throws SQLException;//Cerca l'utente nel database
}