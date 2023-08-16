package com.lcwd.user.service.userservice.service;

import java.util.List;

import com.lcwd.user.service.userservice.enities.User;


public interface UserService {

    public User saveUser(User user);

    public List<User> getAllUser();

    public User getUser(String UserId);
    
}
