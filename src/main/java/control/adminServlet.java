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

import model.prodottiDAO2;
import model.prodottoBean;

@WebServlet("/adminServlet")
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public adminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<prodottoBean> pSession= (List<prodottoBean>) request.getSession().getAttribute("pSession");
		if(pSession==null) {
			pSession= new <prodottoBean> ArrayList();
			request.getSession().setAttribute("pSession", pSession);
		}
		prodottiDAO2 dao = new prodottiDAO2();
	    try {
	    	 String id = request.getParameter("param");
	         List<prodottoBean> products = dao.doRetrieveAll(id);
	         pSession.addAll(products);
	         request.setAttribute("pSession", pSession);
	         request.getSession().setAttribute("pSession", pSession);
	         request.getRequestDispatcher("/admin.jsp").forward(request, response);
	    }   
	    catch (SQLException e) {
	    	e.printStackTrace();
	        request.setAttribute("error", "Database connection failed: " + e.getMessage());
	        request.getRequestDispatcher("/error.jsp").forward(request, response);
	       
	     }
}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
