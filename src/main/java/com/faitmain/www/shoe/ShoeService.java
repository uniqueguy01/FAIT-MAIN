package com.faitmain.www.shoe;

import java.util.List;

import com.faitmain.www.model.Shoe;

public interface ShoeService {

	List<Shoe> list();

	void add(Shoe item);

	void update(Shoe item);

	void delete(Long id);

}
