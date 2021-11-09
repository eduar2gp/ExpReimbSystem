package revature.controller.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import revature.controller.services.UsersService;
import revature.controller.services.UsersServiceImpl;
import revature.model.User;

public class UsersServiceImplTest {
	
	UsersService userService;
	
	@BeforeEach
	public void initializeService() {
		userService = new UsersServiceImpl(new UsersDAOImpl());
	}
	
	@Test
	public void testgetUser() {		
		User userTest = new User("eduar", "123", "Eduardo", "Gonzalez", "eduar@gmail.com", 1);	
		userTest.setUserId(6);
		User user = userService.getUser("eduar@gmail.com", "123");		
		assertEquals(userTest, user);			
	}
	
}