package com.faitmain.www.model;

import java.util.List;

public class Store {
	private Long id;
	private String custId;
	private String ceonum;
	private String name;
	private String address;
	private String notice;
	private List<StoreImg> storeImg;
	private List<Maker> maker;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCeonum() {
		return ceonum;
	}

	public void setCeonum(String ceonum) {
		this.ceonum = ceonum;
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

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
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
