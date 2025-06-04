package com.faitmain.www.store;

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

import com.faitmain.www.model.Store;

@RestController
@RequestMapping("/store")
public class StoreController {

	@Autowired
	StoreService service;
	
	@GetMapping
	List<Store> list(){
		return service.list();
	}
	
	@PostMapping
	void add(@RequestBody Store item) {
		service.add(item);
	}
	
	@PutMapping
	void update(@RequestBody Store item) {
		service.update(item);
	}
	
	@DeleteMapping("/{ceonum}")
	void delete(@PathVariable String ceonum) {
		service.delete(ceonum);
	}
}
