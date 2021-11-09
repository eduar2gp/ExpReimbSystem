package revature.controller.endpoints;

import io.javalin.http.Context;
import revature.controller.dao.UsersDAOImpl;
import revature.controller.services.UsersService;
import revature.controller.services.UsersServiceImpl;
import revature.model.User;

public class UserController {

	static UsersService userService = new UsersServiceImpl(new UsersDAOImpl());

	public static void login(Context ctx) {
		String email = ctx.formParam("email");
		String password = ctx.formParam("password");

		if (email != null && password != null) {
			User user = userService.getUser(email, password);
			if (user != null) {				
				ctx.sessionAttribute("currentUser", user);				
				if (user.getUserRoleId() == 1)
					ctx.redirect("/html/employee.html");
				else
					ctx.redirect("/html/manager.html");
			}
			else {
				System.out.println("user null");
				ctx.redirect("/html/badlogin.html");
			}
		} else {
			ctx.redirect("/html/badlogin.html");
		}		
	}
	
	public static void logout(Context ctx) {			
		ctx.sessionAttribute("currentUser", null);	
		//ctx.result("{\"name\":\"pepe\"}");
		ctx.redirect("/html/badlogin.html");
		System.out.println("Login redirect");
	}
	
	public static void getUserInfo(Context ctx) {
		System.out.println("getUserInfo triggered");
		if(ctx.sessionAttribute("currentUser") != null) {
			System.out.println("currentUser != null");
			ctx.json(ctx.sessionAttribute("currentUser")).status(200);			
		}
		else {
			System.out.println("currentUser = null");
			System.out.println("bad login redirected");
			//ctx.redirect("/html/badlogin.html", 400);
			//ctx.redirect("/html/badlogin.html");
			ctx.redirect("/");
			System.out.println("getUserInfo redirect");
		}				
	}
}