package com.faitmain.www.shoe;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faitmain.www.model.Shoe;

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

}
