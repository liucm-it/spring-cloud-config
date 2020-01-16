package com.example.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/hello")
@RestController
public class HelloController {

    @Value("${hello.name}")
    private String helloName;

    @Value("${hello.age}")
    private String helloAge;

    @GetMapping("/")
    public Map<String, String> hello() {
        Map map = new HashMap<String, String>();
        map.put(helloName, helloAge);
        return map;
    }
}
