package Login;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection connection = null;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginp", "root", "mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
	public static void closeConnection() {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
