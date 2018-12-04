package com.lpdm.msuser.controllers;


import com.lpdm.msuser.msproduct.ProductBean;
import com.lpdm.msuser.proxies.MsProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    MsProductProxy msProductProxy;

    @GetMapping("/products")
    public List<ProductBean> productList(){
        List<ProductBean> products = msProductProxy.listProduct();
        return products;

    }
}
