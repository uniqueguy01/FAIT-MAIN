package com.faitmain.www;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.faitmain.www.customer.CustomerService;
import com.faitmain.www.model.Customer;
import com.faitmain.www.model.Shoe;
import com.faitmain.www.model.Store;
import com.faitmain.www.shoe.ShoeService;
import com.faitmain.www.store.StoreService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FaitMainRootController {
	
	@Autowired
	StoreService storeService;
	
	@Autowired
	ShoeService shoeService;
	
	@Autowired
	CustomerService service;
	
	// 메인 페이지
	@GetMapping("/")
	String index(Model model, HttpSession session) {
		
		// 전체 가게 리스트 (기존 유지)
	    List<Store> list = storeService.list();
	    List<Shoe> shoes = shoeService.list();
	    
	    model.addAttribute("storeList", list);
	    model.addAttribute("shoes", shoes);

	    // 세션에서 로그인한 사용자 정보 가져오기
	    Customer customer = (Customer) session.getAttribute("customer");

	    // 로그인 상태일 경우만 해당 고객의 가게 가져오기
	    if (customer != null) {
	        Store myStore = storeService.getStoreId(customer.getId());  // 고객 ID로 가게 조회
	        model.addAttribute("myStore", myStore); // 로그인한 고객의 가게 정보
	    }
		
		return "index";
	}
	
	// 마이 페이지
	@GetMapping("/mypage")
	String mypage(Model model, HttpSession session) {
		
		// 세션에서 로그인한 사용자 정보 가져오기
	    Customer customer = (Customer) session.getAttribute("customer");

	    // 로그인 상태일 경우만 해당 고객의 가게 가져오기
	    if (customer != null) {
	        Store myStore = storeService.getStoreId(customer.getId());  // 고객 ID로 가게 조회
	        model.addAttribute("myStore", myStore); // 로그인한 고객의 가게 정보
	    }
	    
		return "mypage";
	}
	
	// 로그인 팝업
	@GetMapping("/login/{type}/popup")
	String loginPopup(@PathVariable String type) {
		return "login_popup";
	}
	
	// 로그인 팝업
	@PostMapping("/login/{type}/popup")
	String loginPopup(@PathVariable String type, Model model, Customer item, HttpSession session) {
		if(service.login(item)) {
			session.setAttribute("customer", item);
			Customer customer = (Customer) session.getAttribute("customer");
			model.addAttribute("customer", customer);
			
			System.out.println("확인 " + (customer != null ? customer.getId() : "null"));
			
			return "login_popup";
		} else {
			return "redirect:popup";
		}
	}

}
