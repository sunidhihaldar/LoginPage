package Login.ServiceImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Login.DBConnection;
import Login.Model.User;
import Login.Service.IUserService;

public class UserAddition implements IUserService {

	private static Connection connection;
	private static PreparedStatement pst;
	
	@SuppressWarnings("unused")
	@Override
	public int insertUser(User user) {
		int insertedNumber = 0;
		String insertQuery = "insert into logindetails values (?,?,?,?,?,?,?,?,?,?)";
		return insertedNumber;
	}

	@Override
	public User getUser(String username, String password) {
		User user = null;
		try {
			connection = DBConnection.getConnection();
			String selectQuery = "Select * from logindetails where username = ? and password = ?";
			pst = connection.prepareStatement(selectQuery);
			pst.setString(1, username);
			pst.setString(2, password);
			
			ResultSet resultSet = pst.executeQuery();
			if(resultSet.first()) {
				user = new User();
				while(resultSet.next()) {
					user.setFirstName(resultSet.getString(1));
					user.setLastName(resultSet.getString(2));
					user.setEmail(resultSet.getString(3));
					user.setDob(resultSet.getString(4));
					user.setMobilenumber(resultSet.getString(5));
					user.setGender(resultSet.getString(6));
					user.setAddress(resultSet.getString(7));
					user.setCountry(resultSet.getString(8));
					user.setUsername(resultSet.getString(9));
					user.setPassword(resultSet.getString(10));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
}
