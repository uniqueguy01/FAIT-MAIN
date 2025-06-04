package com.faitmain.www.model;

import java.util.Date;
import java.util.List;

public class Orders {
	private Long id;
	
	private String custid;
	private Long shoeid;
	private Date orderdate;
	
	private List<Visit> visit;
	private List<Online> online;
	

	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public List<Online> getOnline() {
		return online;
	}
	public void setOnline(List<Online> online) {
		this.online = online;
	}
	public List<Visit> getVisit() {
		return visit;
	}
	public void setVisit(List<Visit> visit) {
		this.visit = visit;
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
	
}
