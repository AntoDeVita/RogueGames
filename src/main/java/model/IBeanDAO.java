package model;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface IBeanDAO<T> {
	
	public void doSave(T bean) throws SQLException;//Salva il prodotto sul database
	public boolean doDelete(int idProdotti) throws SQLException;//Cancella un prodotto dal database
	public T doRetrieveByKey(int idProdotti) throws SQLException;
	public Collection<T> doRetrieveAll(String where) throws SQLException;
	public void doUpdate(T bean, int id) throws SQLException;//Salva le modifiche al prodotto sul database
	public void doUpdateQnt(int id, int qnt) throws SQLException;
	public List<prodottoBean> doRetrieveByGen(String genre) throws SQLException;
	public List<prodottoBean> doRetrieveByPlat(String plat) throws SQLException;
}