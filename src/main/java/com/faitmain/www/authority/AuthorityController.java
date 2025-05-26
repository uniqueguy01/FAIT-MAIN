package com.faitmain.www.authority;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.faitmain.www.model.Authority;

@Controller
@RequestMapping("/role")
public class AuthorityController {
	
	final String path = "authority/";
	
	AuthorityService service;

	public AuthorityController(AuthorityService service) {
		this.service = service;
	}
	
	@GetMapping({"/list", "/{username}/list"})
	String list(Model model) {
		List<Authority> list = service.list();
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	@GetMapping("/add")
	String add() {
		
		return path + "list";
	}
	
	@PostMapping("/add")
	String add(Authority item) {
		
		service.add(item);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{code}")
	String update(@PathVariable Long code, Model model) {
		Authority item = service.item(code);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	@PostMapping("/update/{code}")
	String update(@PathVariable Long code, Authority item) {
		item.setCode(code);
		
		service.update(item);
		
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{code}")
	String delete(@PathVariable Long code) {
		service.delete(code);
		
		return "redirect:../list";	

	}
}