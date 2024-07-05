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

/**
 * Servlet implementation class genreServlet
 */
public class genreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public genreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
    	String i = request.getParameter("param");
        prodottiDAO2 dao = new prodottiDAO2();
         
        try {
            
            List<prodottoBean> products = dao.doRetrieveByGen("param");
            request.setAttribute("products", products);

        
         
            


    } catch (SQLException e) {
        e.printStackTrace();
        request.setAttribute("error", "Database connection failed: " + e.getMessage());
        request.getRequestDispatcher("/error.jsp").forward(request, response);
        return;
    }
        
        request.getRequestDispatcher("/home.jsp").forward(request, response);
}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
