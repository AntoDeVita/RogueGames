package model;

import java.sql.SQLException;
import java.util.List;

public interface IndirizzoSpedizioneBeanDAO {
	
	void saveAddress(String email, String via, String civico, String cap, String provincia, String Citta) throws SQLException;
	void deleteAddress(String email, String via, String civico) throws SQLException;
	List<IndirizzoSpedizioneBean> getIndirizziByEmail(String email);
}
