package com.faitmain.www;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.faitmain.www.model.Customer;
import com.faitmain.www.model.Store;
import com.faitmain.www.store.StoreService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FaitMainRootController {
	
	@Autowired
	StoreService storeService;

	@GetMapping("/")
	String index(Model model, HttpSession session) {
		
		// 전체 가게 리스트 (기존 유지)
	    List<Store> list = storeService.list();
	    model.addAttribute("storeList", list);

	    // 세션에서 로그인한 사용자 정보 가져오기
	    Customer customer = (Customer) session.getAttribute("customer");

	    // 로그인 상태일 경우만 해당 고객의 가게 가져오기
	    if (customer != null) {
	        Store myStore = storeService.getCeonum(customer.getId());  // 고객 ID로 가게 조회
	        model.addAttribute("myStore", myStore); // 로그인한 고객의 가게 정보
	    }
		
		return "index";
	}

}
