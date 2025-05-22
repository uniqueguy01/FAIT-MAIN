package com.faitmain.www.model;

public class Foot {

	private String id;
	private String custId;
	private Long footSize;
	private String shape;
	private String insole;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public Long getFootSize() {
		return footSize;
	}

	public void setFootSize(Long footSize) {
		this.footSize = footSize;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getInsole() {
		return insole;
	}

	public void setInsole(String insole) {
		this.insole = insole;
	}

}
