package com.mahendra.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				
				// Original Request : localhost:8080/api/customer/find/1234
				// Re-write filter : localhost:7000/find/1234
				// Without Re-Write filter : localhost:7000/api/customer/find/1234
				.route("customer-service", r -> r.path("/api/customer/**")
						.filters(f -> f.rewritePath("/api/customer/(?<path>.*)", "/${path}"))
						.uri("lb://CUSTOMER-SERVICE/")
						)
				.route("loan-service", r-> r.path("/api/loan/**")
						.filters(f -> f.rewritePath("/api/loan/(?<path>.*)", "/${path}"))
						.uri("lb://LOAN-SERVICE/")
						)
				.route("account-service", r-> r.path("/api/account/**")
						.filters(f -> f.rewritePath("/api/account/(?<path>.*)", "/${path}"))
						.uri("lb://ACCOUNT-SERVICE/")
						)
				.build();
	}

}
