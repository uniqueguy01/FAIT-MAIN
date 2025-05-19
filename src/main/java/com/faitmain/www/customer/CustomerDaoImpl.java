package com.faitmain.www.customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faitmain.www.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
   
   @Autowired
   SqlSession sql;

   @Override
   public List<Customer> list() {
      return sql.selectList("customer.list");
   }

   @Override
   public void add(Customer item) {
      sql.insert("customer.add", item);
   }

   @Override
   public void delete(String id) {
      sql.delete("customer.delete", id);
   }

   @Override
   public Customer item(String id) {
      return sql.selectOne("customer.item", id);
   }

   @Override
   public void update(Customer item) {
      sql.update("customer.update", item);
   }

   @Override
   public Customer login(String id, String password) {
       Map<String, Object> params = new HashMap<>();
       params.put("id", id);
       params.put("password", password);
       return sql.selectOne("customer.login", params);
   }


}
