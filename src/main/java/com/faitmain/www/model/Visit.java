package com.faitmain.www.model;

import java.security.Timestamp;

public class Visit {
	
	private Long id;
	private Long storeId;
	private Long ordersId;
	private Long shoeId;
	private int amount;
	private Timestamp reservation;
//	private String custid;
	
	
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
	public Timestamp getReservation() {
		return reservation;
	}
	public void setReservation(Timestamp reservation) {
		this.reservation = reservation;
	}
	
}
