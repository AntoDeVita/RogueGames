package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.clienteDAO;
import model.clienteRegBean;

public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public loginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("txtEmail");
        String password = request.getParameter("txtPass");

        clienteDAO userDAO = new clienteDAO();
    	clienteRegBean cl= new clienteRegBean();

        try {
        	cl = userDAO.doLogin(username, password);
            
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Errore di connessione al database: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response); // Reindirizza a una pagina di errore generico
            return ;
        }
        if (cl != null) {
            HttpSession session = request.getSession();
            session.setAttribute("cl", cl); // Salva l'utente autenticato nella sessione
	         request.getRequestDispatcher("/home.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Gestione dei GET non necessaria per la login, possiamo reindirizzare al POST
        doPost(request, response);
    }
}