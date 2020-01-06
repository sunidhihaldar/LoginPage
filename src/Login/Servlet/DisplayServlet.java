package Login.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This servlet displays the welcome page to user and redirects the user to logout page
 * @author Sunidhi Haldar
 * @created 2019-12-27
 * @version 1.8
 */

@SuppressWarnings("serial")
public class DisplayServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		HttpSession session = req.getSession(false);
		if(session != null) {
			String username = (String) session.getAttribute("username");
			pw.println("Welcome " + username);
			//resp.sendRedirect("logout.jsp");
			RequestDispatcher rd = req.getRequestDispatcher("logout.jsp");
			rd.include(req, resp);
		}
		else {
			pw.println("You have to login");
			resp.sendRedirect("login.html");
		}
	}	
}
