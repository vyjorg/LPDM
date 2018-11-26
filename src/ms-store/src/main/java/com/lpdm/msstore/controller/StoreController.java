package com.lpdm.msstore.controller;

import com.lpdm.msstore.dao.StoreDao;
import com.lpdm.msstore.entity.Address;
import com.lpdm.msstore.entity.Store;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/stores")
public class StoreController {

    private final Logger log = LogManager.getLogger(StoreController.class);

    private final StoreDao storeDao;
    private final AddressController addressController;

    @Autowired
    public StoreController(StoreDao storeDao, AddressController addressController) {
        this.storeDao = storeDao;
        this.addressController = addressController;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Store getStoreById(@PathVariable int id){

        Optional<Store> optionalStore = storeDao.findById(id);

        if(optionalStore.isPresent()){
            Store store = optionalStore.get();
            Address address = addressController.findAddressById(store.getAddressId());
            store.setAddress(address);
            return store;
        }
        else return null;
    }

    @GetMapping("/")
    public String index(){

        return "Well done !";
    }
}