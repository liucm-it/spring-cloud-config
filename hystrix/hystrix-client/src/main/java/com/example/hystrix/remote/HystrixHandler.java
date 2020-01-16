package com.example.hystrix.remote;

import org.springframework.stereotype.Component;

@Component
public class HystrixHandler implements RemoteClient {

    @Override
    public String index(String name) {
        return "活动太火爆了，请稍后再试！！！";
    }
}
