package com.faitmain.www.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	
private Map<Long, Integer> cart = new HashMap<Long, Integer>();
	
	public void setCart(Long shoeId, Integer amount) {
		if(cart.containsKey(shoeId))
			cart.put(shoeId, cart.get(shoeId) + amount);
		else
			cart.put(shoeId, amount);			
	}
	
	public Map<Long, Integer> getCart() {
		return cart;
	}

	public void delete(Long shoeid) {
		cart.remove(shoeid);
	}
}
