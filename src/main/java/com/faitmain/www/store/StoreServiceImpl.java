package com.faitmain.www.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faitmain.www.model.Maker;
import com.faitmain.www.model.Store;
import com.faitmain.www.model.StoreImg;

@Transactional
@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	StoreDao dao;
	
	@Override
	public List<Store> list() {
		
	    return dao.list();
		
	}

	@Override
	public void add(Store item) {
		
		// 1. Store 저장
		dao.add(item);
		
		// 2. Store 이미지 저장
		if(item.getStoreImg() != null) {
			for(StoreImg storeImg : item.getStoreImg()) {
				storeImg.setStoreId(item.getId());	// 가게에서 ceonum 가져와서 외래키 설정
				dao.addStoreImg(storeImg);
			}
		}
		
		// 3. Maker(작가) 정보 저장
		if (item.getMaker() != null) {
			for (Maker maker : item.getMaker()) {
				maker.setStoreId(item.getId());	// 가게에서 ceonum 가져와서 외래키 설정
				dao.addMaker(maker);
			}
		}
		
	}

	@Override
	public void update(Store item) {
		
		// 1. 가게 정보 업데이트
		dao.update(item);
		
		// 2. 가게 이미지 업데이트
		if(item.getStoreImg() != null) {
			for(StoreImg storeImg : item.getStoreImg()) {
				storeImg.setStoreId(item.getId());
				dao.addStoreImg(storeImg);
			}
		}
	}

	@Override
	public void delete(Long id) {
		
		// 1. 가게 이미지 삭제
		dao.deleteStoreImg(id);
		
		// 2. 가게 정보 삭제
		dao.delete(id);
	}

	@Override
	public Store item(Long id) {
		
		// 1. 가게 정보 하나 가져와서 저장
		Store item = dao.item(id);
		
		// 2. 가게 정보 하나 리턴
		return item;
	}

	@Override
	public StoreImg itemStoreImg(Long id) {
		
		// 가게 이미지 하나 리턴
		return dao.itemStoreImg(id);
		
	}

	@Override
	public void deleteStoreImg(Long id) {
		
		// 가게 이미지 삭제
		dao.deleteStoreImg(id);
		
	}

	@Override
	public Store getStoreId(String id) {
		return dao.getStoreId(id);
	}

}
