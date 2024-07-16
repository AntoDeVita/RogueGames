package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.clienteRegBean;
import model.CreditCardDao;


public class creditCardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public creditCardServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                        boolean success = creditCardDao.insertCreditCard(cl.getEmail(), cif, CVV, Scadenza);
                        if (success) {
                            response.sendRedirect(request.getContextPath() + "/Profilo2.jsp");
                        }
                        break;
                    case 2:
                        creditCardDao.DeleteCard(cl.getEmail(), cif);
                        response.sendRedirect(request.getContextPath() + "/Profilo2.jsp");
                        break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("error", "Database connection failed: " + e.getMessage());
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}




