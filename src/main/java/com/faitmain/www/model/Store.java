package com.faitmain.www.model;

import java.util.List;

public class Store {
	private String ceonum;
	private String custid;
	private String name;
	private String address;
	private List<StoreImg> storeImg;
	private List<Maker> maker;

	public String getCeonum() {
		return ceonum;
	}

	public void setCeonum(String ceonum) {
		this.ceonum = ceonum;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<StoreImg> getStoreImg() {
		return storeImg;
	}

	public void setStoreImg(List<StoreImg> storeImg) {
		this.storeImg = storeImg;
	}

	public List<Maker> getMaker() {
		return maker;
	}

	public void setMaker(List<Maker> maker) {
		this.maker = maker;
	}

}
