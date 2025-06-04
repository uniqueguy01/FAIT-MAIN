package com.faitmain.www.orders;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.faitmain.www.model.Online;
import com.faitmain.www.model.Orders;

public class OrdersDaoImpl implements OrdersDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public void add(Orders item) {
		sql.insert("orders.add", item);
	}

	@Override
	public void addOnline(Online online) {
		sql.insert("orders.add_online", online);
	}

	@Override
	public Orders item(Long id) {
		return sql.selectOne("orders.item", id);
	}

}
