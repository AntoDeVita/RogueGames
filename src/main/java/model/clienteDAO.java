package model;

import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class clienteDAO implements ClientBeanDAO<clienteRegBean>{
	private static DataSource ds;
	static {
		try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");

		ds = (DataSource) envCtx.lookup("jdbc/gamerogue");

		} catch (NamingException e) {
		System.out.println("Error:" + e.getMessage());
		e.printStackTrace();}
		}

	private static final String TABLE_NAME = "clientereg";
	
	@Override
	public synchronized void doSave(clienteRegBean user) throws SQLException {
		
	}

	@Override
	public clienteRegBean doLogin(String email, String password) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT * FROM " + clienteDAO.TABLE_NAME + " WHERE Email=? && Password=sha2(?, 256);";
		clienteRegBean bean = new clienteRegBean();
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			
				while (rs.next()) {
					bean.setEmail(rs.getString("email"));
					bean.setNome(rs.getString("Nome"));
					bean.setCognome(rs.getString("Cognome"));
					bean.setEta(rs.getInt("Eta"));
					bean.setIndirizzo(rs.getString("Indirizzo"));
					bean.setTelefono(rs.getInt("Tel"));
					bean.setRuolo(rs.getString("Ruolo"));
				}
			
			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		
		return bean;
	}

	
	
	
	
	
	
}