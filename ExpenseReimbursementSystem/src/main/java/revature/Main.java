package revature;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import revature.controller.endpoints.FrontController;

public class Main {
	
	
	
	public static class Singleton {		
		
		private static Singleton singleton;
		String name = "Eduar";
		
		private Singleton() {			
		}				
		
		public static Singleton getSingleton() {
			if(singleton ==  null) {
				singleton = new Singleton();
			}
			return singleton;
		}		
	}
	

	public static void main(String[] args) {	
		
		/*Singleton s = Singleton.getSingleton();
		Singleton s1 = Singleton.getSingleton();
		System.out.println(s == s1);*/
		
		System.out.println(System.getenv("EMAIL_USERNAME"));
		System.out.println(System.getenv("EMAIL_PASSWORD"));
		
		
		/*Javalin app = Javalin.create(config -> {
			config.addStaticFiles(
					staticFiles -> {
						staticFiles.directory="/resources";
						staticFiles.hostedPath="/";
						staticFiles.location = Location.CLASSPATH;
			});
		}).start(9001);			
		
		new FrontController(app);	*/
	}
}