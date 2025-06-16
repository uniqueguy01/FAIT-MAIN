package com.faitmain.www.orders;

import com.faitmain.www.model.Orders;

public interface OrdersService {

	void order(Orders item);

	Orders item(Long id);

}
