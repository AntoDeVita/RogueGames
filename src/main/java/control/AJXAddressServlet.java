package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import model.IndirizzoSpedizioneBean;
import model.IndirizzoSpedizioneDAO;
import model.clienteRegBean;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AJXAddressServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AJXAddressServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        clienteRegBean cl = (clienteRegBean) request.getSession().getAttribute("cl");
        IndirizzoSpedizioneDAO dao = new IndirizzoSpedizioneDAO();
        HttpSession session = request.getSession();
        String sessionToken = (String) session.getAttribute("sessionToken");
		if(sessionToken!=null) {   
			if (cl != null) {
            List<IndirizzoSpedizioneBean> indirizzi = dao.getIndirizziByEmail(cl.getEmail());

			response.setContentType("application/xml");
			response.setCharacterEncoding("UTF-8");

			StringBuilder xmlResponse = new StringBuilder();
			xmlResponse.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			xmlResponse.append("<Addresses>");
			
			for (IndirizzoSpedizioneBean indirizzo : indirizzi) {
			    xmlResponse.append("<Address>");
			    xmlResponse.append("<Via>").append(indirizzo.getVia()).append("</Via>");
			    xmlResponse.append("<Civico>").append(indirizzo.getCivico()).append("</Civico>");
			    xmlResponse.append("<Cap>").append(indirizzo.getCap()).append("</Cap>");
			    xmlResponse.append("<Provincia>").append(indirizzo.getProvincia()).append("</Provincia>");
			    xmlResponse.append("<Citta>").append(indirizzo.getCitta()).append("</Citta>");
			    xmlResponse.append("</Address>");
			}

			xmlResponse.append("</Addresses>");

			response.getWriter().write(xmlResponse.toString());
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not logged in.");
        }
		}else {
			request.getRequestDispatcher("/ErrorePage.jsp").forward(request, response);
		}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}