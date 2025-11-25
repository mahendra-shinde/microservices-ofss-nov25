package com.mahendra.demo2.models;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message implements Serializable{
	private String message;
	
	public Message() {
		this("Empty Message");
	}
	
	public Message(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
