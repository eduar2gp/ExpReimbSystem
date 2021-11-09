package revature.controller.services;

import java.util.List;
import revature.model.User;

public interface UsersService {

	public boolean addUser(User user);

	public List<User> getUsers();

	public User getUser(String username, String password);

}