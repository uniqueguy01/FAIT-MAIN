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

import com.faitmain.www.model.Customer;
import com.faitmain.www.model.Maker;
import com.faitmain.www.model.Shoe;
import com.faitmain.www.model.Store;
import com.faitmain.www.model.StoreImg;
import com.faitmain.www.shoe.ShoeService;

import jakarta.servlet.http.HttpSession;

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
	@GetMapping("/list/{id}")
	String list(@PathVariable Long id, Model model,  HttpSession session) {
		
		List<Shoe> list = shoeService.list(id);
		Store item = service.item(id);
		List<String> categories = shoeService.getCategories(id); // 카테고리 목록
		
		// ✅ 세션에서 Customer 객체 꺼내서 ID 비교
	    Customer customer = (Customer) session.getAttribute("customer");
	    String loginId = customer != null ? customer.getId() : null;
	    boolean isOwner = loginId != null && loginId.equals(item.getCustId());
		
		model.addAttribute("list", list);
		model.addAttribute("categories", categories); // 카테고리 추가
		model.addAttribute("item", item);
		model.addAttribute("isOwner", isOwner); // 뷰에서 조건 분기용
		
		System.out.println("로그인 ID: " + loginId); // null이면 세션에 값이 없음
		System.out.println("가게 등록자 ID: " + item.getCustId());
		System.out.println("isOwner: " + isOwner);
		
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
	    
	    // 배너 이미지
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
		
		return "redirect:/mypage";

	}
	
	// 가게 수정 페이지
	@GetMapping("/update/{id}")
	String update(@PathVariable Long id, Model model) {
		
		Store item = service.item(id);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	// 가게 정보 수정
	@PostMapping("/update/{id}")
	String update(@PathVariable Long id, Store item, @RequestParam(required = false) MultipartFile mainImage,
													 @RequestParam(required = false) List<MultipartFile> bannerImage,
													 @RequestParam(required = false) List<Long> makerIds,
													 @RequestParam(required = false) List<String> makerName,
													 @RequestParam(required = false) List<String> makerInfo,
													 @RequestParam(required = false) List<MultipartFile> makerImages,
													 @RequestParam(required = false) List<String> existingMakerFilenames,
													 @RequestParam(required = false) List<String> existingMakerUuids) {
		
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
	    
	    // 배너 이미지
	    if (bannerImage != null) {
	        for (MultipartFile file : bannerImage) {
	            if (file != null && !file.isEmpty()) {
	                try {
	                    String filename = file.getOriginalFilename();
	                    String uuid = UUID.randomUUID().toString();
	                    file.transferTo(new File(uploadPath + uuid + "_" + filename));

	                    StoreImg storeImg = new StoreImg();
	                    storeImg.setFilename(filename);
	                    storeImg.setUuid(uuid);
	                    storeImg.setType("banner");

	                    storeImgs.add(storeImg);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }

	    // 작가 정보 처리
	    if (makerName != null && makerInfo != null && makerName.size() > 0) {
	        for (int i = 0; i < makerName.size(); i++) {
	            Maker maker = new Maker();
	            maker.setName(makerName.get(i));
	            maker.setInfo(makerInfo.get(i));

	            if (makerImages != null && i < makerImages.size() && !makerImages.get(i).isEmpty()) {
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
	             // 기존 이미지 유지 조건
	            } else if (existingMakerFilenames != null && existingMakerUuids != null &&
	                    i < existingMakerFilenames.size() && i < existingMakerUuids.size()) {

	                maker.setFilename(existingMakerFilenames.get(i));
	                maker.setUuid(existingMakerUuids.get(i));
	            }
	            
	            // 기존 작가 ID가 있다면 설정
	            if (makerIds != null && i < makerIds.size()) {
	                maker.setId(makerIds.get(i));
	            }

	            makerList.add(maker);
	        }
	    }

	    item.setStoreImg(storeImgs);
	    item.setMaker(makerList);
	    
	    service.update(item);

	    return "redirect:/mypage";
	}
	
	// 공지사항 수정
	@PostMapping("/notice/{id}")
	public String updateNotice(@PathVariable Long id, @RequestParam("notice") String notice, HttpSession session) {
		
		System.out.println(notice);
		
	    Store store = service.item(id);
	    
	    store.setId(id); // ✅ 혹시 모르니 명시적으로 ID 다시 세팅
	    store.setNotice(notice);
	    
	    System.out.println(store.getNotice());

	    service.updateNotice(store);

	    return "redirect:/store/list/" + id;
	}
	
	// 가게 정보 삭제
	@GetMapping("/delete/{id}")
	String delete(@PathVariable Long id) {
		Store item = service.item(id);
		
		// 1. 가게 이미지 삭제
		for(StoreImg storeImg : item.getStoreImg()) {
			File file = new File (uploadPath + storeImg.getUuid() + "_" + storeImg.getFilename());
			file.delete();
		}
		
		// 2. 작가 이미지 삭제
	    if (item.getMaker() != null) {
	        for (Maker maker : item.getMaker()) {
	            new File(uploadPath + maker.getUuid() + "_" + maker.getFilename()).delete();
	        }
	    }
		
		service.delete(id);
		
		return "redirect:/";
	}
	
	// 가게 사진 삭제
	@ResponseBody
	@GetMapping("/delete/storeimg/{id}")
	String deleteStoreImg(@PathVariable Long id) {
		
		// 1. 이미지 정보 조회 (DB 삭제 전에 조회해야 함)
	    StoreImg item = service.itemStoreImg(id);
	    if (item == null) {
	        return "이미지 없음";
	    }

	    // 2. DB에서 이미지 정보 삭제
	    service.deleteStoreImg(id);

	    // 3. 물리 파일 삭제
	    File file = new File(uploadPath + item.getUuid() + "_" + item.getFilename());
	    if (file.exists()) {
	        boolean deleted = file.delete();
	        if (!deleted) {
	            System.out.println("파일 삭제 실패: " + file.getAbsolutePath());
	        }
	    }
		
		return id.toString();
	}
	
	// 작가 삭제
	@ResponseBody
	@GetMapping("/delete/maker/{id}")
	public String deleteMaker(@PathVariable Long id) {
	    Maker item = service.itemMaker(id);  // 기존 작가 정보 가져오기
	    
	    service.deleteMaker(id);	// DB에서 삭제
	    
	    File file = new File (uploadPath + item.getUuid() + "_" + item.getFilename());
		file.delete();
		
	    return id.toString();
	}

}
