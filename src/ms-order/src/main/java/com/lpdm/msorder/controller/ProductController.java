package com.lpdm.msorder.controller;

import com.lpdm.msorder.entity.Product;
import com.lpdm.msorder.proxy.ProductProxy;
import feign.FeignException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final Logger log = LogManager.getLogger(this.getClass());

    private final ProductProxy productProxy;

    @Autowired
    public ProductController(ProductProxy productProxy) {
        this.productProxy = productProxy;
    }

    @RequestMapping("/{id}")
    public Product findProductById(@PathVariable int id){

        Product product = null;

        try { product = productProxy.findById(id); }
        catch (FeignException e) { log.error(e.getMessage()); }

        return product;
    }
}
