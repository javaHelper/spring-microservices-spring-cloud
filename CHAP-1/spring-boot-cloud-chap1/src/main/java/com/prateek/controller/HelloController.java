package com.prateek.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(value = "/greeting")
	public String SayHello() {
		return "Hi, from Spring Boot!";
	}
}
