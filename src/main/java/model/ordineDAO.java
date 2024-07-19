package model;

import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class ordineDAO implements ordineBeanDAO<ordineBean>{
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

	private static final String TABLE_NAME = "Ordine";
	

	
	@Override	
	public synchronized void doSave(List <ordineBean> ordine) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		prodottiDAO2 dao=new prodottiDAO2();
		String insertSQL = "INSERT INTO " + ordineDAO.TABLE_NAME + "(idProdotto, Email, PrezzoTot, Quantita, Data) VALUES (?, ?, ?, ?, ?)";

		try {
			ordineBean order = ordine.remove(0);
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, order.getIdProdotto());
			preparedStatement.setString(2, order.getEmail());
			preparedStatement.setDouble(3, order.getPrezzoTot());
			preparedStatement.setInt(4, order.getQuantita());
			preparedStatement.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));
			
			   int affectedRows = preparedStatement.executeUpdate();
			   int id=0;
			    if (affectedRows > 0) {
			        try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
			            while (rs.next()) {
			                id=(int) rs.getLong(1);
			            }
			        }
			    } else {
			        System.out.println("Errore nell'ottenimento del valore");
			    }
			
			
			if (preparedStatement != null) {
			        preparedStatement.close();
			}
			
			
			dao.doUpdateQnt(order.getIdProdotto(), order.getQuantita());
			if(!ordine.isEmpty()) {
				insertSQL = "INSERT INTO " + ordineDAO.TABLE_NAME + "(idOrdine, idProdotto, Email, PrezzoTot, Quantita, Data) VALUES (?, ?, ?, ?, ?, ?)";
				preparedStatement = connection.prepareStatement(insertSQL);
				for(ordineBean order2: ordine) {

					preparedStatement.setInt(1, id);
					preparedStatement.setInt(2, order2.getIdProdotto());
					preparedStatement.setString(3, order2.getEmail());
					preparedStatement.setDouble(4, order2.getPrezzoTot());
					preparedStatement.setInt(5, order2.getQuantita());
					preparedStatement.setDate(6, java.sql.Date.valueOf(java.time.LocalDate.now()));
					preparedStatement.executeUpdate();
					dao.doUpdateQnt(order2.getIdProdotto(), order2.getQuantita());
				}
				
			}
		
		} catch (SQLException e) {
			    e.printStackTrace();
		

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}
	
	@Override
	public List<ordineBean> doRetrieveAll() throws SQLException{
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<ordineBean> ordini = new ArrayList<ordineBean>();
        String selectSQL = "SELECT * FROM " + ordineDAO.TABLE_NAME ;
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ordineBean bean = new ordineBean();
                
                bean.setIdOrdine(rs.getInt("idOrdine"));
                bean.setIdProdotto(rs.getInt("idProdotto"));
                bean.setEmail(rs.getString("Email"));
                bean.setPrezzoTot(rs.getInt("PrezzoTot"));
                bean.setQuantita(rs.getInt("Quantita"));
                bean.setData(rs.getString("Data"));
                ordini.add(bean);
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
        return ordini;
	}

	@Override
	public List<ordineBean> doRetrieveAllFromDateXToDateY(String dateX, String dateY) throws SQLException {//stampa tutti gli ordini effettuati dalla dataX fino alla DataY
			Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        List<ordineBean> ordini = new ArrayList<ordineBean>();
	        String selectSQL = "SELECT * FROM " + ordineDAO.TABLE_NAME + " WHERE Data BETWEEN ? AND ?";
	        
	        try {
	            connection = ds.getConnection();
	            preparedStatement = connection.prepareStatement(selectSQL);
	            preparedStatement.setString(1, dateX);
	            preparedStatement.setString(2, dateY);
	            
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	                ordineBean bean = new ordineBean();
	                
	                bean.setIdOrdine(rs.getInt("idOrdine"));
	                bean.setIdProdotto(rs.getInt("idProdotto"));
	                bean.setEmail(rs.getString("Email"));
	                bean.setPrezzoTot(rs.getInt("PrezzoTot"));
	                bean.setQuantita(rs.getInt("Quantita"));
	                bean.setData(rs.getString("Data"));
	                ordini.add(bean);
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
	        return ordini;
	}

	@Override
	public List<ordineBean> doRetrieveAllOrderedByEmail() throws SQLException{//stampa tutti gli ordini ordinati per Email
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<ordineBean> ordini = new ArrayList<ordineBean>();
        String selectSQL = "SELECT * FROM " + ordineDAO.TABLE_NAME + " ORDER BY Email";
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ordineBean bean = new ordineBean();
                
                bean.setIdOrdine(rs.getInt("idOrdine"));
                bean.setIdProdotto(rs.getInt("idProdotto"));
                bean.setEmail(rs.getString("Email"));
                bean.setPrezzoTot(rs.getInt("PrezzoTot"));
                bean.setQuantita(rs.getInt("Quantita"));
                bean.setData(rs.getString("Data"));
                ordini.add(bean);
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
        return ordini;
	}
	
	@Override 
    public List<ordineBean> doRetrieveForClient(String Email) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<ordineBean> ordiniUtente = new ArrayList<ordineBean>();
        String selectSQL = "SELECT idOrdine, idProdotto, PrezzoTot, Quantita, Data FROM " + ordineDAO.TABLE_NAME + " WHERE Email=? ORDER BY Data";
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, Email);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ordineBean bean = new ordineBean();

                bean.setIdOrdine(rs.getInt("idOrdine"));
                bean.setIdProdotto(rs.getInt("idProdotto"));
                bean.setPrezzoTot(rs.getInt("PrezzoTot"));
                bean.setQuantita(rs.getInt("Quantita"));
                bean.setData(rs.getString("Data"));
                ordiniUtente.add(bean);
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
        return ordiniUtente;
    }
}