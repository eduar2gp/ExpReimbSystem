package revature.controller.endpoints;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*; //this is where "path" came from


public class Dispatcher {

	
	public Dispatcher(Javalin app) {
		setupAllPaths(app);
	}

	public static void setupAllPaths(Javalin app) {
		setupUserControllerPaths(app);
		setupReimbControllerPaths(app);	
	}

	public static void setupUserControllerPaths(Javalin app) {
		app.routes(()->{				
			path("/api/user/login", () -> {
				post(UserController::login);				
			});			
			path("/api/user/logout", () -> {
				post(UserController::logout);				
			});			
			path("/api/user", () -> {
				get(UserController::getUserInfo);				
			});				
		});
	}

	public static void setupReimbControllerPaths(Javalin app) {		
		app.routes(()->{
			path("/api/reimb/types", () -> {
				get(ReimbController::getReimbTypes);				
			});			
			path("/api/reimb/status", () -> {
				get(ReimbController::getReimbStatus);				
			});			
			path("/api/reimbursement/add", () -> {
				post(ReimbController::addReimb);				
			});			
			path("/api/reimbursement", () -> {				
				post(ReimbController::getReimbByUserId);
				get(ReimbController.getAllReimb());	
				put(ReimbController::updateReimb);				
			});				
		});
	}
}
