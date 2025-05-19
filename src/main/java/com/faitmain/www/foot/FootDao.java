package com.faitmain.www.foot;

import java.util.List;

import com.faitmain.www.model.Foot;

public interface FootDao {

	List<Foot> list();

	void add(Foot item);

	void delete(String custid);

	Foot item(String custid);

	void update(Foot item);

}
