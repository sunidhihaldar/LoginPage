package Login.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login.Model.User;
import Login.Service.IUserService;
import Login.ServiceImplementation.UserAddition;

/**
 * This class provides a functionality for a user to login securely by entering his username and password details and
 * if the data matches is redirects the user to display page
 * @author Sunidhi Haldar
 * @created 2019-12-27
 * @version 1.8
 */

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	
	/**
	 * This method fetches the username and password of the user, then checks with the data of the database, if present
	 * redirects the user to display page else shows the login page again
	 */
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		IUserService userDAO = new UserAddition();

		String inputUsername = req.getParameter("username");
		String inputPwd = req.getParameter("password");
		ResultSet fetchedUser = userDAO.getUser(inputUsername, inputPwd);

		try {
			if (fetchedUser.next()) {
				pw.println("Login successful");
				User user = new User();
				HttpSession session = req.getSession();
				user.setFirstName(fetchedUser.getString(1));
				user.setUsername(fetchedUser.getString(9));
				user.setPassword(fetchedUser.getString(10));
				session.setAttribute("username", inputUsername);
				RequestDispatcher rd = req.getRequestDispatcher("DisplayServ");
				rd.forward(req, resp);
			} else {
				pw.println("Invalid login");
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
	}

}