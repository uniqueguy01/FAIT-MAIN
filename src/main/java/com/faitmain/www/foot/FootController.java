package com.faitmain.www.foot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.faitmain.www.model.Foot;

@Controller
@RequestMapping("/foot")
public class FootController {
	
final String path = "foot/";
	
	@Autowired
	FootService service;
	
	@GetMapping("/list")
	String list(Model model) {
		List<Foot> list = service.list();
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	@GetMapping("/add")
	String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	String add(Foot item) {
		service.add(item);
		
		return "redirect:list";
	}
	
	@GetMapping("/delete/{custid}")
	String delete(@PathVariable String custid) {
		service.delete(custid);
		
		return "redirect:../list";
	}
	
	@GetMapping("/update/{custid}")
	String update(@PathVariable String custid, Model model) {
		Foot item = service.item(custid);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	@PostMapping("/update/{custid}")
	String update(@PathVariable String custid, Foot item) {
		item.setCustid(custid);
		
		service.update(item);
		
		return "redirect:../list";
	}

}