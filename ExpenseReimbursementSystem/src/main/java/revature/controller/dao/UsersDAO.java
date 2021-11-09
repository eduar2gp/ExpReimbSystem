package revature.controller.dao;

import java.util.List;
import revature.model.User;

public interface UsersDAO {
	
	public boolean insertUser(User user);	
	public List<User> selectUsers();	
	public User selectUser(String username, String password);
	
}
