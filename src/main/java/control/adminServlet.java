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
		/*List<prodottoBean> pSession= (List<prodottoBean>) request.getSession().getAttribute("pSession");
		if(pSession==null) {
			pSession= new  ArrayList<prodottoBean>();
			request.getSession().setAttribute("pSession", pSession);
		}
		if(pSession.isEmpty()){*/
		prodottiDAO2 dao = new prodottiDAO2();
	    try {
	         List<prodottoBean> products = dao.doRetrieveAll("idProdotti");
	         //pSession.addAll(products);
	         request.setAttribute("products", products);
	         //request.getSession().setAttribute("pSession", pSession);
	         request.getRequestDispatcher("/admin.jsp").forward(request, response);
	    }   
	    catch (SQLException e) {
	    	e.printStackTrace();
	        request.setAttribute("error", "Database connection failed: " + e.getMessage());
	        request.getRequestDispatcher("/error.jsp").forward(request, response);
	       
	     }
	    /*}else
			request.getRequestDispatcher("/admin.jsp").forward(request, response);
		*/
}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
