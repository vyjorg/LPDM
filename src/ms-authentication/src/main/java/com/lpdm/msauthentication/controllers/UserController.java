package com.lpdm.msauthentication.controllers;

import com.lpdm.msauthentication.beans.msuser.AppUserBean;
import com.lpdm.msauthentication.proxies.MsUserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private MsUserProxy msUserProxy;

    @GetMapping("/users")
    public String allUsers(Model model){
        List<AppUserBean> appUsers = msUserProxy.getAllUsers();
        model.addAttribute("users", appUsers);
        return "users";
    }
}
