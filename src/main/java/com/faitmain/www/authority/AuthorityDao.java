package com.faitmain.www.authority;

import java.util.List;

import com.faitmain.www.model.Authority;

public interface AuthorityDao {
	
	List<Authority> list();

	void add(Authority item);

	Authority item(Long code);

	void update(Authority item);

	void delete(Long code);
}
