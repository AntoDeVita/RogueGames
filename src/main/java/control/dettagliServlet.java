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

public class dettagliServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public dettagliServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 prodottiDAO2 dao = new prodottiDAO2();
		 int id= Integer.parseInt(request.getParameter("param"));
			try {
	             prodottoBean p=dao.doRetrieveByKey(id);
		         request.setAttribute("p", p);
		         
     } catch (SQLException e) {
         e.printStackTrace();
         request.setAttribute("error", "Database connection failed: " + e.getMessage());
         request.getRequestDispatcher("/error.jsp").forward(request, response);
         return;
     }	            
	         request.getRequestDispatcher("/dettagliProdotto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
