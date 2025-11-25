package com.mahendra.demo4.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mahendra.demo4.jpa.CustomerRepository;
import com.mahendra.demo4.models.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

	@Autowired private CustomerRepository dao;
	
	@GetMapping
	public ResponseEntity<Customer>  findCustomer(@RequestParam("cust_id") int custId) {
		Optional<Customer> cust = dao.findById(custId);
		if(cust.isPresent()) {
			return ResponseEntity.of(cust);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
