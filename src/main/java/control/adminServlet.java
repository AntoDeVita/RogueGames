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

import model.prodottiDAO2;
import model.prodottoBean;

public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public adminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		prodottiDAO2 dao = new prodottiDAO2();
		HttpSession session = request.getSession();
        String sessionToken = (String) session.getAttribute("sessionToken");
		if(sessionToken!=null) {
		    try {
		         List<prodottoBean> products = dao.doRetrieveAll("idProdotti");
		         request.setAttribute("products", products);
		         request.getRequestDispatcher("/admin.jsp").forward(request, response);
		    }   
		    catch (SQLException e) {
		    	e.printStackTrace();
		        request.setAttribute("error", "Database connection failed: " + e.getMessage());
		        request.getRequestDispatcher("/error.jsp").forward(request, response);
		       
		    }
		}else {
			request.getRequestDispatcher("/ErrorePage.jsp").forward(request, response);
		}
}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
