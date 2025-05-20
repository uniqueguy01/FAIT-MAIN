package com.faitmain.www.customer;

import java.util.List;

import com.faitmain.www.model.Customer;

public interface CustomerService {

   List<Customer> list();

   void add(Customer item);

   void delete(String id);

   Customer item(String id);

   void update(Customer item);
   
   boolean login(Customer item);

}
