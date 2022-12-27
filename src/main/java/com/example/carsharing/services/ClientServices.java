package com.example.carsharing.services;

import com.example.carsharing.models.User;
import com.example.carsharing.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ClientServices {
    private final UserRepositories userRepositories;

    @Autowired
    public ClientServices(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    public List<User> findAll(){
        return userRepositories.findAll();
    }

    public User findOne(int id) {
        return userRepositories.findById(id).orElse(null);
    }

    @Transactional
    public void save(User user) {
        userRepositories.save(user);
    }

    @Transactional
    public void update(int id, User user) {
        user.setId(id);
        userRepositories.save(user);
    }

    @Transactional
    public void delete(int id){
        userRepositories.deleteById(id);
    }
}
