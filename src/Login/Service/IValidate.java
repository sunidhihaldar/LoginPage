package Login.Service;

/**
 * This functional interface provides an unimplemented method of validating username
 * @author Sunidhi Haldar
 * @created 2020-01-04
 * @version 1.8
 */

@FunctionalInterface
public interface IValidate {

	/**
	 * Unimplemented method of validating input username data with the data in the database
	 * @param username as String input parameter
	 * @return boolean value
	 */
	public boolean isValidatingUsername(String username);
	
}
