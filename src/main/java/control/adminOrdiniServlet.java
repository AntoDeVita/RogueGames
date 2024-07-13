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

import model.ordineDAO;
import model.ordineBean;

public class adminOrdiniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public adminOrdiniServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ordineDAO dao = new ordineDAO();
	    try {
	    	int num= Integer.parseInt(request.getParameter("num"));
	    	if(num==0) {//0- Stampa tutti non ordinati
		        List<ordineBean> ordini = dao.doRetrieveAll();
		        request.setAttribute("ordini", ordini);
		        request.getRequestDispatcher("/ordine.jsp").forward(request, response);
	    	}else if(num==1) {//1- Stampa tutti ordinati da data x a data y
	    		String dataX = request.getParameter("dataX");
	    		String dataY = request.getParameter("dataY");
	    		List<ordineBean> ordini= dao.doRetrieveAllFromDateXToDateY(dataX, dataY);
	    		request.setAttribute("ordini", ordini);
		        request.getRequestDispatcher("/ordine.jsp").forward(request, response);
	    	}else if(num==2){//2- Stampa tutti ordinati per utente
	    		List<ordineBean> ordini= dao.doRetrieveAllOrderedByEmail();
	    		request.setAttribute("ordini", ordini);
		        request.getRequestDispatcher("/ordine.jsp").forward(request, response);
	    	}
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
