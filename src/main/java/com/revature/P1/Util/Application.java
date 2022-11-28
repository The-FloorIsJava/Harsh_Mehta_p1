package com.revature.P1.Util;

import com.revature.P1.Controller.ReimbursementController;
import com.revature.P1.Controller.UserController;

import io.javalin.Javalin;

public class Application {
    public static void main(String[] args) {

        Javalin app = Javalin.create().start(8080);

        new UserController(app).userEndpoint();
        new ReimbursementController(app).reimbursementEndpoint();
      //  MenuItemController menuItemController = new MenuItemController();

      //  menuItemController.menuItemEndpoint(app);
    }
}
