package com.faitmain.www.store;

import java.util.List;

import com.faitmain.www.model.Store;

public interface StoreService {

	List<Store> list();

	void add(Store item);

	void update(Store item);

	void delete(String ceonum);

}
