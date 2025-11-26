package com.mahendra.loans.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahendra.loans.models.Loan;


@RestController
@RequestMapping("/")
public class LoanResource {

	@RequestMapping("/find/{accNo}")
	@GetMapping(produces="application/json")
	public Loan find(@PathVariable("accNo") String accNo) {
		Loan loan = new Loan();
		loan.setAccountNo(accNo);
		loan.setAmountDisbursed(120000D);
		loan.setRoi(9.5);
		loan.setEmi(13000D);
		return loan;
	}
}