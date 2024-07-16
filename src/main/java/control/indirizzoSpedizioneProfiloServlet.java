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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IndirizzoSpedizioneDAO indirizzoDAO = new IndirizzoSpedizioneDAO();
        HttpSession session = request.getSession(false);
        clienteRegBean cl = (session != null) ? (clienteRegBean) session.getAttribute("cl") : null;
        
        String action = request.getParameter("action");

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
                indirizzoDAO.saveAddress(cl.getEmail(), via, civico, cap, provincia, citta);
                response.setStatus(HttpServletResponse.SC_OK);
                response.sendRedirect(request.getContextPath() + "/Profilo.jsp");
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                e.printStackTrace();
            }
        } else if ("delete".equals(action)) {
            String via = request.getParameter("via");
            String civico = request.getParameter("civico");
            // Potresti voler considerare un ID unico per l'indirizzo

            try {
                indirizzoDAO.deleteAddress(cl.getEmail(), via, civico); // Adjust method as needed
                response.setStatus(HttpServletResponse.SC_OK);
                response.sendRedirect(request.getContextPath() + "/Profilo.jsp");
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                e.printStackTrace();
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action.");
        }
    }
}

