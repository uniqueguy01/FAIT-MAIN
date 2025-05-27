package com.faitmain.www.store;

import java.util.List;

import com.faitmain.www.model.Maker;
import com.faitmain.www.model.Store;
import com.faitmain.www.model.StoreImg;

public interface StoreService {

	List<Store> list();

	void add(Store item);

	void update(Store item);

	void delete(Long id);

	Store item(Long id);

	StoreImg itemStoreImg(Long id);

	void deleteStoreImg(Long id);

	Store getStoreId(String id);

	Maker itemMaker(Long id);

	void deleteMaker(Long id);

}
