package com.faitmain.www.foot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faitmain.www.model.Foot;

@Service
public class FootServiceImpl implements FootService {
	
	@Autowired
	FootDao dao;

	@Override
	public List<Foot> list() {
		return dao.list();
	}

	@Override
	public void add(Foot item) {
		dao.add(item);
	}

	@Override
	public void delete(String custid) {
		dao.delete(custid);
	}

	@Override
	public Foot item(String custid) {
		return dao.item(custid);
	}

	@Override
	public void update(Foot item) {
		dao.update(item);
	}

}
