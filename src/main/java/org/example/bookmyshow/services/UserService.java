package org.example.bookmyshow.services;

import org.example.bookmyshow.exceptions.UserNotFoundException;
import org.example.bookmyshow.models.User;

public interface UserService {


    public User signUp(String name, String email,String password,String userType);

    boolean loginUser(String email, String password);

    User getUserById(long userId) throws UserNotFoundException;
}
