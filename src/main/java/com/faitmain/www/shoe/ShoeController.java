package com.faitmain.www.shoe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faitmain.www.model.Shoe;

@RestController
@RequestMapping("/shoe")
public class ShoeController {

	@Autowired
	ShoeService service;
	
	@GetMapping
	List<Shoe> list(){
		return service.list();
	}
	
	@PostMapping
	void add(@RequestBody Shoe item) {
		service.add(item);
	}
	
	@PutMapping
	void update(@RequestBody Shoe item) {
		service.update(item);
	}
	
	@DeleteMapping("/{id}")
	void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
}
