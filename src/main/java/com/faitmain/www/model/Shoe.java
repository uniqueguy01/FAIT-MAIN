package com.faitmain.www.model;

import java.util.List;

public class Shoe {

	private Long id;
	private Long storeId;
	private String name;
	private int price;
	private String detail;
	private String category;
	private List<ShoeImg> shoeImg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<ShoeImg> getShoeImg() {
		return shoeImg;
	}

	public void setShoeImg(List<ShoeImg> shoeImg) {
		this.shoeImg = shoeImg;
	}

}
