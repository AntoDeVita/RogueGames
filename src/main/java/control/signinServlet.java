package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.clienteDAO;

public class signinServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public signinServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupero parametri dalla richiesta
        String username = request.getParameter("txtEmail");
        String password = request.getParameter("txtPass");
        String nome = request.getParameter("txtNome");
        String cognome = request.getParameter("txtCognome");
        String etaStr = request.getParameter("txtEta");
        String indirizzo = request.getParameter("txtIndirizzo");
        String telefono = request.getParameter("txtTelefono");

        // Validazione parametri
        boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder();

        if (!nome.matches("^[a-zA-Z]+$")) {
            isValid = false;
            errorMessage.append("Il campo Nome deve contenere solo lettere. ");
        }

        if (!cognome.matches("^[a-zA-Z]+$")) {
            isValid = false;
            errorMessage.append("Il campo Cognome deve contenere solo lettere. ");
        }

        if (!telefono.matches("^\\d{9}$")) {
            isValid = false;
            errorMessage.append("Il numero di telefono deve essere lungo esattamente 9 cifre. ");
        }

        int eta = 0;
        try {
            eta = Integer.parseInt(etaStr);
            if (eta < 12) {
                isValid = false;
                errorMessage.append("Devi avere almeno 12 anni. ");
            }
        } catch (NumberFormatException e) {
            isValid = false;
            errorMessage.append("Il campo Età deve essere un numero valido. ");
        }

        if (!isValid) {
            // In caso di errore, mostra i messaggi di errore e torna al form di login
            request.setAttribute("errorMessage", errorMessage.toString());
            request.getRequestDispatcher("/signin.jsp").forward(request, response);
            return;
        }

        // Salvataggio dati nel database
        clienteDAO userDAO = new clienteDAO();
        boolean cl;
        try {
            cl = userDAO.doSave(username, password, nome, cognome, eta, indirizzo, telefono);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Errore di connessione al database: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }

        // Reindirizzamento in base al risultato del salvataggio
        if (cl) {
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
