package src.main.java.com.revature.P1.Service;

import src.main.java.com.revature.P1.Model.User;

import java.util.ArrayList;
import java.util.List;

public class Login {
    List<User> userList;



    public Login(){
        userList = new ArrayList<>();

    }

    public void addUser(String userName, String password, String position){
        User newUser = new User(userName, password, position);
        userList.add(newUser);
    }
//    overloaded method (method with the same name but different parameters)
    public void addUser(User user){
        userList.add(user);
    }

    public User getUserN(String userName){
        for(int i = 0; i < userList.size(); i++){
            User c = userList.get(i);
            if(c.getUserName().equals(userName)){
                return userList.get(i);
            }
        }
        return null;
    }

    public void removeUser(String userName){
        for(int i = 0; i < userList.size(); i++){
            User c = userList.get(i);
            if(c.getUserName().equals(userName)){
                userList.remove(i);
            }
        }
    }

    public String ExistingUser(String userName) {
        for(int i = 0; i < userList.size(); i++) {
            User u = userList.get(i);
            if (u.getUserN().equals(userName)) {
                return "Existing User";
            }
        }
        return userName;
    }

    public User getP(String password){
        for(int i = 0; i < userList.size(); i++){
            User c = userList.get(i);
            if(c.getPassword().equals(password)){
                return userList.get(i);
            }
        }
        return null;
    }

    public void removeP(String password){
        for(int i = 0; i < userList.size(); i++){
            User c = userList.get(i);
            if(c.getPassword().equals(password)){
                userList.remove(i);
            }
        }
    }
    public List<User> getAllUsers() {
        return userList;
    }



}
