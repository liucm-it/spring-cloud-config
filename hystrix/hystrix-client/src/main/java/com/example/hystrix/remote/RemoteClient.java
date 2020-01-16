package com.example.hystrix.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "hystrix-server", fallback = HystrixHandler.class)
public interface RemoteClient {

    @RequestMapping("/producer/hi")
    public String index(@RequestParam String name);
}
