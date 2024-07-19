package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.prodottiDAO2;
import model.prodottoBean;

@WebServlet("/ricercaAction")
public class ricercaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ricercaAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Impostazione del tipo di risposta ad una stringa json
				response.setContentType("application/json");

				// Impostazione del set di caratteri
				request.setCharacterEncoding("UTF-8");

				// Richiesta di ricerca dell'utente
				String query = request.getParameter("query");

				ArrayList<prodottoBean> risultato = new ArrayList<>();
				ArrayList<prodottoBean> catalogoProdotti = new ArrayList<>();
				prodottiDAO2 dao = new prodottiDAO2();
				
				try {
					Collection<?> collezioneProdotti = (Collection<?>) dao.doRetrieveAll("");

					if (collezioneProdotti != null && collezioneProdotti.size() != 0) {
						// Inserimento dei bean del manga nella lista del catalogo
						Iterator<?> iteratoreLista = collezioneProdotti.iterator();
						while (iteratoreLista.hasNext()) {
							prodottoBean prod = (prodottoBean) iteratoreLista.next();
							catalogoProdotti.add(prod);
						}

						// Confronto della query con i titoli dei manga
						for (prodottoBean m : catalogoProdotti) {
							for (int i = 0; i < m.getNome().length() - 1; i++) {
								for (int j = i + 1; j < m.getNome().length(); j++) {
									if (((String) m.getNome().subSequence(i, j)).equalsIgnoreCase(query)
											&& !risultato.contains(m)) {
										risultato.add(m);
									}
								}
							}
						}
					}
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());

				}

				// Creazione stringa JSON di risposta
				String json = new Gson().toJson(risultato);
				response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
