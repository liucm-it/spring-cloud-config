package com.example.feign.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("producer")
public interface RemoteClient {

    @RequestMapping("/producer/hi")
    public String index(@RequestParam String name);
}
