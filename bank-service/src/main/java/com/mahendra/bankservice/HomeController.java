package com.mahendra.bankservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

	// ${dbhost} is SpringEL (Expression Language)
	@Value("${dbhost}")
	private String dbHost;
	
	@Value("${dbkind}")
	private String dbKind;
	
	@Value("${dbuser}")
	private String dbUser;
	
	@Value("${dbpass")
	private String dbPassword;
	
	@GetMapping(produces = "text/html")
	public String home() {
		return "Hello "+dbUser+", you are connected to "+dbKind+" at "+dbHost;
	}
}
