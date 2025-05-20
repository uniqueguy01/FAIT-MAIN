package com.faitmain.www.foot;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faitmain.www.model.Foot;

@Repository
public class FootDaoImpl implements FootDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<Foot> list() {
		return sql.selectList("foot.list");
	}

	@Override
	public void add(Foot item) {
		sql.insert("foot.add", item);
	}

	@Override
	public void delete(String custid) {
		sql.delete("foot.delete", custid);
	}

	@Override
	public Foot item(String custid) {
		return sql.selectOne("foot.item", custid);	}

	@Override
	public void update(Foot item) {
		sql.update("foot.update", item);
	}

}
