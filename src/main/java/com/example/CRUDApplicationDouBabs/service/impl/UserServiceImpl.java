package com.example.CRUDApplicationDouBabs.service.impl;

import com.example.CRUDApplicationDouBabs.dto.UserDTO;
import com.example.CRUDApplicationDouBabs.entity.User;
import com.example.CRUDApplicationDouBabs.repository.UserRepository;
import com.example.CRUDApplicationDouBabs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
     userRepository.save(user);

    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "l'id de l'utilisateur est invalide" +id));
        return user;
    }

    @Override
    public void updateUser(Integer id, User user) {
        userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "l'id de l'utilisateur est invalide" +id));

        user.setId(id);

        userRepository.save(user);

    }

    @Override
    public void deleteUser(Integer id) {
    User user =  userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "l'id de l'utilisateur est invalide" +id));

    userRepository.delete(user);

    }

    @Override
    public void updateName(Integer id, UserDTO userDTO) {
        User user =  userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "l'id de l'utilisateur est invalide" +id));

        user.setName(userDTO.getName());

        userRepository.save(user);
    }

}
