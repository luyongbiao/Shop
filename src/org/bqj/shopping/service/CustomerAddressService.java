package org.bqj.shopping.service;

import java.util.List;

import org.bqj.shopping.dao.CustomerAddressDAO;
import org.bqj.shopping.dao.impl.CustomerAddressDAOImpl;
import org.bqj.shopping.entity.CustomerAddress;

public class CustomerAddressService {
	private CustomerAddressDAO customerAddressDAO;
	
	public CustomerAddressService() {
		this.customerAddressDAO = new CustomerAddressDAOImpl();
	}
	
	public void saveOne(CustomerAddress customerAddress) {
		List<CustomerAddress> customerAddresses = this.customerAddressDAO.findByCustomerId(customerAddress.getCustomerId());
		
		if (customerAddresses == null || customerAddresses.size() == 0) {
			customerAddress.setAddressChecked(1);
			this.customerAddressDAO.save(customerAddress);
			return;
		}
		
		if (customerAddress.getAddressChecked() == 1)
			for (CustomerAddress ca : customerAddresses) {
				if (ca.getAddressChecked() == 1) {
					ca.setAddressChecked(0);
					this.customerAddressDAO.modify(ca);
				}
			}
		
		this.customerAddressDAO.save(customerAddress);
	}
	
	public List<CustomerAddress> findByCustoemrId(int customerId) {
		List<CustomerAddress> customerAddresses = this.customerAddressDAO.findByCustomerId(customerId);
		return customerAddresses;
	}

	public void update(CustomerAddress customerAddress) {
		List<CustomerAddress> customerAddresses = this.customerAddressDAO.findByCustomerId(customerAddress.getCustomerId());
		
		if (customerAddress.getAddressChecked() == 1)
			for (CustomerAddress ca : customerAddresses) {
				if (ca.getAddressChecked() == 1) {
					ca.setAddressChecked(0);
					this.customerAddressDAO.modify(ca);
				}
			}
		
		this.customerAddressDAO.modify(customerAddress);
		
	}
	
	public CustomerAddress findById(int customerAddressId) {
		return this.customerAddressDAO.loadById(customerAddressId);
	}

	public void delete(int customerAddressId) {
		this.customerAddressDAO.removeOne(customerAddressId);
	}
}
