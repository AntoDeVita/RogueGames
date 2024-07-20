package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PCarrelloDAO;
import model.carrello;
import model.clienteDAO;
import model.clienteRegBean;
import model.pCarrelloBean;

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
            
            PCarrelloDAO daoc=new PCarrelloDAO();
            List <pCarrelloBean> pcarr=new ArrayList<pCarrelloBean>();
            carrello pcart=(carrello) request.getSession().getAttribute("pcart");
            
            try {
        		pcarr = daoc.doRetrieveAll(cl.getEmail());
        		
			} catch (SQLException e) {
			    e.printStackTrace();
	            request.setAttribute("error", "Errore di connessione al database: " + e.getMessage());
	            request.getRequestDispatcher("/error.jsp").forward(request, response); // Reindirizza a una pagina di errore generico
	            return ;
			}
            
            if(pcart==null) {	
				pcart = new carrello();
            	for(pCarrelloBean p : pcarr) {
            		pcart.addCarr(p);
            	}
				request.getSession().setAttribute("pcart", pcart);
            }else {
  	
            	for(pCarrelloBean p : pcarr) {
            		pcart.addCarr(p);
            	}
            	
            	pcarr=pcart.getProdotti();
            	
            	for(pCarrelloBean p : pcarr) {
            		pCarrelloBean d;
					int id=p.getIdProdotti();
					String email=cl.getEmail();
            		try {
						if(!daoc.doRetrieveByKey(id, email)) {
								daoc.doSave(p, email);
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
			            request.setAttribute("error", "Errore di connessione al database: " + e.getMessage());
			            request.getRequestDispatcher("/error.jsp").forward(request, response); // Reindirizza a una pagina di errore generico
			            return ;
					}
					
            	}
            	
            	request.getSession().setAttribute("pcart", pcart);
            }
	        request.getRequestDispatcher("/home.jsp").forward(request, response);
        }else {
            request.setAttribute("error", "Credenziali errate. Riprova.");
            request.getRequestDispatcher("/login.jsp").forward(request, response); // Reindirizza alla pagina di login
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Gestione dei GET non necessaria per la login, possiamo reindirizzare al POST
        doPost(request, response);
    }
}
