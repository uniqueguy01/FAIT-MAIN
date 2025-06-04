package com.faitmain.www.shoe;

import java.util.List;

import com.faitmain.www.model.Shoe;
import com.faitmain.www.model.ShoeImg;

public interface ShoeService {

	List<Shoe> list();

	void add(Shoe item);

	void update(Shoe item);

	void delete(Long id);

	Shoe item(Long id);

	ShoeImg itemShoeImg(Long id);

	void deleteShoeImg(Long id);

	List<Shoe> list(Long id);
	
}
