package src.main.java.com.revature.P1.Handler;

import com.revature.P1.Model.User;
import com.revature.P1.Model.ReimbursementTicket;
import com.revature.P1.Service.Login;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;
import src.main.java.com.revature.P1.Model.User;
import src.main.java.com.revature.P1.Service.Login;

import java.util.List;

public class UserController {
    Login login;
    Javalin app;
    public UserController(Javalin app){
        login = new Login();
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
        User user = login.getUser(name);
        context.json(user);
    }

    /**
     * use the javalin context to return a JSON representation of the list of all customers which
     * we have received from the CustomerService.
     * @param context
     */
    private void getAllUsersHandler(Context context) {
        List<User> allUsers = login.getAllUsers();
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
        login.addUser(user);
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
