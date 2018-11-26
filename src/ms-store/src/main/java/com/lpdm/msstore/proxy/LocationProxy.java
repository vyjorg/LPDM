package com.lpdm.msstore.proxy;

import com.lpdm.msstore.entity.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name = "ms-location", url = "localhost:28087")
public interface LocationProxy {

    @RequestMapping(value = "/addresses/{id}",
            method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Address findAddressById(@PathVariable(value = "id") int id);

}