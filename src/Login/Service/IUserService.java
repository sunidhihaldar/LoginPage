package Login.Service;

import java.sql.ResultSet;

import Login.Model.User;

public interface IUserService {

	public int insertUser(User user);
	
	public ResultSet getUser(String username, String password);
	
}
