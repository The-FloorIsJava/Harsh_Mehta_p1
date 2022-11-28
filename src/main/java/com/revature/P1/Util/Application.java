package com.revature.P1.Util;

import com.revature.P1.Controller.ReimbursementController;
import com.revature.P1.Controller.UserController;

import com.revature.P1.DAO.UserDAO;
import com.revature.P1.Service.UserService;
import io.javalin.Javalin;

public class Application {
    public static void main(String[] args) {

        UserService userService = new UserService(new UserDAO());


        Javalin app = Javalin.create().start(8081);



        new UserController(app, userService).userEndpoint();
        new ReimbursementController(app, userService).reimbursementEndpoint();
      //  MenuItemController menuItemController = new MenuItemController();

      //  menuItemController.menuItemEndpoint(app);
    }
}
