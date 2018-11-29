package com.lpdm.msproduct.controller;

import com.lpdm.msproduct.dao.ProductDao;
import com.lpdm.msproduct.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping(value = "/products")
    public List<Product> listProduct(){
        List<Product> list = productDao.findAll();

        return list;
    }

    @GetMapping(value="/products/{id}")
    public Product findProduct(@PathVariable int id){
        Product product = productDao.findById(id);

        return product;
    }
}
