package Login.ServiceImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Login.Database.DBConnection;
import Login.Model.User;
import Login.Service.IUserService;

public class UserAddition implements IUserService {

	private static Connection connection;

	@SuppressWarnings("unused")
	@Override
	public int insertUser(User user) {
		int insertedNumber = 0;
		String insertQuery = "insert into logind (fname,sname,dob,gender,email,contact,address,country,username,password) values (?,?,?,?,?,?,?,?,?,?)";
		//check point System.out.println("fetched name inside user addition" + user.getFirstName());
		
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

	@Override
	public User getUser(String username, String password) {
		User user = null;
		try {
			connection = DBConnection.getConnection();
			String selectQuery = "select * from logind where username = ? and password = ?";
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
