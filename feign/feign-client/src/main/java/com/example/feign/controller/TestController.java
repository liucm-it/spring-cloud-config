package com.example.feign.controller;

import com.example.feign.remote.RemoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RemoteClient remoteClient;

    @RequestMapping("/{name}")
    public String index(@PathVariable("name") String name) {
        return remoteClient.index(name);
    }
}
