package com.iiht.hellogateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfiguration {
	
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return
				builder.routes().route(
						"helloserver",
						r->r.path("/rest/service/**").
						uri("http://localhost:8071"))
				.build();
	}
	
//	@Bean
//	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//		return
//				builder.routes().route(
//						"hellosserver",
//						r->r.path("/rest/service/**").
//						uri("http://localhost:8071"))
//				.build();
//	}

}
