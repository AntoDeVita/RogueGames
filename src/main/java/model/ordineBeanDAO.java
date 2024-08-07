package model;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface ordineBeanDAO<T> {
	
	public void doSave(List <T> bean) throws SQLException;//Salva il prodotto sul database
	public List<T> doRetrieveAll() throws SQLException;//stampa tutti gli ordini
	public List<T> doRetrieveAllFromDateXToDateY(String x, String y) throws SQLException;//stampa tutti gli ordini
	public List<ordineBean> doRetrieveForClient(String Email) throws SQLException;
	public List<ordineBean> doRetrieveAllOrderedByEmail() throws SQLException;
}