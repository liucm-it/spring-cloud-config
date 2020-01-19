package com.example.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZuulServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServer1Application.class, args);
	}

}
