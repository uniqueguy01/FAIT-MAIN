package com.faitmain.www.orders;

import com.faitmain.www.model.Online;
import com.faitmain.www.model.Orders;

public interface OrdersDao {

	void add(Orders item);

	void addOnline(Online online);

	Orders item(Long id);

	
}
