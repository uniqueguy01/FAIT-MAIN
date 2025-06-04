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
		
		// 가게 정보 리턴
		return dao.list();
		
	}

	@Override
	public void add(Store item) {
		
		// 1. Store 저장
		dao.add(item);
		
		// 2. Store 이미지 저장
		if(item.getStoreImg() != null) {
			for(StoreImg storeImg : item.getStoreImg()) {
				storeImg.setCeonum(item.getCeonum());	// 가게에서 ceonum 가져와서 외래키 설정
				dao.addStoreImg(storeImg);
			}
		}
		
		// 3. Maker(작가) 정보 저장
		if (item.getMaker() != null) {
			for (Maker maker : item.getMaker()) {
				maker.setCeonum(item.getCeonum());	// 가게에서 ceonum 가져와서 외래키 설정
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
				storeImg.setCeonum(item.getCeonum());
				dao.addStoreImg(storeImg);
			}
		}
	}

	@Override
	public void delete(String ceonum) {
		
		// 1. 가게 이미지 삭제
		dao.deleteStoreImg(ceonum);
		
		// 2. 가게 정보 삭제
		dao.delete(ceonum);
	}

	@Override
	public Store item(String ceonum) {
		
		// 1. 가게 정보 하나 가져와서 저장
		Store item = dao.item(ceonum);
		
		// 2. 가게 정보 하나 리턴
		return item;
	}

	@Override
	public StoreImg itemStoreImg(String ceonum) {
		
		// 가게 이미지 하나 리턴
		return dao.itemStoreImg(ceonum);
		
	}

	@Override
	public void deleteStoreImg(String ceonum) {
		
		// 가게 이미지 삭제
		dao.deleteStoreImg(ceonum);
		
	}

	@Override
	public Store getCeonum(String id) {
		return dao.getCeonum(id);
	}

}
