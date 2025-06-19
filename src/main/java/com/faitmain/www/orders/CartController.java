package com.faitmain.www.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.faitmain.www.model.Cart;
import com.faitmain.www.model.Customer;
import com.faitmain.www.model.Shoe;
import com.faitmain.www.shoe.ShoeService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	ShoeService service;
	
	@GetMapping
	String cart(@SessionAttribute(required=false) Cart cart, Model model, HttpSession session) {		
		if(cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart); // 세션에 cart 저장
		}
			
		List<Shoe> list = service.list(cart.getCart().keySet() );
		
		model.addAttribute("list", list);
		model.addAttribute("cart", cart); // 모델에 cart 추가
		
		// 디버깅 로그
		System.out.println("Cart in /cart: " + cart);
        System.out.println("List in /cart: " + list);
		
		return "cart";
	}
	
	@ResponseBody
	@GetMapping("/{shoeId}/{amount}")
	Cart add(@PathVariable Long shoeId, @PathVariable int amount, @SessionAttribute Customer customer, @SessionAttribute(required=false) Cart cart, HttpSession session) {
		if(cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		
		cart.setCart(shoeId, amount);
		
		return cart;
	}
	
	@ResponseBody
	@DeleteMapping("/{shoeId}")
	void delete(@PathVariable Long shoeId, @SessionAttribute Cart cart) {
		cart.delete(shoeId);
		
		System.out.println("소스트리");
	}
	
	

}
