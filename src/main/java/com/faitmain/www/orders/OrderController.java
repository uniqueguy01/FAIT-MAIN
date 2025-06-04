package com.faitmain.www.orders;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.faitmain.www.model.Cart;
import com.faitmain.www.model.Customer;
import com.faitmain.www.model.Online;
import com.faitmain.www.model.Orders;
import com.faitmain.www.model.Visit;

@Controller
@RequestMapping("/orders")
public class OrderController {
	final String path = "orders/";
	
	@Autowired
	OrdersService service;
	
	@GetMapping
	String order(@SessionAttribute Customer customer, @SessionAttribute Cart cart) {
		Orders item = new Orders();
		
		item.setCustid(customer.getId());
		
		Map<Long, Integer> map = cart.getCart();
		ArrayList<Online> onlines = new ArrayList<Online>();
		
		for(Long shoeid : map.keySet()) {
			Online online = new Online();
			
			online.setShoeid(shoeid);
			online.setAmount(map.get(shoeid));
			
			onlines.add(online);
		}
		
		item.setOnline(onlines);
		
		service.order(item);
		
		return "redirect:/orders/" + item.getId();
	}
	
	@GetMapping("/{id}")
	String view(@PathVariable Long id, Model model) {
		Orders item = service.item(id);
		
		model.addAttribute("item", item);
		
		return path + "view";
	}

}
