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
    	
        prodottiDAO2 dao = new prodottiDAO2();
        String genre = request.getParameter("genre");
        String f= "Fantasy";
        try {
            
            List<prodottoBean> products = dao.doRetrieveByGen(genre);
            request.setAttribute("products", products);

            // Imposta il tipo di contenuto della risposta
            response.setContentType("application/xml");
            response.setCharacterEncoding("UTF-8");

            // Costruisci la risposta XML
            StringBuilder xmlResponse = new StringBuilder();
            xmlResponse.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            xmlResponse.append("<products>");
            for (prodottoBean product : products) {
                xmlResponse.append("<product>");
                xmlResponse.append("<name>").append(product.getNome()).append("</name>");
                xmlResponse.append("<price>").append(product.getPrezzo()).append("</price>");
                xmlResponse.append("<img>").append(product.getImmagine()).append("</img>");
                xmlResponse.append("</product>");
            }
            xmlResponse.append("</products>");
  
            response.getWriter().write(xmlResponse.toString());
        
         
            


    } catch (SQLException e) {
        e.printStackTrace();
        request.setAttribute("error", "Database connection failed: " + e.getMessage());
        request.getRequestDispatcher("/error.jsp").forward(request, response);
        return;
    }
        
        //request.getRequestDispatcher("/home.jsp").forward(request, response);
}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

