package com.pte.progmodii.service;

import com.pte.progmodii.model.User;
import com.pte.progmodii.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    //<<-------CREATE------->>
    @Transactional
    public User createUser(User newUser){
        repository.save(newUser);
        return checkUser(newUser.getId()).orElseThrow();
    }


    //<<-------READ------->>
    public User readUser(User newUser){
        User user = repository.findByName(newUser.getName());
        return user;
    }



    //<<-------DELETE------->>
    @Transactional
    public boolean deleteUser(User deleteUser){
        repository.delete(deleteUser);
        return true;
    }


    //<<-------CHECK------->>
    public Optional<User> checkUser(Integer id) {
        return repository.findById(id);
    }


    //<<-------UPDATE------->>
    @Transactional
    public User updateUser(User updatedUser){
        User user = repository.save(updatedUser);
        return readUser(user);
    }



}
