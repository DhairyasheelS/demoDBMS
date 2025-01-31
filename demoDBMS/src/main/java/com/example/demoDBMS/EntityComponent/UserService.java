package com.example.demoDBMS.EntityComponent;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //create or update User
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    //Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Get a user by id
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    //Get a user by email
    public Optional<User> getUserByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

    //Delete User
    public void deleteUser(Long id)
    {
        userRepository.deleteById(id);
    }
}
