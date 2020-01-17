package com.example.hystrix.remote;

import com.example.hystrix.configuration.MyHystrixConfiguration;
import com.netflix.hystrix.config.HystrixConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${feign.name}", fallback = HystrixHandler.class, configuration = MyHystrixConfiguration.class)
public interface RemoteClient {

    @RequestMapping("/producer/hi")
    public String index(@RequestParam String name);
}
