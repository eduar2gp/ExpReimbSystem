package revature.controller.endpoints;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class FrontController {

	Javalin app;
	Dispatcher dispatcher;

	///////////// CONSTRUCTOR
	public FrontController(Javalin app) {
		this.app = app;

	    app.before("/api/*", FrontController::checkAllRequests);

		this.dispatcher = new Dispatcher(app);
	}

	/////////////// MIDDLEWARE LOGIC
	public static void checkAllRequests(Context context) {
		/*
		 * THIS is where you'd check to see if they are logged in, via checking their
		 * current session object and you'll see what role they are logged in as.
		 * 
		 * For example, employees shouldn't be able to trigger admin functionality just
		 * because they hardcoded the admin url into their browser.
		 * 
		 * You could ALSO check to see if they are using the correct http method and
		 * turn them away as well
		 */

		if (context.path().equals("/api/user/login")) {
			return;
		}
		
		if (context.path().equals("/api/user")) {
			return;
		}
		
		if (context.path().equals("/api/reimb/types")) {
			return;
		}
		
		if (context.path().equals("/api/reimb/status")) {
			return;
		}
		
		
		//System.out.println("checkpoint 1");

		/*if (context.header("authToken") == null) {
			throw new UnauthorizedResponse("Your headertoken is null. Hint: who's the number one hero?");
		} else if (!context.header("authToken").equalsIgnoreCase("Allmight")) {
			throw new UnauthorizedResponse("Do you not know who the number one hero is?");
		}*/
		
		if (context.header("authToken") == null) {
			context.redirect("/html/badlogin.html");			
		} 
		else {
			System.out.println("token " + context.header("authToken"));
		}

		// default responses can be found in the documentation:
		// https://javalin.io/documentation#default-responses

	}
}
