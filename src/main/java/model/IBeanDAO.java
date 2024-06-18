package model;
import java.sql.SQLException;
import java.util.Collection;

public interface IBeanDAO<T> {
	
	public void doSave(T bean) throws SQLException;//Salva il prodotto sul database
	public boolean doDelete(int idProdotti) throws SQLException;//Cancella un prodotto dal database
	public T doRetrieveByKey(int idProdotti) throws SQLException;
	public Collection<T> doRetrieveAll(int idOrdine) throws SQLException;
	public void doUpdate(T bean) throws SQLException;//Salva le modifiche al prodotto sul database
}