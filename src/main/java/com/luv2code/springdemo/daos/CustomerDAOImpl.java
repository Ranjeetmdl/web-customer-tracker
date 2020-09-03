package com.luv2code.springdemo.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entities.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	//inject the SessionFactory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		//get the current session
		Session session = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> theQuery = 
				session.createQuery("from Customer", Customer.class);
		
		//execute the query & get the list of customers
		List<Customer> customers = theQuery.getResultList();
		
		//returns the list
		return customers;
	}

}
