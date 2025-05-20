package com.faitmain.www.store;

import java.util.List;

import com.faitmain.www.model.Maker;
import com.faitmain.www.model.Store;
import com.faitmain.www.model.StoreImg;

public interface StoreDao {

	List<Store> list();

	void add(Store item);

	void update(Store item);

	void delete(String ceonum);

	Store item(String ceonum);

	StoreImg itemStoreImg(String ceonum);

	void deleteStoreImg(String ceonum);

	void addStoreImg(StoreImg storeImg);

	void addMaker(Maker maker);

	Store getCeonum(String id);

}
