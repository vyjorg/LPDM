package com.lpdm.msorder.controller;

import com.lpdm.msorder.entity.Product;
import com.lpdm.msorder.proxy.MsProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class OrderController {

    @Autowired
    MsProductProxy msProductProxy;

    @RequestMapping("/products/{id}")
    public Product findById(@PathVariable int id){
        return msProductProxy.findById(id);
    }
}
