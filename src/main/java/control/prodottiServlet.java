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


public class prodottiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public prodottiServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        	response.getWriter().append("Served at: ").append(request.getContextPath());
        	String i = request.getParameter("param");
            prodottiDAO2 dao = new prodottiDAO2();
             
            try {
                
                List<prodottoBean> products = dao.doRetrieveAll(i);

             
                
                request.setAttribute("products", products);

            request.getRequestDispatcher("/prodott.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Database connection failed: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}


