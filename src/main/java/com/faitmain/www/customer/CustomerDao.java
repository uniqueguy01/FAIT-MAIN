package com.faitmain.www.customer;

import java.util.List;

import com.faitmain.www.model.Customer;

public interface CustomerDao {

   List<Customer> list();

   void add(Customer item);

   void delete(String id);

   Customer item(String id);

   void update(Customer item);

   Customer login(String id, String password);

}