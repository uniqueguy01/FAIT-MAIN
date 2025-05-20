package com.faitmain.www.shoe;

import java.util.List;

import com.faitmain.www.model.Shoe;
import com.faitmain.www.model.ShoeImg;

public interface ShoeDao {

	List<Shoe> list();

	void add(Shoe item);

	void update(Shoe item);

	void delete(Long id);

	void addShoeImg(ShoeImg shoeImg);

	Shoe item(Long id);

	void deleteShoeImg(Long id);

	ShoeImg itemShoeImg(Long id);

	List<Shoe> list(String ceonum);

}
