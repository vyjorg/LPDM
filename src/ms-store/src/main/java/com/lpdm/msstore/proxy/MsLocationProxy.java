package com.lpdm.msstore.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "ms-location", url = "localhost:28087")
public interface MsLocationProxy {

}
