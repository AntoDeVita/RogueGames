package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}


