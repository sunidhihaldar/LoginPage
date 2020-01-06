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


@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		IUserService userDAO = new UserAddition();

		String inputUsername = req.getParameter("username");
	    String inputPwd = req.getParameter("password");
	    ResultSet fetchedUser = userDAO.getUser(inputUsername, inputPwd);
	    
	    //if(fetchedUser != null)
		try {
			if(fetchedUser.next()) {
				pw.println("Login successful");
				User user = new User();
				HttpSession session = req.getSession();
				user.setFirstName(fetchedUser.getString(1));
				user.setUsername(fetchedUser.getString(9));
				user.setPassword(fetchedUser.getString(10));
				session.setAttribute("username", inputUsername);
				RequestDispatcher rd = req.getRequestDispatcher("DisplayServ");
				rd.forward(req, resp);
			}
			else {
					pw.println("Invalid login");
					RequestDispatcher rd = req.getRequestDispatcher("login.html");
					rd.include(req, resp);
			}
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		} 
	}
//			int i = pst.executeUpdate();
//			if(i > 0) {
//				pw.println("You have registered successfully");
//	        }
			
//			ResultSet rs = pst.executeQuery();
//			if(rs.next()) {
//				pw.println("Login successful");
//				RequestDispatcher rd = req.getRequestDispatcher("request");
//				rd.forward(req, resp);
//			}
//			else {
//				pw.println("Invalid login");
//				RequestDispatcher rd = req.getRequestDispatcher("login.html");
//				rd.include(req, resp);
//			}
	
}