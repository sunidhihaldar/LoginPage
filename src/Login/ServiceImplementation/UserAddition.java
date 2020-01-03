package Login.ServiceImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Login.DBConnection;
import Login.Model.User;
import Login.Service.IUserService;

public class UserAddition implements IUserService {

	private static Connection connection;

	@SuppressWarnings("unused")
	@Override
	public int insertUser(User user) {
		int insertedNumber = 0;
		User fetchedUser = new User();
		String insertQuery = "insert into logind values (?,?,?,?,?,?,?,?,?,?)";

		try {
			connection = DBConnection.getConnection();
			PreparedStatement pst = connection.prepareStatement(insertQuery);
			pst.setString(1, fetchedUser.getFirstName());
			pst.setString(2, fetchedUser.getLastName());
			pst.setString(3, fetchedUser.getDob());
			pst.setString(4, fetchedUser.getGender());
			pst.setString(5, fetchedUser.getEmail());
			pst.setString(6, fetchedUser.getMobilenumber());
			pst.setString(7, fetchedUser.getAddress());
			pst.setString(8, fetchedUser.getCountry());
			pst.setString(9, fetchedUser.getUsername());
			pst.setString(10, fetchedUser.getPassword());

			insertedNumber = pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error inserting record to database " + e.getMessage());
		}

		return insertedNumber;
	}

	@Override
	public User getUser(String username, String password) {
		User user = null;
		try {
			connection = DBConnection.getConnection();
			String selectQuery = "Select * from logind where username = ? and password = ?";
			PreparedStatement pst = connection.prepareStatement(selectQuery);
			pst.setString(1, username);
			pst.setString(2, password);

			ResultSet resultSet = pst.executeQuery();
			if (resultSet.first()) {
				user = new User();
				while (resultSet.next()) {
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
