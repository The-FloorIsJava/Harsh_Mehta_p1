package com.revature.P1.Util.Interface;

import com.revature.P1.Model.User;

import java.util.List;

public interface Crudable<T> {

    // insert
    T create(T newObject);

    // Read
    List<T> findAll();
    T findByUserName(String userName);

    // Update
    boolean update(T updatedObject);

    // Delete
    boolean delete(String userName);
}
