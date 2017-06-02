package org.bqj.shopping.dao;

import java.util.List;

import org.bqj.shopping.entity.CustomerAddress;

public interface CustomerAddressDAO extends BaseDAO<CustomerAddress> {
	List<CustomerAddress> findByCustomerId(int customerId);
}
