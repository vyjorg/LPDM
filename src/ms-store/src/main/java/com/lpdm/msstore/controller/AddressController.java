package com.lpdm.msstore.controller;

import com.lpdm.msstore.entity.Address;
import com.lpdm.msstore.proxy.LocationProxy;
import feign.FeignException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final Logger log = LogManager.getLogger(AddressController.class);

    private final LocationProxy locationProxy;

    @Autowired
    public AddressController(LocationProxy locationProxy) {
        this.locationProxy = locationProxy;
    }

    @GetMapping("/{id}")
    public Address findAddressById(@PathVariable int id){

        Address address = null;
        try{ address = locationProxy.findAddressById(id); }
        catch (FeignException e){ log.error(e.getMessage()); }
        return address;
    }
}