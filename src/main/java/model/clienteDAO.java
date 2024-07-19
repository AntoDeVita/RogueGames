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
	
	private boolean controllo(String email) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT * FROM " + clienteDAO.TABLE_NAME + " WHERE Email=?;";
		boolean result= false;
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
			
				while (rs.next()) {
					if(email.equals(rs.getString("Email"))) {
						result= true;
					}
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
		
		return result;
	}
	
	@Override
	public synchronized boolean doSave(String email, String password, String nome, String cognome, int eta, String indirizzo, String telefono) throws SQLException {//true- registrato false- non registrato
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean c= controllo(email);
		if(c==true) {
			return c;
		}
		String insertSQL ="INSERT INTO " + clienteDAO.TABLE_NAME +" VALUES(?, sha2(?, 256), ?, ?, ?, ?, ?, default)";		
		try {
				connection = ds.getConnection();
				preparedStatement = connection.prepareStatement(insertSQL);
				preparedStatement.setString(1, email);
				preparedStatement.setString(2, password);
				preparedStatement.setString(3, nome);
				preparedStatement.setString(4, cognome);
				preparedStatement.setInt(5, eta);
				preparedStatement.setString(6, indirizzo);
				preparedStatement.setString(7, telefono);
				preparedStatement.executeUpdate();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return c;
	}

	@Override
	public clienteRegBean doLogin(String email, String password) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT * FROM " + clienteDAO.TABLE_NAME + " WHERE Email=? && Password=sha2(?, 256);";
		clienteRegBean bean = null;
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			
				while (rs.next()) {
					bean = new clienteRegBean();
					bean.setEmail(rs.getString("Email"));
					bean.setNome(rs.getString("Nome"));
					bean.setCognome(rs.getString("Cognome"));
					bean.setEta(rs.getInt("Eta"));
					bean.setIndirizzo(rs.getString("Indirizzo"));
					bean.setTelefono(rs.getString("Tel"));
					bean.setRuolo(rs.getString("Ruolo"));
					bean.setPunti(rs.getInt("Punti"));
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

	public void aggiornaCampo(clienteRegBean cl, String campo, String nuovoValore) throws SQLException {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;

	    String updateSQL = "UPDATE " + TABLE_NAME + " SET " + campo + "=? WHERE Email=?";

	    try {
	        connection = ds.getConnection();
	        preparedStatement = connection.prepareStatement(updateSQL);
	        preparedStatement.setString(1, nuovoValore);
	        preparedStatement.setString(2, cl.getEmail()); 
	        preparedStatement.executeUpdate();
	    } finally {
	        try {
	            if (preparedStatement != null) preparedStatement.close();
	        } finally {
	            if (connection != null) connection.close();
	        }
	    }
	}
	
	public boolean updateClientPoints(String email, int points) {
        String sql = "UPDATE clientereg SET Punti = ? WHERE Email = ?";
        try (Connection conn = ds.getConnection(); // Adjust for your connection method
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, points);
            stmt.setString(2, email);
            return stmt.executeUpdate() > 0; // Return true if rows were updated
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false on error
        }
    }
	
}