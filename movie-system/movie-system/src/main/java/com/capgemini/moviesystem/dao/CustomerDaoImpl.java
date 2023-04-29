package com.capgemini.moviesystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.capgemini.moviesystem.model.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Customer addCustomer(Customer cust) {
		entityManager.persist(cust);
		return cust;
	}

	@Override
	public Customer getCustomer(String username) {
		return entityManager.find(Customer.class, username);
	}

}

