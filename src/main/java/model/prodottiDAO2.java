package model;

import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class prodottiDAO2 implements IBeanDAO<prodottoBean>{
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

	private static final String TABLE_PRODOTTI = "prodotti";
	private static final String TABLE_UTENTI = "clientereg";

	@Override
	public synchronized List<prodottoBean> doRetrieveAll(String where) throws SQLException {
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		

		List<prodottoBean> products = new ArrayList<prodottoBean>();

		String selectSQL = "SELECT * FROM " + prodottiDAO2.TABLE_PRODOTTI ;

		
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				prodottoBean bean = new prodottoBean();
				
				int codiceProdotto = rs.getInt("idProdotti");
				bean.setIdProdotti(codiceProdotto);
				bean.setNome(rs.getString("nome"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setCoV(rs.getBoolean("CoV"));
				bean.setCasaProduttrice(rs.getString("CasaProd"));
				bean.setPiattaforma(rs.getString("Piattaforma"));
				bean.setGenere(rs.getString("Genere"));
				bean.setTipo(rs.getString("Tipo"));
				bean.setDataRilascio(rs.getString("DataRilascio"));
				bean.setQuantita(rs.getInt("Quantita"));
				
				products.add(bean);
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
		return products;
	}

	@Override
	public void doSave(prodottoBean bean) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean doDelete(int idProdotti) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public prodottoBean doRetrieveByKey(int idProdotti) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void doUpdate(prodottoBean bean) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean searchUtente(String Email, String Password) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT * FROM " + prodottiDAO2.TABLE_UTENTI + " WHERE Email=" + Email + " Password=sha('" + Password + "',256)";//Controllare se la variabile Email funziona con o senza ""

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs!=null)
				return true;
			else
				return false;
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
	
}