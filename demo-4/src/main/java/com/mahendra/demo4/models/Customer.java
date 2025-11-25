package com.mahendra.demo4.models;

import jakarta.persistence.*;

@Entity
@Table(name="customers")

public class Customer {
	@Id
	private Integer custId;
	
	@Column(name="first_name", length = 20)
	private String firstName;
	
	@Column(name="last_name", length = 20)
	private String lastName;
	
	@Column(name="email", length = 30)
	private String email;
	
	public Customer(Integer custId, String firstName, String lastName, String email) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
