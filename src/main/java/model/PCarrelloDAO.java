package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PCarrelloDAO implements PCarrelloBeanDAO {
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

	private static final String TABLE_NAME = "PCarrello";
	

	
	@Override	
	public synchronized void doSave(pCarrelloBean pCart, String email) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		prodottiDAO2 dao=new prodottiDAO2();
		String insertSQL = "INSERT INTO " + TABLE_NAME + "(idProdotti, Email, Prezzo, Quantita) VALUES (?, ?, ?, ?)";

		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, pCart.getIdProdotti());
			preparedStatement.setString(2, email);
			preparedStatement.setDouble(3, pCart.getPrezzo());
			preparedStatement.setInt(4, pCart.getIdQuantita());
			preparedStatement.executeUpdate();
			
		}

		finally {
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
	public synchronized void doDelete(int id, String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM " + TABLE_NAME + " WHERE idProdotti=? && Email=?";
		
		try {
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, email);
		
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
	}
	
	@Override
	public synchronized void doDeleteAll(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM " + TABLE_NAME + " WHERE Email=?";
		
		try {
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, email);
		
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
	}

	
	@Override
	public void doUpdateQnt(int id, int qnt, String email, double prezzo) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateQntSQL = "UPDATE " + TABLE_NAME + " SET Quantita= ?, prezzo=? WHERE idProdotti = ? && Email=?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateQntSQL);
			
			preparedStatement.setInt(1, qnt);
			preparedStatement.setDouble(2, prezzo);
			preparedStatement.setInt(3, id);
			preparedStatement.setString(4, email);
			
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

	}


	@Override
	public boolean doRetrieveByKey(int idProdotti, String email) throws SQLException {
		Connection connection = null;
        
        PreparedStatement preparedStatement = null;
        

        List<pCarrelloBean> pcart = new ArrayList<pCarrelloBean>();

        String selectSQL = "SELECT * FROM " + TABLE_NAME + " WHERE Email=? && idProdotti=?" ;
        
        prodottiDAO2 dao= new prodottiDAO2();
      	pCarrelloBean bean=new pCarrelloBean(null);
      	
      	boolean valore=false;
      	
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, email);
            preparedStatement.setInt(2, idProdotti);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
            	int id=rs.getInt("idProdotti");

                bean.setProdotto(dao.doRetrieveByKey(id));
                bean.setIdProdotti(id);
                bean.setEmail(rs.getString("Email"));
                bean.setIdQuantita(rs.getInt("Quantita"));
                bean.setPrezzo(rs.getDouble("prezzo"));
                valore=true;
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
         return valore;
    }

	@Override
	public List<pCarrelloBean> doRetrieveAll(String email) throws SQLException {
		Connection connection = null;
        
        PreparedStatement preparedStatement = null;
        

        List<pCarrelloBean> pcart = new ArrayList<pCarrelloBean>();

        String selectSQL = "SELECT * FROM " + TABLE_NAME + " WHERE Email=?" ;
        
        prodottiDAO2 dao= new prodottiDAO2();
        
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
            	int id=rs.getInt("idProdotti");
            	pCarrelloBean bean=new pCarrelloBean(null);
                bean.setProdotto(dao.doRetrieveByKey(id));
                bean.setIdProdotti(id);
                bean.setEmail(rs.getString("Email"));
                bean.setIdQuantita(rs.getInt("Quantita"));
                bean.setPrezzo(rs.getDouble("prezzo"));

                pcart.add(bean);
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
        return pcart;
    }
}
