package com.faitmain.www.model;

import java.util.Date;
import java.util.List;

public class Orders {
	private Long id;
	
	private String custId;
	private Long storeId;
	private Long shoeId;
	private Date ordersDate;
	
	private List<Visit> visit;
	private List<Online> online;
	
	
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
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public Long getShoeId() {
		return shoeId;
	}
	public void setShoeId(Long shoeId) {
		this.shoeId = shoeId;
	}
	public Date getOrdersDate() {
		return ordersDate;
	}
	public void setOrdersDate(Date ordersDate) {
		this.ordersDate = ordersDate;
	}
	public List<Visit> getVisit() {
		return visit;
	}
	public void setVisit(List<Visit> visit) {
		this.visit = visit;
	}
	public List<Online> getOnline() {
		return online;
	}
	public void setOnline(List<Online> online) {
		this.online = online;
	}
	
}
