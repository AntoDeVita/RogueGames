package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ordineBean;
import model.ordineDAO;

@WebServlet("/profiloServlet")
public class profiloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public profiloServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ordineDAO dao = new ordineDAO();
        String email = request.getParameter("param");

        try {
        	List<ordineBean> ordini = dao.doRetrieveForClient(email);
        	request.setAttribute("ordini", ordini);
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Database connection failed: " + e.getMessage());
            return;
        }

        request.getRequestDispatcher("/ordiniUtente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
