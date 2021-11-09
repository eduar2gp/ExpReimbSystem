package revature.controller.services;

import java.util.List;

import revature.controller.dao.UsersDAO;
import revature.model.User;

public class UsersServiceImpl implements UsersService{
	
	UsersDAO userDAO;
	
	public UsersServiceImpl(UsersDAO userDAO) {
		this.userDAO = userDAO;		
	}

	@Override
	public boolean addUser(User user) {
		return userDAO.insertUser(user);
	}

	@Override
	public List<User> getUsers() {
		return userDAO.selectUsers();
	}

	@Override
	public User getUser(String username, String password) {		
		return userDAO.selectUser(username, password);
	}

}
