package com.faitmain.www.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	
private Map<Long, Integer> cart = new HashMap<Long, Integer>();
	
	public void setCart(Long shoeid, Integer amount) {
		if(cart.containsKey(shoeid))
			cart.put(shoeid, cart.get(shoeid) + amount);
		else
			cart.put(shoeid, amount);			
	}
	
	public Map<Long, Integer> getCart() {
		return cart;
	}

	public void delete(Long shoeid) {
		cart.remove(shoeid);
	}
}
