package com.faitmain.www.store;

import java.util.List;

import com.faitmain.www.model.Maker;
import com.faitmain.www.model.Store;
import com.faitmain.www.model.StoreImg;

public interface StoreDao {

	List<Store> list();

	void add(Store item);

	void update(Store item);

	void delete(Long id);

	Store item(Long id);

	StoreImg itemStoreImg(Long id);

	void deleteStoreImg(Long id);

	void addStoreImg(StoreImg storeImg);

	void addMaker(Maker maker);

	Store getStoreId(String id);

	void deleteMaker(Long id);

}
