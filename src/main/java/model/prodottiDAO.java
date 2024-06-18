package model;

import java.sql.*;
import java.util.Collection;
import javax.sql.*;

public class prodottiDAO implements IBeanDAO<prodottoBean>{
	
	private static DataSource ds;
		final static String TABLE_NAME = "prodotti";
		
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
		Connection conn= null;
		PreparedStatement prep= null;
		prodottoBean bean= new prodottoBean();
		String selectSQL= "SELECT * FROM " + prodottiDAO.TABLE_NAME + "WHERE idProdotti= ";
		try {
			conn= ds.getConnection();
			prep= conn.prepareStatement(selectSQL);
			prep.setInt(1, idProdotti);
			ResultSet rs= prep.executeQuery();
			while(rs.next()) {
				bean.setIdProdotti(rs.getInt("idProdotti"));
				bean.setNome(rs.getString("nome"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setCoV(rs.getBoolean("CoV"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setCasaProduttrice(rs.getString("casaProduttrice"));
				bean.setPiattaforma(rs.getString("piattaforma"));
				bean.setGenere(rs.getString("genere"));
				bean.setTipo(rs.getString("tipo"));
				bean.setDataRilascio(rs.getString("dataRilascio"));
			}
		}
		finally {
			try {
				if(prep != null)
					prep.close();
			}
			finally {
				if(conn != null)
					conn.close();
			}
		}
		return bean;
	}
	
	@Override
	public Collection<prodottoBean> doRetrieveAll(int idOrdine) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void doUpdate(prodottoBean bean) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}