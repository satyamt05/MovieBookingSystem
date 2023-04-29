package com.capgemini.moviesystem.dao;

import com.capgemini.moviesystem.model.Customer;

public interface ICustomerDao {

	public Customer addCustomer(Customer cust);

	public Customer getCustomer(String username);

}
