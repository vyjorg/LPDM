package com.lpdm.msorder.controller;

import com.lpdm.msorder.entity.Store;
import com.lpdm.msorder.proxy.StoreProxy;
import feign.FeignException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stores")
public class StoreController {

    private final Logger log = LogManager.getLogger(this.getClass());

    private final StoreProxy storeProxy;

    @Autowired
    public StoreController(StoreProxy storeProxy) {
        this.storeProxy = storeProxy;
    }

    @RequestMapping("/{id}")
    public Store findStoreById(@PathVariable int id){

        Store store = null;

        try{ store = storeProxy.findById(id); }
        catch (FeignException e) { log.error(e.getMessage()); }

        return store;
    }
}