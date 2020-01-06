package Login.ServiceImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Login.Database.DBConnection;
import Login.Model.User;
import Login.Service.IUserService;

/**
 * This class provides the functionalities of inserting user data into the
 * database and fetching the data of the user from the database
 * 
 * @author Sunidhi Haldar
 * @created 2020-01-03
 * @version 1.8
 */

public class UserAddition implements IUserService {

	private static Connection connection;

	/**
	 * This method takes Class object user as input parameter and inserts user data
	 * into the database for a particular user and after insertion of data, returns
	 * the number of rows affected
	 */

	@Override
	public int insertUser(User user) {
		int insertedNumber = 0;
		String insertQuery = "insert into logind (fname,sname,dob,gender,email,contact,address,country,username,password) values (?,?,?,?,?,?,?,?,?,?)";
		// check point System.out.println("fetched name inside user addition" +
		// user.getFirstName());

		try {
			connection = DBConnection.getConnection();
			PreparedStatement pst = connection.prepareStatement(insertQuery);
			pst.setString(1, user.getFirstName());
			pst.setString(2, user.getLastName());
			pst.setString(3, user.getDob());
			pst.setString(4, user.getGender());
			pst.setString(5, user.getEmail());
			pst.setString(6, user.getMobilenumber());
			pst.setString(7, user.getAddress());
			pst.setString(8, user.getCountry());
			pst.setString(9, user.getUsername());
			pst.setString(10, user.getPassword());

			insertedNumber = pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error inserting record to database " + e.getMessage());
		}

		return insertedNumber;
	}

	/**
	 * This class takes username and password of the user as input parameters and
	 * checks if it matches with the existing records in the database and finally
	 * returns the result set
	 */

	@Override
	public ResultSet getUser(String username, String password) {
		ResultSet rs = null;
		try {
			connection = DBConnection.getConnection();
			String selectQuery = "select * from logind where username = ? and password = ?";
			PreparedStatement pst = connection.prepareStatement(selectQuery);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
//			ResultSet resultSet = pst.executeQuery();
//			if (resultSet.first()) {
//				user = new User();
//				while (resultSet.next()) {
//					user.setFirstName(resultSet.getString(1));
//					user.setLastName(resultSet.getString(2));
//					user.setEmail(resultSet.getString(3));
//					user.setDob(resultSet.getString(4));
//					user.setMobilenumber(resultSet.getString(5));
//					user.setGender(resultSet.getString(6));
//					user.setAddress(resultSet.getString(7));
//					user.setCountry(resultSet.getString(8));
//					user.setUsername(resultSet.getString(9));
//					user.setPassword(resultSet.getString(10));
//				}
//			}
		} catch (Exception e) {
			System.out.println("Error fetching data " + e.getMessage());
		}
		return rs;
	}

}
