package Login.Database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This class provides database connection of the type singleton design pattern
 * @author Sunidhi Haldar
 * @created 2019-12-27
 * @version 1.8
 */

public class DBConnection {

	public static Connection connection = null;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "mysql");
			// check point
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
