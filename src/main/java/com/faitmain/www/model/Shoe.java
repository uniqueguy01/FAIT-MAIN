package com.faitmain.www.model;

import java.util.List;

public class Shoe {

	private Long id;
	private String ceonum;
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
