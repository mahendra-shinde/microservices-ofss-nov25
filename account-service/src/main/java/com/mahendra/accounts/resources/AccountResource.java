package com.mahendra.accounts.resources;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mahendra.accounts.models.Account;
import com.mahendra.accounts.models.Customer;


@RestController
@RequestMapping("/")
public class AccountResource {

	@Autowired 
    private RestTemplate template;
	
	@GetMapping(produces = "application/json")
	@RequestMapping("/{accNo}")
	public Account find(@PathVariable("accNo") String accNo) {
		Account acc = new Account();
		acc.setAccountNo(accNo);
		acc.setOpeningDate(getDate("1/1/2012"));
		acc.setBalance(12300.00);
		// Expect "Eureka Server" to replace "customer-service" with "localhost:7000" 
		Customer cust = template.getForObject("http://customer-service/find/1234", Customer.class);
		acc.setCustomer(cust);
		return acc;
	}
	
	private Date getDate(String dateString) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		try {
			return df.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Date();
		}
	}
}