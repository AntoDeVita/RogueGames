package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class IndirizzoSpedizioneDAO {
    private static DataSource ds;

    static {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            ds = (DataSource) envCtx.lookup("jdbc/gamerogue");
        } catch (NamingException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static final String INSERT_ADDRESS_SQL = "INSERT INTO indirizzospedizione (Provincia, CAP, Via, Civico, Email, Citta) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String GET_INDIRIZZI_BY_EMAIL = "SELECT * FROM indirizzospedizione WHERE Email = ?";
    private static final String DELETE_ADDRESS_SQL = "DELETE FROM indirizzospedizione WHERE Email = ? AND Via = ? AND Civico = ?";
    private static final String CHECK_ADDRESS_EXISTS_SQL = "SELECT COUNT(*) FROM indirizzospedizione WHERE Email = ? AND Via = ? AND Civico = ? AND CAP = ? AND Provincia = ? AND Citta = ?";

    // Metodo per salvare un indirizzo
    public void saveAddress(String email, String via, String civico, String cap, String provincia, String citta) throws SQLException {
        if (addressExists(email, via, civico, cap, provincia, citta)) {
            throw new SQLException("L'indirizzo esiste già.");
        }
        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADDRESS_SQL)) {
            preparedStatement.setString(1, provincia);
            preparedStatement.setInt(2, Integer.parseInt(cap)); // Parsing CAP come intero
            preparedStatement.setString(3, via);
            preparedStatement.setString(4, civico);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, citta);
            preparedStatement.executeUpdate();
        }
    }

    // Metodo per verificare se un indirizzo esiste
    public boolean addressExists(String email, String via, String civico, String cap, String provincia, String citta) throws SQLException {
        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHECK_ADDRESS_EXISTS_SQL)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, via);
            preparedStatement.setString(3, civico);
            preparedStatement.setInt(4, Integer.parseInt(cap)); // Parsing CAP come intero
            preparedStatement.setString(5, provincia);
            preparedStatement.setString(6, citta);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
                return false;
            }
        }
    }

    // Metodo per ottenere gli indirizzi per email
    public List<IndirizzoSpedizioneBean> getIndirizziByEmail(String email) {
        List<IndirizzoSpedizioneBean> indirizzi = new ArrayList<>();

        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_INDIRIZZI_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    IndirizzoSpedizioneBean indirizzo = new IndirizzoSpedizioneBean();
                    indirizzo.setEmail(rs.getString("Email"));
                    indirizzo.setVia(rs.getString("Via"));
                    indirizzo.setCivico(rs.getString("Civico"));
                    indirizzo.setCap(rs.getInt("Cap")); 
                    indirizzo.setProvincia(rs.getString("Provincia"));
                    indirizzo.setCitta(rs.getString("Citta"));
                    indirizzi.add(indirizzo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return indirizzi;
    }

    // Metodo per eliminare un indirizzo
    public void deleteAddress(String email, String via, String civico) throws SQLException {
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ADDRESS_SQL)) {
            statement.setString(1, email);
            statement.setString(2, via);
            statement.setString(3, civico);
            statement.executeUpdate();
        }
    }
}
