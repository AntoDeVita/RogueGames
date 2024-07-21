package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class logoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	public class LogoutServlet extends HttpServlet {
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String userId = "user123"; 

	        HttpSession session = request.getSession(false); 
	        	session.removeAttribute("cl");
	            session.invalidate(); 
	        }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
	}
}

