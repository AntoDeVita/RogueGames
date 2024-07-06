package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ClientBeanDAO;
import model.clienteDAO;
import model.clienteRegBean;

public class signinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public signinServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("txtEmail");
	     String password = request.getParameter("txtPass");
	     String nome = request.getParameter("txtNome");
	     String cognome = request.getParameter("txtCognome");
	     int eta = Integer.parseInt(request.getParameter("txtEta"));
	     String indirizzo = request.getParameter("txtIndirizzo");
	     int telefono = Integer.parseInt(request.getParameter("txtTelefono"));
	     
	     clienteDAO userDAO = new clienteDAO();
	     boolean cl;
	        try {
	        	cl = userDAO.doSave(username, password, nome, cognome, eta, indirizzo, telefono);
	        	request.setAttribute("cl", cl);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            request.setAttribute("error", "Errore di connessione al database: " + e.getMessage());
	            request.getRequestDispatcher("/error.jsp").forward(request, response); // Reindirizza a una pagina di errore generico
	            return ;
	        }
	        if (cl == false) {
		         request.getRequestDispatcher("/login.jsp").forward(request, response); // Reindirizza alla page di login se la registrazione è avvenuta con successo
	        }
	        else {
	            request.getRequestDispatcher("/signin.jsp").forward(request, response); // Reindirizza alla page di registrazione se la registrazione è avvenuta con successo
	        }
     }

		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}