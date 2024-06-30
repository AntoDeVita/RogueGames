package model;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface IBeanDAO<T> {
	
	public void doSave(T bean) throws SQLException;//Salva il prodotto sul database
	public boolean doDelete(int idProdotti) throws SQLException;//Cancella un prodotto dal database
	public T doRetrieveByKey(int idProdotti) throws SQLException;
	public List<prodottoBean> doRetrieveAll(String where) throws SQLException;
	public void doUpdate(T bean) throws SQLException;//Salva le modifiche al prodotto sul database
	public boolean searchUtente(String Email, String Password) throws SQLException;//Controllo credenziali dell'utente per il login
}