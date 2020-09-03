package com.luv2code.springdemo.daos;

import java.util.List;

import com.luv2code.springdemo.entities.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

}
