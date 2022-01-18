package com.training.libraryservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@Slf4j
public class LibraryServiceApplication {

	public static void main(String[] args) {
		log.info("Library-Service Execution has begun.");
		SpringApplication.run(LibraryServiceApplication.class, args);
	}

}
