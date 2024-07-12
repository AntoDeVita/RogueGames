package model;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface ordineBeanDAO<T> {
	
	public List<T> doRetrieveAll() throws SQLException;//stampa tutti gli ordini
}