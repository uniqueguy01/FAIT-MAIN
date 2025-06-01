package com.faitmain.www.model;


public class Online {
	
	private Long id;
	private String storeId;	
	private Long ordersId;
	private Long shoeId;
	private int amount;
//	private String custid;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public Long getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(Long ordersId) {
		this.ordersId = ordersId;
	}
	public Long getShoeId() {
		return shoeId;
	}
	public void setShoeId(Long shoeId) {
		this.shoeId = shoeId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
