package com.faitmain.www.shoe;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.faitmain.www.model.Shoe;
import com.faitmain.www.model.ShoeImg;

@Controller
@RequestMapping("/shoe")
public class ShoeController {

	final String path = "shoe/";
	
	final String uploadPath = "src/main/resources/static/img/";
	
	@Autowired
	ShoeService service;
	
	// 신발 리스트 페이지
	@GetMapping("/list")
	String list(Model model) {
		
		List<Shoe> list = service.list();
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	// 신발 정보 추가 페이지
	@GetMapping("/add")
	String add() {
		
		return path + "add";
	}
	
	// 신발 정보 추가
	@PostMapping("/add")
	String add(Shoe item, List<MultipartFile> uploadFile) {
		
		List<ShoeImg> shoeImgs = new ArrayList<ShoeImg>();
			
		for(MultipartFile file : uploadFile) {
			if(file != null && !file.isEmpty()) {
				String filename = file.getOriginalFilename();
				String uuid = UUID.randomUUID().toString();
					
				try {
					file.transferTo(new File(uploadPath + uuid + "_" + filename));
						
					ShoeImg shoeImg = new ShoeImg();
					shoeImg.setFilename(filename);
					shoeImg.setUuid(uuid);
						
					shoeImgs.add(shoeImg);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
			
		item.setShoeImg(shoeImgs);
		
		service.add(item);
		
		return "redirect:list";

	}
	
	// 신발 정보 수정 페이지
	@GetMapping("/update/{id}")
	String update(@PathVariable Long id, Model model) {
		Shoe item = service.item(id);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	// 신발 정보 수정
	@PostMapping("/update/{id}")
	String update(@PathVariable Long id, Shoe item, List<MultipartFile> uploadFile) {
		
		List<ShoeImg> shoeImgs = new ArrayList<ShoeImg>();
			
		for(MultipartFile file : uploadFile) {
			if(file != null && !file.isEmpty()) {
				String filename = file.getOriginalFilename();
				String uuid = UUID.randomUUID().toString();
					
				try {
					file.transferTo(new File(uploadPath + uuid + "_" + filename));
						
					ShoeImg shoeImg = new ShoeImg();
					shoeImg.setFilename(filename);
					shoeImg.setUuid(uuid);
						
					shoeImgs.add(shoeImg);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
			
		item.setShoeImg(shoeImgs);
		
		service.update(item);
		
		return "redirect:../list";
	}
	
	// 신발 정보 삭제
	@GetMapping("/delete/{id}")
	String delete(@PathVariable Long id) {
		Shoe item = service.item(id);
		
		for(ShoeImg shoeImg : item.getShoeImg()) {
			File file = new File (uploadPath + shoeImg.getUuid() + "_" + shoeImg.getFilename());
			file.delete();
		}
		
		service.delete(id);
		
		return "redirect:../list";
	}
	
	// 신발 사진 삭제
	@ResponseBody
	@GetMapping("/delete/shoeimg/{id}")
	String deleteShoeImg(@PathVariable Long id) {
		ShoeImg item = service.itemShoeImg(id);
		
		service.deleteShoeImg(id);
		
		File file = new File (uploadPath + item.getUuid() + "_" + item.getFilename());
		file.delete();
		
		return id.toString();
	}
	
}
