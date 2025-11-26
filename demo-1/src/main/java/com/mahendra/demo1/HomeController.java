package com.mahendra.demo1;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClient;

@RequestMapping("/")
@Controller
public class HomeController {
	
	private final DiscoveryClient client;
	private final RestClient rest;
	
	public HomeController(DiscoveryClient client, RestClient.Builder restBuilder) {
		this.client = client;
		this.rest = restBuilder.build();
	}

	@GetMapping
	public String home(Model model) {
		ServiceInstance instance = client.getInstances("demo-2").get(0);
		System.out.println("Request sent to : "+instance.getUri());
		String resp = rest.get().uri(instance.getUri()).retrieve().body(String.class);
		System.out.println(resp);
		model.addAttribute("mess",resp);
		return "index"; 
	}
}
