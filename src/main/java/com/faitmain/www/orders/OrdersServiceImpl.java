package com.faitmain.www.orders;

import org.springframework.beans.factory.annotation.Autowired;

import com.faitmain.www.model.Online;
import com.faitmain.www.model.Orders;

public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersDao dao;
	
	@Override
	public void order(Orders item) {
		dao.add(item);
		
		for(Online online : item.getOnline()) {
			online.setOrderid(item.getId());
			
			dao.addOnline(online);
		}

	}

	@Override
	public Orders item(Long id) {		
		return dao.item(id);
	}

}
