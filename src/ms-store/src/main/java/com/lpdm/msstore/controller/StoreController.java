package com.lpdm.msstore.controller;

import com.lpdm.msstore.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class StoreController {

    @Autowired


    @GetMapping("/")
    public String index(){

        return "Well done !";
    }
}
