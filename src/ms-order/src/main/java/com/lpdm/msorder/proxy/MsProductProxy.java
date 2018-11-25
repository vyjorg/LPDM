package com.lpdm.msorder.proxy;

import com.lpdm.msorder.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@FeignClient(name = "ms-product", url="localhost:28085")
public interface MsProductProxy {

    @RequestMapping(value = "/products",
            method = RequestMethod.GET, consumes = "application/json")
    List<Product> findAll();

    @RequestMapping(path = "/products/{id}",
            method = RequestMethod.GET, consumes = "application/json")
    Product findById(@PathVariable(value = "id") int id);

}
