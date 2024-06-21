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


public class testbd extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public testbd() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        prodottiDAO2 dao = new prodottiDAO2();
        
        try {
            // Recupera tutti i prodotti usando il metodo doRetrieveAll del DAO
            List<prodottoBean> products = dao.doRetrieveAll(null);

            
            // Imposta la lista dei prodotti come attributo della richiesta
            request.setAttribute("products", products);

            // Inoltra la richiesta alla pagina JSP
            request.getRequestDispatcher("/Prodotti.jsp").forward(request, response);

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


