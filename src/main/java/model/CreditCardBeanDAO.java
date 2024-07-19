package model;

import java.sql.SQLException;
import java.util.List;

public interface CreditCardBeanDAO {
    boolean insertCreditCard(String EmailUT,String Cif,String CVV,String Scadenza)throws SQLException;
    void DeleteCard(String EmailUT,String Cif) throws SQLException;
    List<String> doRetrieveAll(String Email) throws SQLException;
    List<CreditCardBean> getCarteByEmail(String email) throws SQLException;
}
