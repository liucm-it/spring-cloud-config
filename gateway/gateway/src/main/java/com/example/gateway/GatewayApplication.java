package com.example.gateway;

import com.example.gateway.filter.MyGatewayFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class GatewayApplication {

	@Value("${test.uri:https://www.baidu.com:80}")
	String uri;

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r ->
						r.path("/about")
						.filters(f -> f.prefixPath("/**")
								.filter(new MyGatewayFilter()))
						.uri(uri)
				).build();
	}

//	@Bean
//	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route("path_route", r -> r.path("/about")
//						.uri("http://ityouknow.com"))
//				.build();
//	}
}
