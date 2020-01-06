package Login.Service;

import java.sql.ResultSet;

import Login.Model.User;

/**
 * This interface provides unimplemented methods of inserting details of an user and returning the details of a particular user
 * @author Sunidhi Haldar
 * @created 2020-01-03
 * @version 1.8
 */

public interface IUserService {

	/**
	 * Provides an unimplemented method for inserting the user details of an user and after successful insertion of data returns the number of
	 * affected rows 
	 * @param user as Class object input parameter
	 * @return int value
	 */
	
	public int insertUser(User user);
	
	/**
	 * Provides an unimplemented method for checking the user details entered by the user with the data present in the database
	 * @param username as input parameter
	 * @param password as input parameter
	 * @return ResultSet
	 */
	
	public ResultSet getUser(String username, String password);
	
}
