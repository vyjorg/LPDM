package com.lpdm.msstore.proxy;

import com.lpdm.msstore.entity.Location;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name = "ms-${microservice.location.name}",
        url = "${microservice.domain}"+":"+"${microservice.location.port}")
public interface LocationProxy {

    @RequestMapping(value = "/locations/{id}",
            method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Location findLocationById(@PathVariable(value = "id") int id);

}