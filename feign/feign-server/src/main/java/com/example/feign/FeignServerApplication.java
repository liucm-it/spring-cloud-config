package com.example.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FeignServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignServerApplication.class, args);
	}

}
