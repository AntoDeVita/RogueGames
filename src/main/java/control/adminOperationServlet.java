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

@WebServlet("/adminOperationServlet")
public class adminOperationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public adminOperationServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        prodottiDAO2 dao = new prodottiDAO2();
        HttpSession s = request.getSession(false);
        
        if (s == null) {
            request.setAttribute("error", "Sessione non valida. Per favore, effettua il login.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }
        
        List<prodottoBean> pSession = (List<prodottoBean>) s.getAttribute("pSession");
        
        if (pSession == null) {
            request.setAttribute("error", "Nessun prodotto trovato in sessione.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }
        
        String act = request.getParameter("act");
        
        try {
            switch (act) {
                case "1": // Chiamata pulsante Elimina in admin.jsp
                    int id = Integer.parseInt(request.getParameter("idProdotto"));
                    Iterator<prodottoBean> it = pSession.iterator();
                    while (it.hasNext()) {
                        prodottoBean p = it.next();
                        if (p.getIdProdotti() == id) {
                            it.remove();
                        }
                    }
                    dao.doDelete(id);
                    break;
                case "2": // Chiamata pulsante Aggiungi in admin.jsp
                    // Aggiungi il codice per aggiungere un prodotto
                    break;
                case "3": // Chiamata pulsante Modifica in admin.jsp
                    // Aggiungi il codice per modificare un prodotto
                    break;
                default:
                    request.setAttribute("error", "Azione non valida.");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                    return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Errore SQL durante l'aggiornamento: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }
        
        s.setAttribute("pSession", pSession);
        request.setAttribute("pSession", pSession);
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

