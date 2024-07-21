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


public class piattaformaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public piattaformaServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String plat = request.getParameter("piattaforma");
            prodottiDAO2 dao = new prodottiDAO2();
            
            
            List<prodottoBean> products = new ArrayList <prodottoBean>();
            try {

                products = dao.doRetrieveByPlat(plat);       

            }   
            catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Database connection failed: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
           
            	}   
                request.setAttribute("products", products);
                request.getRequestDispatcher("/piattaforma.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}