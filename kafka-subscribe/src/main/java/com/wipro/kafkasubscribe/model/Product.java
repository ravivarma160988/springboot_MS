package com.wipro.kafkasubscribe.model;

import java.io.Serializable;

public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -273085578177432712L;
	private int id;
	private String name;
	private String[] address;
	
	
	public Product() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String[] getAddress() {
		return address;
	}


	public void setAddress(String[] address) {
		this.address = address;
	}


	public Product(int id, String name, String[] address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	

}
