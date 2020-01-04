package com.prateek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringBootCloudChap2ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCloudChap2ConfigServerApplication.class, args);
	}
}
