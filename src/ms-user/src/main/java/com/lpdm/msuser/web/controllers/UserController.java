package com.lpdm.msuser.web.controllers;

import com.lpdm.msuser.beans.AppUser;
import com.lpdm.msuser.dao.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping("/Users")
    public List<AppUser> getAllUsers(){
        return appUserRepository.findAll();
    }

}
