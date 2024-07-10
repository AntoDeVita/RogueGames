package model;

import java.sql.SQLException;

public interface CreditCardBeanDAO {
    boolean insertCreditCard(String EmailUT,String Cif,String CVV,String Scadenza)throws SQLException;
}

