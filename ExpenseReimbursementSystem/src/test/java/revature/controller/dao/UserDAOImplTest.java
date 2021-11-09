package revature.controller.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import revature.model.User;


public class UserDAOImplTest {
	
	UsersDAO userDAO;
	
	@BeforeEach
	public void initializeUsersDAO() {
		userDAO = new UsersDAOImpl();		
	}
	
	@Test
	void selectUserTest() {		
		User userTest = new User("eduar", "123", "Eduardo", "Gonzalez", "eduar@gmail.com", 1);	
		userTest.setUserId(6);
		User user = userDAO.selectUser("eduar@gmail.com", "123");		
		assertEquals(userTest, user);		
	}
}