package com.lpdm.msorder.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class CloudConfigController {

    @Value("${msorder.fullname:Un nom lambda}")
    private String fullName;

    @Value("${spring.application.name:un nom lambda}")
    private String appName;

    @ResponseBody
    @RequestMapping("/showInfos")
    public String showInfos(){

        return "Microservice : " + fullName + "\n" + "aplication : " + appName;
    }
}
