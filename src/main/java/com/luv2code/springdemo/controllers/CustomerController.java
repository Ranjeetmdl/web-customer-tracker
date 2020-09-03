package com.luv2code.springdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.daos.CustomerDAO;
import com.luv2code.springdemo.entities.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	//inject customer dao
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping("/list")
	public String listCustomers(Model theModel){
		
		//get the list of customers from the customerDAO
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		//add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}

}
