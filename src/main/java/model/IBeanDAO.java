package model;
import java.sql.SQLException;

public interface IBeanDAO<T> {
	
	public void selectByPlatform(T piattaforma) throws SQLException;
	public void selectByType(T tipo) throws SQLException;
	public void selectByGenre(T genere) throws SQLException;
	public T selectAll(int idProdotti) throws SQLException;
	
}