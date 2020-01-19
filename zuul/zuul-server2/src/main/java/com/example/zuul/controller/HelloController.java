package com.example.zuul.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @RequestMapping("/{name}")
    public String index(@PathVariable String name) {
        log.info("request name is {}", name);
        try {
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            log.info("sleep error", e);
        }
        return String.format("hello %s", name);
    }
}
