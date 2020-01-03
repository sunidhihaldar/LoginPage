package Login.Database;

import java.sql.Connection;
import java.sql.DriverManager;

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
