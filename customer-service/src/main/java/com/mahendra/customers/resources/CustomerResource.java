package com.mahendra.customers.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mahendra.customers.models.Customer;

@RestController
@RequestMapping("/")
public class CustomerResource {

	@GetMapping(produces="application/json")
	//Request Path set to /find
	@RequestMapping("/find/{custId}")
	public Customer findCustomer(@PathVariable("custId") String custId) {
		Customer customer = new Customer();
		customer.setCustId(custId);
		customer.setFirstName("Rajiv");
		customer.setLastName("Bhatia");
		customer.setAddress("Bandra, Mumbai");
		return customer;
	}
}