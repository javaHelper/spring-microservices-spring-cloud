package com.prateek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;


// Ref: https://stackoverflow.com/questions/48431547/how-to-enable-hystrix-stream-in-spring-boot-2-0
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
public class ReservationBusinessServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationBusinessServicesApplication.class, args);
	}
}
