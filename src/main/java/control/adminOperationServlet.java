package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.prodottiDAO2;
import model.prodottoBean;

public class adminOperationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public adminOperationServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        prodottiDAO2 dao = new prodottiDAO2();
        String act = request.getParameter("act");
    	prodottoBean prod;
    	HttpSession session = request.getSession();
        String sessionToken = (String) session.getAttribute("sessionToken");
    	System.out.println(act);
		if(sessionToken!=null) {
        try {
        	if(act!=null) {

            switch (act) {
                case "1": // Chiamata pulsante Elimina in admin.jsp
                    int id = Integer.parseInt(request.getParameter("idProdotto"));
                    dao.doDelete(id);
                    break;
                case "2":  // Chiamata pulsante Aggiungi in admin.jsp
                	prod= new prodottoBean();
                	prod.setNome(request.getParameter("nome"));
                	prod.setImmagine(request.getParameter("img"));
                	prod.setVideo(request.getParameter("video"));
                	prod.setDescrizione(request.getParameter("dsc"));
                	prod.setCoV(Boolean.valueOf(request.getParameter("cov")));
                	prod.setPrezzo(Double.parseDouble(request.getParameter("prz").trim()));
                	prod.setCasaProduttrice(request.getParameter("casaPrd"));
                	prod.setPiattaforma(request.getParameter("pltf"));
                	prod.setGenere(request.getParameter("gnr"));
                	prod.setTipo(request.getParameter("tipo"));
                	prod.setDataRilascio(request.getParameter("releaseDate"));
                	prod.setQuantita(Integer.parseInt(request.getParameter("qnt")));
                	dao.doSave(prod);
                	break;
                case "3": // Chiamata pulsante Modifica in admin.jsp
                	prod= new prodottoBean();
                	int i= Integer.parseInt(request.getParameter("idProdotto"));
                	prod.setNome(request.getParameter("nome"));
                	prod.setImmagine(request.getParameter("img"));
                	prod.setVideo(request.getParameter("video"));
                	prod.setDescrizione(request.getParameter("dsc"));
                	prod.setCoV(Boolean.valueOf(request.getParameter("cov")));
                	prod.setPrezzo(Double.parseDouble(request.getParameter("prz").trim()));
                	prod.setCasaProduttrice(request.getParameter("casaPrd"));
                	prod.setPiattaforma(request.getParameter("pltf"));
                	prod.setGenere(request.getParameter("gnr"));
                	prod.setTipo(request.getParameter("tipo"));
                	prod.setDataRilascio(request.getParameter("releaseDate"));
                	prod.setQuantita(Integer.parseInt(request.getParameter("qnt")));
                	dao.doUpdate(prod, i);

                    break;
                default:
                    request.setAttribute("error", "Azione non valida.");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                    return;
            }
          }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Errore SQL durante l'aggiornamento: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }
        
        request.getRequestDispatcher("adminServlet").forward(request, response);
    }else {
		request.getRequestDispatcher("/ErrorePage.jsp").forward(request, response);
	}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

