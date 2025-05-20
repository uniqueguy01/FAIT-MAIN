package com.faitmain.www.shoe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faitmain.www.model.Shoe;
import com.faitmain.www.model.ShoeImg;

@Transactional
@Service
public class ShoeServiceImpl implements ShoeService {
	
	@Autowired
	ShoeDao dao;

	@Override
	public List<Shoe> list() {
		return dao.list();
	}

	@Override
	public void add(Shoe item) {
		dao.add(item);
		
		if(item.getShoeImg() != null) {
			for(ShoeImg shoeImg : item.getShoeImg()) {
				shoeImg.setShoeid(item.getId());
				dao.addShoeImg(shoeImg);
			}
		}
	}

	@Override
	public void update(Shoe item) {
		dao.update(item);
		
		if(item.getShoeImg() != null) {
			for(ShoeImg shoeImg : item.getShoeImg()) {
				shoeImg.setShoeid(item.getId());
				dao.addShoeImg(shoeImg);
			}
		}
	}

	@Override
	public void delete(Long id) {
		dao.deleteShoeImg(id);
		
		dao.delete(id);
	}

	@Override
	public Shoe item(Long id) {
		Shoe item = dao.item(id);
		return item;
	}

	@Override
	public ShoeImg itemShoeImg(Long id) {
		return dao.itemShoeImg(id);
	}

	@Override
	public void deleteShoeImg(Long id) {
		dao.deleteShoeImg(id);
	}

	@Override
	public List<Shoe> list(String ceonum) {
		return dao.list(ceonum);
	}

}
