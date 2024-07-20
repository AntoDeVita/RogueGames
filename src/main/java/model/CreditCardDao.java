package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class CreditCardDao implements CreditCardBeanDAO {

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

    private static final String INSERT_CREDIT_CARD_SQL = "INSERT INTO CartaDiCredito (EmailUT, cif, CVV, Scadenza) VALUES (?, ?, ?, ?)";
    private static final String DELATE_CREDIT_CARD_SQL = "DELETE FROM CartaDiCredito  WHERE cif=? && EmailUT=?";
    private static final String SELECT_CREDIT_CARD_SQL = "SELECT cif FROM CartaDiCredito  WHERE  EmailUT=?";
    private static final String SELECT2_CREDIT_CARD_SQL = "SELECT cif FROM CartaDiCredito  WHERE  EmailUT=?";
    
@Override
    public boolean insertCreditCard(String EmailUT,String Cif,String CVV,String Scadenza) throws SQLException  {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        boolean rowInserted = false;
        try {connection = ds.getConnection();
             preparedStatement = connection.prepareStatement(INSERT_CREDIT_CARD_SQL);
            preparedStatement.setString(1, EmailUT);
            preparedStatement.setString(2, Cif);
            preparedStatement.setString(3, CVV);
            preparedStatement.setString(4, Scadenza);
            rowInserted = preparedStatement.executeUpdate() > 0;
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
        return rowInserted;
    }

    private void printSQLException(SQLException ex) {
        ex.printStackTrace();
    }
    @Override
    public synchronized void DeleteCard(String EmailUT,String Cif) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(DELATE_CREDIT_CARD_SQL);
			preparedStatement.setString(1, Cif);
            preparedStatement.setString(2, EmailUT);

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
	public List<String> doRetrieveAll(String Email) throws SQLException {
        Connection connection = null;
        
        PreparedStatement preparedStatement = null;

        List<String> ciffino = new ArrayList<String>();
        
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_CREDIT_CARD_SQL);
            preparedStatement.setString(1, Email);
            ResultSet rs = preparedStatement.executeQuery();
           
            while (rs.next()) {
                ciffino.add(rs.getString("cif"));
               
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
        return ciffino;
    }
   
    @Override
    public List<CreditCardBean> getCarteByEmail(String email) throws SQLException {
        List<CreditCardBean> carte = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ds.getConnection(); // Assicurati che il metodo Database.getConnection() esista e ritorni una connessione valida
            preparedStatement = connection.prepareStatement(SELECT2_CREDIT_CARD_SQL);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	CreditCardBean carta = new CreditCardBean();
                carta.setCif(resultSet.getString("Cif"));
                

                carte.add(carta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return carte;
    }
       
}