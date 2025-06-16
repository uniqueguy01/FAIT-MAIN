package com.faitmain.www.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faitmain.www.model.Maker;
import com.faitmain.www.model.Store;
import com.faitmain.www.model.StoreImg;

@Repository
public class StoreDaoImpl implements StoreDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Store> list() {
		return sql.selectList("store.list");
	}

	@Override
	public void add(Store item) {
		sql.insert("store.add", item);
	}

	@Override
	public void update(Store item) {
		sql.update("store.update", item);
	}

	@Override
	public void delete(Long id) {
		sql.delete("store.delete", id);
	}

	@Override
	public Store item(Long id) {
		return sql.selectOne("store.item", id);
	}

	@Override
	public StoreImg itemStoreImg(Long id) {
		return sql.selectOne("store.itemStoreImg", id);
	}

	@Override
	public void deleteStoreImg(Long id) {
		sql.delete("store.deleteStoreImg", id);
	}

	@Override
	public void addStoreImg(StoreImg storeImg) {
		sql.insert("store.addStoreImg", storeImg);
	}

	@Override
	public void addMaker(Maker maker) {
		sql.insert("store.addMaker", maker);
	}

	@Override
	public Store getStoreId(String id) {
		return sql.selectOne("store.getStoreId", id);
	}

	@Override
	public void deleteMaker(Long id) {
		sql.delete("store.deleteMaker", id);
		
	}

	@Override
	public Maker itemMaker(Long id) {
		return sql.selectOne("store.itemMaker", id);
	}

	@Override
	public void updateMaker(Maker maker) {
		sql.update("store.updateMaker", maker);
		
	}

	@Override
	public void updateNotice(Store store) {
		sql.update("store.updateNotice", store);
	}

}
