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
}