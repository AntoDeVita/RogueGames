package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AJXCreditservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AJXCreditservlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        clienteRegBean cl = (clienteRegBean) request.getSession().getAttribute("cl");
        CreditCardDao dao = new CreditCardDao();

        if (cl != null) {
            try {
                List<String> cif = dao.doRetrieveAll(cl.getEmail());

                response.setContentType("application/xml");
                response.setCharacterEncoding("UTF-8");

                StringBuilder xmlResponse = new StringBuilder();
                xmlResponse.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                xmlResponse.append("<Cards>");
                for (String c : cif) {
                    xmlResponse.append("<Card>");
                    xmlResponse.append("<Cif>").append(c).append("</Cif>");
                    xmlResponse.append("</Card>");
                }
                xmlResponse.append("</Cards>");

                response.getWriter().write(xmlResponse.toString());
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database connection failed: " + e.getMessage());
            }
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not logged in.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

