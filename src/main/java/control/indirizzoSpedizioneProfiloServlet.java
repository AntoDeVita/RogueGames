package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.IndirizzoSpedizioneDAO;
import model.clienteRegBean;

public class indirizzoSpedizioneProfiloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public indirizzoSpedizioneProfiloServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IndirizzoSpedizioneDAO indirizzoDAO = new IndirizzoSpedizioneDAO();
        HttpSession session = request.getSession(false);
        clienteRegBean cl = (session != null) ? (clienteRegBean) session.getAttribute("cl") : null;
        String action = request.getParameter("action");
        String sessionToken = (String) session.getAttribute("sessionToken");
		if(sessionToken!=null) {
	        if (cl == null) {
	            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not logged in.");
	            return;
	        }
	
	        if ("add".equals(action)) {
	            String via = request.getParameter("via");
	            String civico = request.getParameter("civico");
	            String cap = request.getParameter("cap");
	            String provincia = request.getParameter("provincia");
	            String citta = request.getParameter("citta");
	
	            try {
	                // Verifica se l'indirizzo esiste già
	                boolean exists = indirizzoDAO.addressExists(cl.getEmail(), via, civico, cap, provincia, citta);
	                if (exists) {
	                    request.setAttribute("errorMessage", "L'indirizzo esiste già.");
	                    request.getRequestDispatcher("/Profilo.jsp").forward(request, response);
	                } else {
	                    indirizzoDAO.saveAddress(cl.getEmail(), via, civico, cap, provincia, citta);
	                    response.sendRedirect(request.getContextPath() + "/Profilo.jsp");
	                }
	            } catch (Exception e) {
	                request.setAttribute("errorMessage", "Errore durante il salvataggio dell'indirizzo: " + e.getMessage());
	                request.getRequestDispatcher("/Profilo.jsp").forward(request, response);
	            }
	        } else if ("delete".equals(action)) {
	            String via = request.getParameter("via");
	            String civico = request.getParameter("civico");
	
	            try {
	                indirizzoDAO.deleteAddress(cl.getEmail(), via, civico);
	                response.sendRedirect(request.getContextPath() + "/Profilo.jsp");
	            } catch (Exception e) {
	                request.setAttribute("errorMessage", "Errore durante la cancellazione dell'indirizzo: " + e.getMessage());
	                request.getRequestDispatcher("/Profilo.jsp").forward(request, response);
	            }
	        } else {
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Azione non valida.");
	        }
		}else {
			request.getRequestDispatcher("/ErrorePage.jsp").forward(request, response);
		}
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
