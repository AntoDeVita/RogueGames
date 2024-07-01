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

	private static final String TABLE_NAME = "prodotti";

	@Override
	public synchronized void doSave(prodottoBean product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + prodottiDAO2.TABLE_NAME
				+ "(idProdotti, Nome, Descrizione, CoV, prezzo, CasaProd, Piattaforma, Genere, Tipo, DataRilascio, Quantita) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, product.getIdProdotti());
			preparedStatement.setString(2, product.getNome());
			preparedStatement.setString(3, product.getDescrizione());
			preparedStatement.setBoolean(4, product.getCoV());
			preparedStatement.setDouble(5, product.getPrezzo());
			preparedStatement.setString(6, product.getCasaProduttrice());
			preparedStatement.setString(7, product.getPiattaforma());
			preparedStatement.setString(8, product.getGenere());
			preparedStatement.setString(9, product.getTipo());
			preparedStatement.setString(10, product.getDataRilascio());
			preparedStatement.setInt(11, product.getQuantita());

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
	public synchronized boolean doDelete(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + prodottiDAO2.TABLE_NAME + " WHERE CODE = ?";

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);

			result = preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return (result != 0);
	}

	@Override
	public synchronized prodottoBean doRetrieveByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		prodottoBean bean = new prodottoBean();

		String selectSQL = "SELECT * FROM " + prodottiDAO2.TABLE_NAME + " WHERE CODE = ?";

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setIdProdotti(rs.getInt("idProdotti"));
				bean.setNome(rs.getString("Nome"));
				bean.setDescrizione(rs.getString("Descrizione"));
				bean.setCoV(rs.getBoolean("CoV"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setCasaProduttrice(rs.getString("CasaProd"));
				bean.setPiattaforma(rs.getString("Piattoforma"));
				bean.setGenere(rs.getString("Genere"));
				bean.setTipo(rs.getString("Tipo"));
				bean.setDataRilascio(rs.getString("DataRilascio"));
				bean.setQuantita(rs.getInt("Quantita"));
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


	@Override
	public List<prodottoBean> doRetrieveAll(String where) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		

		List<prodottoBean> products = new ArrayList<prodottoBean>();

		String selectSQL = "SELECT * FROM " + prodottiDAO2.TABLE_NAME ;

		if (where != null && !where.equals("")) {
			selectSQL += " ORDER BY " + where;
		}

		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				prodottoBean bean = new prodottoBean();
				
				int codiceProdotto = rs.getInt("idProdotti");
				bean.setIdProdotti(codiceProdotto);
				bean.setNome(rs.getString("nome"));
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
	public void doUpdate(prodottoBean product) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		
		
		String updateQntSQL = "UPDATE" + prodottiDAO2.TABLE_NAME + "SET Nome=?, Descrizione=?, CoV=?, prezzo=?, CasaProd=?, Piattaforma=?, Genere=?, Tipo=?, DataRilascio=?, Quantita=? WHERE CODE = ?";
		
		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(updateQntSQL);


			preparedStatement.setString(1, product.getNome());
			preparedStatement.setString(2, product.getDescrizione());
			preparedStatement.setBoolean(3, product.getCoV());
			preparedStatement.setDouble(4, product.getPrezzo());
			preparedStatement.setString(5, product.getCasaProduttrice());
			preparedStatement.setString(6, product.getPiattaforma());
			preparedStatement.setString(7, product.getGenere());
			preparedStatement.setString(8, product.getTipo());
			preparedStatement.setString(9, product.getDataRilascio());
			preparedStatement.setInt(10, product.getQuantita());
			preparedStatement.setInt(11, product.getIdProdotti());
			
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
	public void doUpdateQnt(int id, int qnt) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;



		String updateQntSQL = "UPDATE" + prodottiDAO2.TABLE_NAME + "SET Quantita= ? WHERE CODE = ?";

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(updateQntSQL);
			
			preparedStatement.setInt(1, qnt);
			preparedStatement.setInt(2, id);

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
	
	public List<prodottoBean> doRetrieveByGen(String genre) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		

		List<prodottoBean> products = new ArrayList<prodottoBean>();

		String selectSQL = "SELECT * FROM " + prodottiDAO2.TABLE_NAME + "WHERE Genere=?";


		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();
			preparedStatement.setString(1, genre);
			while (rs.next()) {
				prodottoBean bean = new prodottoBean();
				
				bean.setNome(rs.getString("nome"));;
				bean.setPrezzo(rs.getDouble("prezzo"));
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
}