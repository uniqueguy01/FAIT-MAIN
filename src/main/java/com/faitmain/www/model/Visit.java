package com.faitmain.www.model;

import java.security.Timestamp;
import java.util.Date;

public class Visit {
	
	private Long id;
	private int amount;
	private Timestamp reservation;
	private int saleprice;
	
	private String custid;
	private String ceonum;
	private Long shoeid;
	private Long orderid;
	
	
	
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getCeonum() {
		return ceonum;
	}
	public void setCeonum(String ceonum) {
		this.ceonum = ceonum;
	}
	public Long getShoeid() {
		return shoeid;
	}
	public void setShoeid(Long shoeid) {
		this.shoeid = shoeid;
	}
	public int getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
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
