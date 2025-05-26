package com.faitmain.www.authority;

import java.util.List;

import com.faitmain.www.model.Authority;

public class AuthorityServiceImpl implements AuthorityService {

	AuthorityDao dao;
	
	
	public AuthorityServiceImpl(AuthorityDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Authority> list() {
		return dao.list();
	}

	@Override
	public void add(Authority item) {
		dao.add(item);
	}

	@Override
	public Authority item(Long code) {
		return dao.item(code);
	}

	@Override
	public void update(Authority item) {
		dao.update(item);
	}

	@Override
	public void delete(Long code) {
		dao.delete(code);
	}
}
