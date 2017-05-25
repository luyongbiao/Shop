package org.bqj.shopping.service;

import java.util.List;

import org.bqj.shopping.dao.CustomerDAO;
import org.bqj.shopping.dao.impl.CustomerDAOImpl;
import org.bqj.shopping.entity.Customer;

public class CustomerService {
	private CustomerDAO custoemrDAO;
	
	public CustomerService() {
		this.custoemrDAO = new CustomerDAOImpl();
	}
	
	public Customer login(Customer customer) {
		List<Customer> customers = this.custoemrDAO.findAll();
		for (Customer c : customers) {
			if (c.getCustomerName().equals(customer.getCustomerName())
					&& c.getCustomerPassword().equals(customer.getCustomerPassword())) {
				return c;
			}
		}
		return null;
	}
	
}
