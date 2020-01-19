package com.example.zuul.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @RequestMapping("/{name}")
    public String index(@PathVariable("name") String name) {
        log.info(name);
        return String.format("hi %s", name);
    }
}
