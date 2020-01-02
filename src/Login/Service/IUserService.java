package Login.Service;

import Login.Model.User;

public interface IUserService {

	public int insertUser(User user);
	
	public User getUser(String username, String password);
	
}
