package com.lpdm.msorder.proxy;

import com.lpdm.msorder.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name = "ms-user", url = "localhost:28082")
public interface MsUserProxy {

    @RequestMapping(value = "/user/{id}",
            method = RequestMethod.GET, consumes = "application/json")
    User findById(@PathVariable(value = "id") int id);
}
