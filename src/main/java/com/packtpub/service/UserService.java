package com.packtpub.service;

import com.packtpub.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(Integer userid);

    void createUser(Integer userid, String username);

    void updateUser(Integer userid, String username);

    void deleteUser(Integer userid);
}
