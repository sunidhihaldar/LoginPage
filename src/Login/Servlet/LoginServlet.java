package Login.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	    User fetchedUser = userDAO.getUser(inputUsername, inputPwd);
	    
	    if(fetchedUser != null) {
	    	pw.println("Login successful");
	    	RequestDispatcher rd = req.getRequestDispatcher("DisplayServ");
			rd.forward(req, resp);
	    }
	    else {
	    	pw.println("Invalid login");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, resp);
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
	
}
