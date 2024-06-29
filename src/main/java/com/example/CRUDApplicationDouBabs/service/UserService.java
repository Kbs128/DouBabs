package com.example.CRUDApplicationDouBabs.service;

import com.example.CRUDApplicationDouBabs.dto.UserDTO;
import com.example.CRUDApplicationDouBabs.entity.User;

import java.util.List;

public interface UserService  {
    void addUser(User user);

    List<User> getUsers();

    User getUser(Integer id);

    void updateUser(Integer id, User user);

    void deleteUser(Integer id);

    void updateName(Integer id, UserDTO userDTO);
}
