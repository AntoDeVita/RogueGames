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

@WebServlet("/prodottiHomeServlet")
public class prodottiHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public prodottiHomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		prodottiDAO2 dao = new prodottiDAO2();
    	
    	try {
            
            List<prodottoBean> products = dao.doRetrieveAll(" rand() limit 6");
            request.setAttribute("random", products);

            // Imposta il tipo di contenuto della risposta
            response.setContentType("application/xml");
            response.setCharacterEncoding("UTF-8");

            // Costruisci la risposta XML
            StringBuilder xmlResponse = new StringBuilder();
            xmlResponse.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            xmlResponse.append("<products>");
            for (prodottoBean product : products) {
                xmlResponse.append("<product>");
                xmlResponse.append("<id>").append(product.getIdProdotti()).append("</id>");
                xmlResponse.append("<img>").append(product.getImmagine()).append("</img>");
                xmlResponse.append("<name>").append(product.getNome()).append("</name>");
                xmlResponse.append("<price>").append(product.getPrezzo()).append("</price>");
                xmlResponse.append("</product>");
            }
            xmlResponse.append("</products>");
  
            response.getWriter().write(xmlResponse.toString());
        
         
            


    } catch (SQLException e) {
        e.printStackTrace();
        request.setAttribute("error", "Database connection failed: " + e.getMessage());
        request.getRequestDispatcher("/error.jsp").forward(request, response);
        return;
    }
    	
    	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
