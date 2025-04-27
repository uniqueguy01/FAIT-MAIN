package com.faitmain.www.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faitmain.www.model.Store;

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
		dao.add(item);
	}

	@Override
	public void update(Store item) {
		dao.update(item);
	}

	@Override
	public void delete(String ceonum) {
		dao.delete(ceonum);
	}

}
