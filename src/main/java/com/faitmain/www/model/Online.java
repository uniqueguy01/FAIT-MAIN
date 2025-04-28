package com.faitmain.www.model;

import java.util.Date;

public class Online {
	
	private String custid;
	private String ceonum;
	private Long shoeid;
	private int saleprice;
	private int amount;
	private Date orderdate;
	
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
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
}
