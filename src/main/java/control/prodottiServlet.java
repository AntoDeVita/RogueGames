package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.prodottiDAO2;
import model.prodottoBean;


public class prodottiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public prodottiServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String i = request.getParameter("param");
            String stampa = request.getParameter("stampa");
            prodottiDAO2 dao = new prodottiDAO2();
            List<prodottoBean>products = new ArrayList<prodottoBean>();
            try {
            	switch(stampa) {
            		case("tutto"):
            			products = dao.doRetrieveAll(i);
                        request.setAttribute("products", products);
            			break;
            		case("anno"):
            			products = dao.doRetrieveAll(i);
                        request.setAttribute("products", products);
            			break;
            	}
            	


                //request.getSession().setAttribute("pSession", products);
                request.getRequestDispatcher("/prodotti.jsp").forward(request, response);
                return;
            

            }   
            catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Database connection failed: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
           
            	}
            //}	     
           
            /*request.getSession().setAttribute("pSession", products);
            request.setAttribute("pSession", products);
            request.getRequestDispatcher("/prodotti.jsp").forward(request, response);*/
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}