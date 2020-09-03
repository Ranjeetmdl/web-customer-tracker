package com.luv2code.springdemo.services;

import java.util.List;

import com.luv2code.springdemo.entities.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

}
