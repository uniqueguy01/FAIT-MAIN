package com.faitmain.www;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.faitmain.www.model.Store;
import com.faitmain.www.store.StoreService;

@Controller
public class FaitMainRootController {
	
	@Autowired
	StoreService storeService;

	@GetMapping("/")
	String index(Model model) {
		
		List<Store> list = storeService.list();
		
		model.addAttribute("storeList", list);
		
		return "index";
	}

}
