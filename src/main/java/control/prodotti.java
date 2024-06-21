package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.prodottiDAO2;
import model.prodottoBean;


public class prodotti extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public prodotti() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("cicci"); // Parametro passato dalla richiesta (può essere null)
        List<prodottoBean> products = new ArrayList<>();
        prodottiDAO2 productDAO = new prodottiDAO2();

        try {
            products = productDAO.doRetrieveAll(param); // Recupera i prodotti dal DAO
            System.out.println("Number of products retrieved: " + products.size());

            // Stampa le informazioni dei prodotti recuperati (opzionale per debug)
            for (prodottoBean product : products) {
                System.out.println("Nome: " + product.getNome());
                System.out.println("Prezzo: " + product.getPrezzo());
                System.out.println("Descrizione: " + product.getDescrizione());
                System.out.println("ID: " + product.getIdProdotti());
                System.out.println("CoV: " + product.getCoV());
                System.out.println("Casa produttrice: " + product.getCasaProduttrice());
                System.out.println("Piattaforma: " + product.getPiattaforma());
                System.out.println("Genere: " + product.getGenere());
                System.out.println("Tipo: " + product.getTipo());
                System.out.println("Data di rilascio: " + product.getDataRilascio());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Puoi aggiungere gestione degli errori qui se necessario
        }

        // Imposta la collezione di prodotti come attributo della richiesta
        request.setAttribute("products", products);

        // Inoltra la richiesta alla pagina JSP
        request.getRequestDispatcher("/Prodotti.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

