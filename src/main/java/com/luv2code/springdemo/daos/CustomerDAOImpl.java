package com.luv2code.springdemo.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
				session.createQuery("from Customer order by lastName", Customer.class);
		
		//execute the query & get the list of customers
		List<Customer> customers = theQuery.getResultList();
		
		//returns the list
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get the current session
		Session session = sessionFactory.getCurrentSession();
		
		//save/update the customer....finally LOL
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get/retrieve the customer from database based on the id/primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

}
