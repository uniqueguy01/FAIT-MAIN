package com.faitmain.www.shoe;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faitmain.www.model.Shoe;
import com.faitmain.www.model.ShoeImg;

@Repository
public class ShoeDaoImpl implements ShoeDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<Shoe> list() {
		return sql.selectList("shoe.list");
	}

	@Override
	public void add(Shoe item) {
		sql.insert("shoe.add", item);
	}

	@Override
	public void update(Shoe item) {
		sql.update("shoe.update", item);
	}

	@Override
	public void delete(Long id) {
		sql.delete("shoe.delete", id);
	}

	@Override
	public void addShoeImg(ShoeImg shoeImg) {
		sql.insert("shoe.addShoeImg", shoeImg);
	}

	@Override
	public Shoe item(Long id) {
		return sql.selectOne("shoe.item", id);
	}

	@Override
	public void deleteShoeImg(Long id) {
		sql.delete("shoe.deleteShoeImg", id);
	}

	@Override
	public ShoeImg itemShoeImg(Long id) {
		return sql.selectOne("shoe.itemShoeImg", id);
	}

	@Override
	public List<Shoe> list(Long id) {
		return sql.selectList("shoe.storeList", id);
	}

	@Override
	public void deleteItemShoeImg(Long id) {
		sql.delete("shoe.deleteItemShoeImg", id);
	}

	@Override
	public void delShoeImgs(Long id) {
		sql.delete("shoe.delShoeImgs", id);
	}

	@Override
	public void deleteShoes(Long id) {
		sql.delete("shoe.delShoes", id);
	}

	@Override
	public List<String> getCategories(Long id) {
		return sql.selectList("shoe.getCategories", id);
	}

}
