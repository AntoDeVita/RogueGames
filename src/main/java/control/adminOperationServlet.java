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

@WebServlet("/adminOperationServlet")
public class adminOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public adminOperationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		prodottiDAO2 dao = new prodottiDAO2();
	    List<prodottoBean> pSession = (List<prodottoBean>) request.getSession().getAttribute("pSession");
		String act= request.getParameter("act");
		try {
			switch (act) {
				case "1"://Chiamata pulsante Elimina in admin.jsp
					int id = Integer.parseInt(request.getParameter("idProdotto"));
					for(prodottoBean p:pSession) {
						if(p.getIdProdotti()==id) {
							pSession.remove(p);
						}
					}
			        dao.doDelete(id);
			        
			        break;
				case "2"://Chiamata pulsante Aggiungi in admin.jsp
					break;
				case "3"://Chiamata pulsante Modifica in admin.jsp
					break;
			}
		}catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Errore SQL durante l'aggiornamento: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }
		request.getSession().setAttribute("pSession", pSession);
		request.setAttribute("pSession", pSession);
		request.getRequestDispatcher("/admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
