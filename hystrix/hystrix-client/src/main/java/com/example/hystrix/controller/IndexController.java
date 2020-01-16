package com.example.hystrix.controller;

import com.example.hystrix.remote.RemoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private RemoteClient remoteClient;

    @RequestMapping("/{text}")
    public String index(@PathVariable String text) {
        return remoteClient.index(text);
    }
}
