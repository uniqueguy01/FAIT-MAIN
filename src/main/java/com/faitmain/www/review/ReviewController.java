package com.faitmain.www.review;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.faitmain.www.model.Review;
import com.faitmain.www.model.ReviewImg;

@Controller
@RequestMapping("/review")
public class ReviewController {

	final String path = "shoe/";
	
	final String uploadPath = "c:/upload/";
	
	@Autowired
	ReviewService service;
	
	@GetMapping("/add")
	String add() {
		
		return path + "add";
	}
	
	@PostMapping("/add")
	String add(Review item, List<MultipartFile> uploadFile) {
		
		List<ReviewImg> reviewImgs = new ArrayList<ReviewImg>();
		
		for(MultipartFile file : uploadFile) {
			if(file != null && !file.isEmpty()) {
				String filename = file.getOriginalFilename();
				String uuid = UUID.randomUUID().toString();
					
				try {
					file.transferTo(new File(uploadPath + uuid + "_" + filename));
						
					ReviewImg reviewImg = new ReviewImg();
					reviewImg.setFile(filename);
					reviewImg.setUuid(uuid);
						
					reviewImgs.add(reviewImg);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
			
		item.setReviewImg(reviewImgs);
		
		service.add(item);
		
		return "redirect:list";
		
	}
}
