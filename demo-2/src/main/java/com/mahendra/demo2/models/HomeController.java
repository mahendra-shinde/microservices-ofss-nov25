package com.mahendra.demo2.models;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/")
public class HomeController {
	@GetMapping(produces = { "application/json","application/xml" })
	public Message home() {
		return new Message("Hello World");
	}
	
	@GetMapping(produces="text/plain")
	public String home2() {
		return "Hello World";
	}
	
}
