package model;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface ordineBeanDAO<T> {
	
	public void doSave(List <T> bean) throws SQLException;//Salva il prodotto sul database
	public List<T> doRetrieveAll() throws SQLException;//stampa tutti gli ordini
	public List<T> doRetrieveAllFromDateXToDateY(String x, String y) throws SQLException;//stampa tutti gli ordini
	public List<T> doRetrieveAllOrderedByEmail() throws SQLException;//stampa tutti gli ordini
	public List<T> doRetrieveForClient(String Email) throws SQLException;//Stampa tutti gli ordini di un utente in ordine cronologico
}