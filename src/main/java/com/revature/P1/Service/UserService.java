package com.revature.P1.Service;

import com.revature.P1.DAO.UserDAO;
import com.revature.P1.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {


    private User sessionUser = null;

    private UserDAO userDAO;

    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    public User addUser(User user){

        List<String> userNames = new ArrayList<>();
        boolean isUnique;


        if (userNames.contains(user.getUserName())){
            isUnique = false;
        } else {
            isUnique = true;
        }

        if (isUnique){
            return userDAO.create(user);
        } else {
            return null;
        }
    }

    public User getUser(User user){
        return null;
    }

    public void removeUser( String userName){

    }



    public void login(String userName, String password){
        //implement with dao
        this.sessionUser = userDAO.loginCheck(userName, password);
    }



    public void logout(){
        this.sessionUser = null;
    }

    public User getSessionUser(){
        return this.sessionUser;
    }
}