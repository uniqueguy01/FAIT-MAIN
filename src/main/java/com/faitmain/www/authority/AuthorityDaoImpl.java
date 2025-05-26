package com.faitmain.www.authority;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.faitmain.www.model.Authority;

@Repository
public class AuthorityDaoImpl implements AuthorityDao {

	SqlSession sql;
	

	public AuthorityDaoImpl(SqlSession sql) {
		this.sql = sql;
	}

	@Override
	public List<Authority> list() {
		return sql.selectList("authority.list");
	}

	@Override
	public void add(Authority item) {
		sql.insert("authority.add", item);
	}

	@Override
	public Authority item(Long code) {
		return sql.selectOne("authority.item", code);
	}

	@Override
	public void update(Authority item) {
		sql.update("authority.update", item);
	}

	@Override
	public void delete(Long code) {
		sql.delete("authority.delete", code);
	}

}
