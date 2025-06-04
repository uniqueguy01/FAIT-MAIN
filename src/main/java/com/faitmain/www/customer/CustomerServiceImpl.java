package com.faitmain.www.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faitmain.www.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao dao;

	@Override
	public List<Customer> list() {
		return dao.list();
	}

	@Override
	public void add(Customer item) {
		dao.add(item);
	}

	@Override
	public void delete(String id) {
		dao.delete(id);
	}

	@Override
	public Customer item(String id) {
		return dao.item(id);
	}

	@Override
	public void update(Customer item) {
		dao.update(item);
	}

}
