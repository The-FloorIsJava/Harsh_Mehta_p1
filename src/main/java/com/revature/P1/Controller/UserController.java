package com.revature.P1.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.P1.DAO.UserDAO;
import com.revature.P1.Model.User;
import com.revature.P1.Service.UserService;
import com.revature.P1.Util.DTO.LoginCreds;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

public class UserController {

    UserService userService;
    Javalin app;
    public UserController(UserService userService){
        this.userService = userService;
    }

    public UserController(Javalin app, UserService userService) {
        this.userService = userService;
        this.app = app;
    }



    public void userEndpoint(){
        app.get("hello", this::helloHandler);
        app.post("register", this::postUserHandler);
        app.post("login", this::loginHandler);
        app.delete("logout", this::logoutHandler);
        app.get("allUsers", this::getAllUserHandler);
    }
    private void helloHandler(Context context) {

        context.result("Welcome to the Galaxy!");
    }
    private void postUserHandler(Context context) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(context.body(), User.class);
        user = userService.addUser(user);
        if (user == null) {
            context.json("Your User Name is already registered.");
        }else {
            context.json(user);
        }
    }
    private void loginHandler(Context context) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        LoginCreds loginCreds = mapper.readValue(context.body(), LoginCreds.class);
        userService.login(loginCreds.getUserName(), loginCreds.getPassword());
        context.json("Successfully logged in!");
    }
    private void logoutHandler(Context context) {
        String userName = userService.getSessionUser().getUserName();
        userService.logout();
        context.json(userName + " has now logged out");
    }
    private void getAllUserHandler(Context context) {
        List<User> allUsers = userService.getAllUsers();
        context.json(allUsers);
    }


}
