package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {
	@Value("${greeter.message}")
	private String greeterMessageFormat;

	@GetMapping("/hello")
	public String hello()
	{
		String prefix = System.getenv().getOrDefault("GREETING_PREFIX", "Hi");

		return "Hello"+ prefix+">>"+greeterMessageFormat;
	}


}
