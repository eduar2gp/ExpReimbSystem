package revature.controller.endpoints;

import java.io.IOException;
import org.json.JSONObject;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.UploadedFile;
import revature.controller.dao.ReimbursementDAOImpl;
import revature.controller.services.ReimbursementService;
import revature.controller.services.ReimbursementServiceImpl;
import revature.model.Reimbursement;
import revature.model.User;

public class ReimbController {

	static ReimbursementService reimbService = new ReimbursementServiceImpl(new ReimbursementDAOImpl());

	public static void getReimbByUserId(Context ctx) {		
		ctx.json(reimbService.getReimbUnresolved(String.valueOf(new JSONObject(ctx.body()).getInt("userId"))));
	}

	public static Handler getAllReimb() {
		// this is a lambda interface implementation
		return (ctx) -> {
			// ctx.json(reimbService.getReimbursement(null));
			ctx.json(reimbService.getReimbUnresolved(null));
		};
	}

	public static void getReimbTypes(Context ctx) {
		ctx.json(reimbService.getReimbTypes());
	}

	public static void getReimbStatus(Context ctx) {
		ctx.json(reimbService.getReimbStatus());
	}
	

	public static void updateReimb(Context ctx) {
		Reimbursement reimb = ctx.bodyAsClass(Reimbursement.class);
		reimb.setReimbResolverId(((User) ctx.sessionAttribute("currentUser")).getUserId());		
		int success = reimbService.updateReimb(reimb);
		if (success > 0) {
			ctx.result("Ok").status(200);
		} else {
			ctx.result("fail").status(400);
		}
	}
	

	public static void addReimb(Context ctx) {
		System.out.println(ctx.formParam("jsonData"));
		
		UploadedFile file = ctx.uploadedFile("image");

		byte[] array = null;

		if (file != null) {
			try {
				array = file.getContent().readAllBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	

		boolean result = reimbService.addReimbursement(new JSONObject(ctx.formParam("jsonData").toString()), array);
		if (result) {
			ctx.result(new JSONObject().put("status", "ok").toString()).status(200);
		} else {
			ctx.result(new JSONObject().put("status", "fail").toString()).status(400);
		}
	}
}