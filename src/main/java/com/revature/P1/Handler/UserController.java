package com.revature.P1.Handler;

import com.revature.P1.Model.User;
import com.revature.P1.Service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

public class UserController {
    UserService userService;
    Javalin app;
    public UserController(Javalin app){
        userService = new UserService();
        this.app = app;
    }
    public void userEndpoint(){


        app.get("hello", this::helloHandler);
        app.post("user",this::postUserHandler);
        app.get("user", this::getAllUsersHandler);
        app.get("user/{name}",this::getSpecificUserHandler);

    }

    /**
     * use the javalin context to retrieve a String from the path.
     * use the customerService to retrieve a specific customer and return it as JSON.
     * @param context
     */
    private void getSpecificUserHandler(Context context) {
        String name = context.pathParam("name");
        User user = userService.getUser(name);
        context.json(user);
    }

    /**
     * use the javalin context to return a JSON representation of the list of all customers which
     * we have received from the CustomerService.
     * @param context
     */
    private void getAllUsersHandler(Context context) {
        List<User> allUsers = userService.getAllUsers();
//        similar as context.result, but the content type is json rather than text.
        context.json(allUsers);
    }

    /**
     * receive a JSON representation of a Customer in the body of an HTTP request.
     * that representation should be converted into a Java object and saved to the CustomerService.
     * @param context
     */
    private void postUserHandler(Context context) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(context.body(), User.class);
        userService.addUser(user);
        context.json(user);
    }

    /**
     * receives a JSON representation of a CartItem for a users order though the body of a HTTP request.
     * That representation should be converted into the Java object and saved into the orderList inside the CustomerService
     * @param context
     * @throws JsonProcessingException
     */


    public void helloHandler(Context ctx){
        ctx.result("hello world");
    }
}
