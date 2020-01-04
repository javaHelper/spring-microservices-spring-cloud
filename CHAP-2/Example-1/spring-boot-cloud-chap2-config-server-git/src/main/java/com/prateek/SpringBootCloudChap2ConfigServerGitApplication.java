package com.prateek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableAutoConfiguration
public class SpringBootCloudChap2ConfigServerGitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCloudChap2ConfigServerGitApplication.class, args);
	}
}
