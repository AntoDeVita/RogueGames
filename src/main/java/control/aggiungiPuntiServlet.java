package control;

import java.io.IOException;

import model.clienteRegBean;
import model.clienteDAO; // Assuming you have a DAO class for database operations

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/aggiungiPuntiServlet")
public class aggiungiPuntiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        clienteRegBean cliente = (clienteRegBean) session.getAttribute("cl");
        String sessionToken = (String) session.getAttribute("sessionToken");
		if(sessionToken!=null) {
            try {
                int numberOfProducts = Integer.parseInt(request.getParameter("numberOfProducts"));
                int pointsToAdd = numberOfProducts * 5;

                
                cliente.addPunti(pointsToAdd);

                      
                clienteDAO clienteDAO = new clienteDAO(); 
                boolean updated = clienteDAO.updateClientPoints(cliente.getEmail(), cliente.getPunti());     

                if (updated) {
                    session.setAttribute("cl", cliente);
                    
                } else {
                    // Handle database update failure
                    request.setAttribute("errorMessage", "Error updating points in the database.");
                   
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // Handle the error
                request.setAttribute("errorMessage", "Invalid number format.");
               
            }
        } else {
    		request.getRequestDispatcher("/ErrorePage.jsp").forward(request, response);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }
}


