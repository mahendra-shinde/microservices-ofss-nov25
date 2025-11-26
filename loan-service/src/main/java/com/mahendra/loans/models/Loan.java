package com.mahendra.loans.models;

public class Loan {

	private String accountNo;
	private Double amountDisbursed;
	private Double emi;
	private Double roi;
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public Double getAmountDisbursed() {
		return amountDisbursed;
	}
	public void setAmountDisbursed(Double amountDisbursed) {
		this.amountDisbursed = amountDisbursed;
	}
	public Double getEmi() {
		return emi;
	}
	public void setEmi(Double emi) {
		this.emi = emi;
	}
	public Double getRoi() {
		return roi;
	}
	public void setRoi(Double roi) {
		this.roi = roi;
	}
	
	
}