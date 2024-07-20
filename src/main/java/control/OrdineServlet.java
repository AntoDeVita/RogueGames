package control;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

/**
 * Servlet implementation class OrdineServlet
 */
public class OrdineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public OrdineServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false);
	        if (session == null) {
	            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Sessione non valida");
	            return;
	        }

	        String sessionToken = (String) session.getAttribute("sessionToken");
	        String requestToken = request.getParameter("sessionToken");

	        if (sessionToken == null || !sessionToken.equals(requestToken)) {
	            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Richiesta duplicata");
	            return;
	        }

	        sessionToken = UUID.randomUUID().toString();
	        session.setAttribute("sessionToken", sessionToken);

	        clienteRegBean cl = (clienteRegBean) session.getAttribute("cl");
	        carrello pcart = (carrello) session.getAttribute("pcart");
			ordineDAO dao=new ordineDAO();
			prodottiDAO2 daop=new prodottiDAO2();
			String sc= request.getParameter("sc");
			
			List <pCarrelloBean> cart=pcart.getProdotti();
			Iterator<?> it = cart.iterator();
			int i=0;
			if(cl!=null) {
				List <ordineBean> ordine= new ArrayList <ordineBean>();
				double prezzoTot=pcart.prezzoTot()-(Double.parseDouble(sc)/10.00);
			   
				for (pCarrelloBean bean : cart) {
					i++;
					
		            int id = bean.getIdProdotti();
		            String nome = bean.getProdotto().getNome();
		            double prezzo = bean.getPrezzo();
		            int quantita = bean.getIdQuantita();
		            
		            ordineBean order = new ordineBean();
		            
		            order.setIdProdotto(id);
		            order.setNome(nome);
		            order.setPrezzo(prezzo);
		            order.setEmail(cl.getEmail());
		            order.setPrezzoTot(prezzoTot);
		            order.setQuantita(quantita);
		            ordine.add(order);
				}
				i=i*5;
				cl.addPunti(i);
				int s=Integer.parseInt(sc);
				try {
					
					dao.doSave(ordine);
					
	                clienteDAO clienteDAO = new clienteDAO();
	                boolean updated = clienteDAO.updateClientPoints(cl.getEmail(), (cl.getPunti()-s)); 
	                
	                PCarrelloDAO daoc = new PCarrelloDAO();
	                daoc.doDeleteAll(cl.getEmail());
	                
				}catch (SQLException e) {
			    	e.printStackTrace();
			        request.setAttribute("error", "Database connection failed: " + e.getMessage());
			        request.getRequestDispatcher("/error.jsp").forward(request, response);
			       
			     }
			}else {
		        request.setAttribute("error", "Utente non loggato connection failed");
		        request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
			
			pcart.svuota();
	        request.getRequestDispatcher("/carrello.jsp").forward(request, response);
	  
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
