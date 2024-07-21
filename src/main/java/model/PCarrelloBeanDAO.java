package model;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface PCarrelloBeanDAO<T> {
	void doSave(pCarrelloBean pCart, String email) throws SQLException;
	void doDelete(int idProdotti, String email) throws SQLException;//Cancella un prodotto dal database
	public List<T> doRetrieveAll(String email) throws SQLException;
	public void doUpdateQnt(int id, int qnt, String email, double prezzo) throws SQLException;
	void doDeleteAll(String email) throws SQLException;
	boolean doRetrieveByKey(int idProdotti, String email) throws SQLException;
	
}
