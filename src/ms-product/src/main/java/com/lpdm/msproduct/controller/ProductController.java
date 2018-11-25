package com.lpdm.msproduct.controller;

import com.lpdm.msproduct.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;
}
