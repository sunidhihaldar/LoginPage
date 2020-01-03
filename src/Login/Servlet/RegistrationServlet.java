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
public class RegistrationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		IUserService service = new UserAddition();
		User newUser = new User();

		String fetchedFname = req.getParameter("fname");
		String fetchedSname = req.getParameter("sname");
		String fetchedDOB = req.getParameter("dob");
		String fetchedGender = req.getParameter("gender");
		String fetchedEmail = req.getParameter("email");
		String fetchedContact = req.getParameter("contact");
		String fetchedAddress = req.getParameter("address");
		String fetchedCountry = req.getParameter("country");
		String fetchedUname = req.getParameter("username");
		String fetchedPwd = req.getParameter("password");
		//check point System.out.println(fetchedAddress);
		
		newUser.setFirstName(fetchedFname);
		newUser.setLastName(fetchedSname);
		newUser.setDob(fetchedDOB);
		newUser.setGender(fetchedGender);
		newUser.setEmail(fetchedEmail);
		newUser.setMobilenumber(fetchedContact);
		newUser.setAddress(fetchedAddress);
		newUser.setCountry(fetchedCountry);
		newUser.setUsername(fetchedUname);
		newUser.setPassword(fetchedPwd);
		//check point System.out.println("sending data to database validation");

		if (service.insertUser(newUser) >= 1) {
			pw.println("User registred successfully");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
			dispatcher.include(req, resp);
		} else {
			pw.println("Opps!!! please register again...");
			RequestDispatcher dispatcher = req.getRequestDispatcher("registration.html");
			dispatcher.include(req, resp);
		}

	}

}
