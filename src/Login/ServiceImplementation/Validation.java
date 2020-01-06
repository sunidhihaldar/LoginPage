package Login.ServiceImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Login.Database.DBConnection;
import Login.Service.IValidate;

public class Validation implements IValidate {

	private static Connection connection;
	private static ResultSet rs; 
	
	@Override
	public boolean isValidatingUsername(String inputUsername) {
		String usernameQuery = "select username from logind where email=?";
		connection = DBConnection.getConnection();
		try {
			PreparedStatement pst = connection.prepareStatement(usernameQuery);
			pst.setString(1, inputUsername);
			rs = pst.executeQuery();
			if(rs.next() == false) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Error validating username " + e.getMessage());
		}
		return false;
	}

}
