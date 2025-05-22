package com.faitmain.www.store;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.faitmain.www.model.Maker;
import com.faitmain.www.model.Shoe;
import com.faitmain.www.model.Store;
import com.faitmain.www.model.StoreImg;
import com.faitmain.www.shoe.ShoeService;

@Controller
@RequestMapping("/store")
public class StoreController {

	final String path = "store/";
	
	final String uploadPath = "c:/upload/";
	
	@Autowired
	StoreService service;
	
	@Autowired
	ShoeService shoeService;
	
	// 가게 리스트 페이지
	@GetMapping("/list/{ceonum}")
	String list(@PathVariable String ceonum, Model model) {
		
		List<Shoe> list = shoeService.list(ceonum);
		Store item = service.item(ceonum);
		
		model.addAttribute("list", list);
		model.addAttribute("item", item);
		
		return path + "list";
	}
	
	// 가게 추가 페이지
	@GetMapping("/add")
	String add() {
		return path + "add";
	}
	
	// 가게 정보 추가
	@PostMapping("/add")
	String imgadd(Store item, @RequestParam("makerName") List<String> makerName, @RequestParam("makerInfo") List<String> makerInfo, @RequestParam("mainImage") MultipartFile mainImage, @RequestParam("bannerImage") List<MultipartFile> bannerImage, @RequestParam("makerImages") List<MultipartFile> makerImages) {
		
		List<Maker> makerList = new ArrayList<>();
		
		List<StoreImg> storeImgs = new ArrayList<>();
		
		// 대표 이미지 (1개)
	    if (mainImage != null && !mainImage.isEmpty()) {
	        try {
	            String filename = mainImage.getOriginalFilename();
	            String uuid = UUID.randomUUID().toString();
	            mainImage.transferTo(new File(uploadPath + uuid + "_" + filename));

	            StoreImg storeImg = new StoreImg();
	            storeImg.setFilename(filename);
	            storeImg.setUuid(uuid);
	            storeImg.setType("main"); // ✅ 타입 지정

	            storeImgs.add(storeImg);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	 // 배너 이미지 (여러 개)
	    for (MultipartFile file : bannerImage) {
	        if (file != null && !file.isEmpty()) {
	            try {
	                String filename = file.getOriginalFilename();
	                String uuid = UUID.randomUUID().toString();
	                file.transferTo(new File(uploadPath + uuid + "_" + filename));

	                StoreImg storeImg = new StoreImg();
	                storeImg.setFilename(filename);
	                storeImg.setUuid(uuid);
	                storeImg.setType("banner"); // ✅ 타입 지정

	                storeImgs.add(storeImg);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    // 작가 정보 처리
	    for (int i = 0; i < makerName.size(); i++) {
	        Maker maker = new Maker();
	        maker.setStoreId(item.getId());
	        maker.setName(makerName.get(i));
	        maker.setInfo(makerInfo.get(i));

	        if (i < makerImages.size() && !makerImages.get(i).isEmpty()) {
	            try {
	                MultipartFile file = makerImages.get(i);
	                String filename = file.getOriginalFilename();
	                String uuid = UUID.randomUUID().toString();
	                file.transferTo(new File(uploadPath + uuid + "_" + filename));

	                maker.setFilename(filename);
	                maker.setUuid(uuid);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        makerList.add(maker);
	    }
	    
	    item.setStoreImg(storeImgs);
	    item.setMaker(makerList);
	    
	    // 가게 정보 저장
	    service.add(item); // 내부적으로 StoreImg도 insert됨 + 작가 정보
		
		return "redirect:/";

	}
	
	// 가게 수정 페이지
	@GetMapping("/update/{ceonum}")
	String update(@PathVariable String ceonum, Model model) {
		
		Store item = service.item(ceonum);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	// 가게 정보 수정
	@PostMapping("/update/{ceonum}")
	String update(@PathVariable String ceonum, Store item, List<MultipartFile> uploadFile) {
		
		List<StoreImg> storeImgs = new ArrayList<StoreImg>();
		
		for(MultipartFile file : uploadFile) {
			if(file != null && !file.isEmpty()) {
				String filename = file.getOriginalFilename();
				String uuid = UUID.randomUUID().toString();
					
				try {
					file.transferTo(new File(uploadPath + uuid + "_" + filename));
						
					StoreImg storeImg = new StoreImg();
					storeImg.setFilename(filename);
					storeImg.setUuid(uuid);
						
					storeImgs.add(storeImg);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
			
		item.setStoreImg(storeImgs);
		
		service.update(item);
		
		return "redirect:/";
	}
	
	// 가게 정보 삭제
	@GetMapping("/delete/{ceonum}")
	String delete(@PathVariable String ceonum) {
		Store item = service.item(ceonum);
		
		for(StoreImg storeImg : item.getStoreImg()) {
			File file = new File (uploadPath + storeImg.getUuid() + "_" + storeImg.getFilename());
			file.delete();
		}
		
		service.delete(ceonum);
		
		return "redirect:/";
	}
	
	// 가게 사진 삭제
	@ResponseBody
	@GetMapping("/delete/storeimg/{ceonum}")
	String deleteStoreImg(@PathVariable String ceonum) {
		StoreImg item = service.itemStoreImg(ceonum);
		
		service.deleteStoreImg(ceonum);
		
		File file = new File (uploadPath + item.getUuid() + "_" + item.getFilename());
		file.delete();
		
		return "index";
	}

}
