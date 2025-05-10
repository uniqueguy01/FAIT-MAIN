package com.faitmain.www.shoe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faitmain.www.model.Shoe;

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
	}

	@Override
	public void update(Shoe item) {
		dao.update(item);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

}
