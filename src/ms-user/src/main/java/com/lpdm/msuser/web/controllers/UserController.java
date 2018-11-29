package com.lpdm.msuser.web.controllers;

import com.lpdm.msuser.beans.AppUser;
import com.lpdm.msuser.dao.AppUserRepository;
import com.lpdm.msuser.web.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping("/users")
    public List<AppUser> getAllUsers(){
        return appUserRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<AppUser> getUserById(@PathVariable int id){

        Optional <AppUser> appUser = appUserRepository.findById(id);
        if(!appUser.isPresent())
            throw new UserNotFoundException("Could not find any user matching this id " + id);

        return appUser;
    }

    @PostMapping("/users")
    public void addUser(AppUser user){
        appUserRepository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        appUserRepository.deleteById(id);
    }
}
