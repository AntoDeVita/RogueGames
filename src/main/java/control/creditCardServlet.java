package control;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import model.clienteRegBean;
import model.prodottiDAO2;
import model.prodottoBean;
import model.CreditCardBean;
import model.CreditCardBeanDAO;
import model.CreditCardDao;


public class creditCardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
   

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        	throws ServletException, IOException {
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
		                		if (success==true) 
		                			request.getRequestDispatcher("/Profilo2.jsp").forward(request, response); 
		                		break;
		                	case 2:
		                		creditCardDao.DeleteCard(cl.getEmail(), cif);
		                		request.getRequestDispatcher("/Profilo2.jsp").forward(request, response);
		                		break;
		                }
    }   
        catch (SQLException e) {
        e.printStackTrace();
        request.setAttribute("error", "Database connection failed: " + e.getMessage());
        request.getRequestDispatcher("/error.jsp").forward(request, response);
       
    }
			} else {
	        	request.getRequestDispatcher("/login.jsp").forward(request, response);
	        }
	    }
       
        
}



