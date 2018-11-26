package com.lpdm.msorder.proxy;

import com.lpdm.msorder.entity.Store;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name = "ms-store", url = "localhost:28084")
public interface StoreProxy {

    @RequestMapping(value = "/stores/{id}",
            method = RequestMethod.GET, consumes = "application/json")
    Store findById(@PathVariable(value = "id") int id);
}