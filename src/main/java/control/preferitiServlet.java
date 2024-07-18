package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.prodottiDAO2;
import model.prodottoBean;
import model.preferiti;
import model.pPreferitiBean;
import model.clienteRegBean;

public class preferitiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public preferitiServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		 /*prodottiDAO2 dao = new prodottiDAO2();
		 preferiti ppref = (preferiti) request.getSession().getAttribute("ppref");
		 pPreferitiBean pc;
			if(ppref == null) {
				ppref = new preferiti();
				request.getSession().setAttribute("ppref", ppref);
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
				    	  pc=new pPreferitiBean(dao.doRetrieveByKey(id));
				    	  ppref.addPref(pc);
				        break;
				      case "delete":
				    	  pc=new pPreferitiBean(dao.doRetrieveByKey(id));
				    	  ppref.removePref(pc);
				        break;
				      case "deleteAll":
				    	  ppref.svuota();
				        break;
				    }
				}
	            
				
     } catch (SQLException e) {
         e.printStackTrace();
         request.setAttribute("error", "Database connection failed: " + e.getMessage());
         request.getRequestDispatcher("/error.jsp").forward(request, response);
         return;
     }
		    
			 request.getSession().setAttribute("ppref", ppref);
	         request.setAttribute("ppref", ppref);
	         request.getRequestDispatcher("/preferiti.jsp").forward(request, response);
	*/
		
		
		prodottiDAO2 dao = new prodottiDAO2();
        preferiti ppref = (preferiti) request.getSession().getAttribute("ppref");
        pPreferitiBean pc;
        if (ppref == null) {
            ppref = new preferiti();
            request.getSession().setAttribute("ppref", ppref);
        }
        String act = request.getParameter("act");
        String i = request.getParameter("param");
        int id = 0;
        if (i != null)
            id = Integer.parseInt(i);

        try {
            if (act != null) {
                switch (act) {
                    case "add":
                        pc = new pPreferitiBean(dao.doRetrieveByKey(id));
                        ppref.addPref(pc);
                        break;
                    case "delete":
                        pc = new pPreferitiBean(dao.doRetrieveByKey(id));
                        ppref.removePref(pc);
                        break;
                    case "deleteAll":
                        ppref.svuota();
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Database connection failed: " + e.getMessage());
            return;
        }
        request.getSession().setAttribute("ppref", ppref);
        request.setAttribute("ppref", ppref);
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("Success");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
