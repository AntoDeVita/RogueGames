package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.prodottiDAO2;
import model.prodottoBean;
import model.carrello;
import model.pCarrelloBean;
import model.clienteRegBean;
/**
 * Servlet implementation class carrelloServlet
 */

public class carrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public carrelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 prodottiDAO2 dao = new prodottiDAO2();
		 carrello pcart = (carrello) request.getSession().getAttribute("pcart");
		 pCarrelloBean pc;
			if(pcart == null) {
				pcart = new carrello();
				request.getSession().setAttribute("pcart", pcart);
			}
			String act = request.getParameter("act");
		    int id = Integer.parseInt(request.getParameter("param"));
		   


			try {
	             
				pc=new pCarrelloBean(dao.doRetrieveByKey(1));
				if(act!=null) {
	            if(act.equalsIgnoreCase("add")) 
	            	pcart.addCarr(pc);
	            else
	            	if(act.equalsIgnoreCase("delete")) 
		            	pcart.removeCarr(pc);
			}

     } catch (SQLException e) {
         e.printStackTrace();
         request.setAttribute("error", "Database connection failed: " + e.getMessage());
         request.getRequestDispatcher("/error.jsp").forward(request, response);
         return;
     }	            
			 request.getSession().setAttribute("pcart", pcart);
	         request.setAttribute("pcart", pcart);

	         request.getRequestDispatcher("/carrello.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
