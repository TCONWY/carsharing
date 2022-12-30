package com.example.carsharing.services;

import com.example.carsharing.models.User;
import com.example.carsharing.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class RegistrationService {
    private final UserRepository userRepository;


    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void register(User user) {
        userRepository.save(user);
    }
}
