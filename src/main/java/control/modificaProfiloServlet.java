package control;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.clienteRegBean;
import model.clienteDAO;

@WebServlet("/modificaProfiloServlet")
public class modificaProfiloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public modificaProfiloServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        clienteRegBean cl = (clienteRegBean) session.getAttribute("cl");

        if (cl != null) {
            String field = request.getParameter("field");
            String newValue = request.getParameter("newValue");

            clienteDAO userDAO = new clienteDAO();
            try {
                switch (field) {
                    case "nome":
                        cl.setNome(newValue);
                        userDAO.aggiornaCampo(cl, "Nome", newValue);
                        break;
                    case "cognome":
                        cl.setCognome(newValue);
                        userDAO.aggiornaCampo(cl, "Cognome", newValue);
                        break;
                    case "email":
                        cl.setEmail(newValue);
                        userDAO.aggiornaCampo(cl, "Email", newValue);
                        break;
                    case "telefono":
                        cl.setTelefono(newValue);
                        userDAO.aggiornaCampo(cl, "Tel", newValue);
                        break;
                    case "password":
                        String hashedPassword = hashSHA256(newValue);
                        cl.setPassword(hashedPassword);
                        userDAO.aggiornaCampo(cl, "Password", hashedPassword);
                        break;
                    default:
                        throw new IllegalArgumentException("Campo di modifica non valido");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("error", "Errore SQL durante l'aggiornamento: " + e.getMessage());
                request.getRequestDispatcher("/error.jsp").forward(request, response);
                return;
            }

            session.setAttribute("cl", cl);
            response.sendRedirect("Profilo2.jsp");
        } else {
            request.setAttribute("error", "Utente non autenticato.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    private String hashSHA256(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder(2 * hash.length);

            for (byte b : hash) {
                String hex = String.format("%02x", b);
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}


