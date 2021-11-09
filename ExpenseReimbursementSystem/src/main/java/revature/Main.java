package revature;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import revature.controller.endpoints.FrontController;

public class Main {	

	public static void main(String[] args) {				
		
		Javalin app = Javalin.create(config -> {
			config.addStaticFiles(
					staticFiles -> {
						staticFiles.directory="/resources";
						staticFiles.hostedPath="/";
						staticFiles.location = Location.CLASSPATH;
			});
		}).start(9001);			
		
		new FrontController(app);
	}
}