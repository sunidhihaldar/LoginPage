package Login.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This servlet allows the user to logout and user is redirected to the login page
 * @author Sunidhi Haldar
 * @created 2020-01-04
 * @version 1.8
 */

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession(true);
		session.removeAttribute("username");
		session.invalidate();
		pw.println("You have successfully logged out");
		response.sendRedirect("login.html");
	}
}
