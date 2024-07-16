package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.prodottiDAO2;
import model.prodottoBean;
import model.PCarrelloDAO;
import model.carrello;
import model.pCarrelloBean;
import model.clienteRegBean;
/**
 * Servlet implementation class carrelloServlet
 */

public class carrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public carrelloServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 HttpSession session = request.getSession(false);
		 clienteRegBean cl=(clienteRegBean) session.getAttribute("cl");
		
		 prodottiDAO2 dao = new prodottiDAO2();
		 PCarrelloDAO daoc = new PCarrelloDAO();
		 carrello pcart = (carrello) request.getSession().getAttribute("pcart");
		 pCarrelloBean pc;
			if(pcart == null) {
				pcart = new carrello();
				request.getSession().setAttribute("pcart", pcart);
			}
			String act = request.getParameter("act");
		    String i = request.getParameter("param");
		    int id=0;
		    if(i!=null)
		    	id=Integer.parseInt(i);

			try {
	             
				if(act!=null) {
					switch (act) {
				      case "add":
				    	  pc=new pCarrelloBean(dao.doRetrieveByKey(id));
				    	  int d=pcart.addCarr(pc); //ritorna 1 se il prodotto è già presente altrimenti 0
				    	  if(cl!=null && d==0)
				    		  daoc.doSave(pc, cl.getEmail());
				        break;
				      case "delete":
				    	  pc=new pCarrelloBean(dao.doRetrieveByKey(id));
				    	  boolean d1= pcart.removeCarr(pc);
				    	  if(cl!=null && d1)
				    	  daoc.doDelete(id, cl.getEmail());
				        break;
				      case "dec":
				    	  pcart.getProd(id).decrementaQnt();
				    	  if(cl!=null) {
				    		  daoc.doUpdateQnt(id, pcart.getProd(id).getIdQuantita(), cl.getEmail(), pcart.getProd(id).getPrezzo());
				    	  	}
				        break;
				      case "inc":
				    	  pcart.getProd(id).incrementaQnt();
				    	  if(cl!=null) {
				    		  daoc.doUpdateQnt(id, pcart.getProd(id).getIdQuantita(), cl.getEmail(), pcart.getProd(id).getPrezzo());
				    	  }
				        break;
				      case "deleteAll":
				    	  pcart.svuota();
				    	  if(cl!=null)
				    		  daoc.doDeleteAll(cl.getEmail());
				        break;
				    }
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
