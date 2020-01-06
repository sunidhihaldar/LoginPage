package Login.ServiceImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Login.Database.DBConnection;
import Login.Service.IValidate;

/**
 * This class implements the validation of the user input username before
 * storing the data to the database
 * 
 * @author Sunidhi Haldar
 * @created 2020-01-04
 * @version 1.8
 */

public class Validation implements IValidate {

	private static Connection connection;
	private static ResultSet rs;

	/**
	 * This method takes username as input parameter and validates the data with the
	 * data present in the database, if data is not present then return boolean
	 * value true
	 */

	@Override
	public boolean isValidatingUsername(String inputUsername) {
		String usernameQuery = "select username from logind where email=?";
		connection = DBConnection.getConnection();
		try {
			PreparedStatement pst = connection.prepareStatement(usernameQuery);
			pst.setString(1, inputUsername);
			rs = pst.executeQuery();
			if (rs.next() == false) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Error validating username " + e.getMessage());
		}
		return false;
	}

}
