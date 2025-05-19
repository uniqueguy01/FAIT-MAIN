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
	public void delete(String ceonum) {
		sql.delete("store.delete", ceonum);
	}

	@Override
	public Store item(String ceonum) {
		return sql.selectOne("store.item", ceonum);
	}

	@Override
	public StoreImg itemStoreImg(String ceonum) {
		return sql.selectOne("store.itemStoreImg", ceonum);
	}

	@Override
	public void deleteStoreImg(String ceonum) {
		sql.delete("store.deleteStoreImg", ceonum);
	}

	@Override
	public void addStoreImg(StoreImg storeImg) {
		sql.insert("store.addStoreImg", storeImg);
	}

	@Override
	public void addMaker(Maker maker) {
		sql.insert("store.addMaker", maker);
	}

}
