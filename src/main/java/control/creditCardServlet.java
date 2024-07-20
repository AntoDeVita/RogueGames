package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.clienteRegBean;
import model.CreditCardDao;

public class creditCardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CreditCardDao creditCardDao = new CreditCardDao();
        HttpSession session = request.getSession(false);
        clienteRegBean cl = (clienteRegBean) session.getAttribute("cl");

        if (cl != null) {
            int field = Integer.parseInt(request.getParameter("field"));
            String cif = request.getParameter("Cif");
            String CVV = request.getParameter("cvv");
            String Scadenza = request.getParameter("Scadenza");

            try {
                switch (field) {
                    case 1:
                        // Controlla se la carta di credito esiste già
                        boolean cardExists = creditCardDao.cardExists(cl.getEmail(), cif);
                        if (cardExists) {
                            // Imposta un attributo di errore e forward alla pagina di profilo
                            request.setAttribute("errorMessage", "La carta di credito è già presente.");
                            request.getRequestDispatcher("/Profilo.jsp").forward(request, response);
                        } else {
                            // Inserisci la carta di credito
                            boolean success = creditCardDao.insertCreditCard(cl.getEmail(), cif, CVV, Scadenza);
                            if (success) {
                                response.sendRedirect(request.getContextPath() + "/Profilo.jsp");
                            } else {
                                request.setAttribute("errorMessage", "Impossibile inserire la carta di credito.");
                                request.getRequestDispatcher("/Profilo.jsp").forward(request, response);
                            }
                        }
                        break;
                    case 2:
                        creditCardDao.DeleteCard(cl.getEmail(), cif);
                        response.sendRedirect(request.getContextPath() + "/Profilo.jsp");
                        break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "Errore di database: " + e.getMessage());
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
