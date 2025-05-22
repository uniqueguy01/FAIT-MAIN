package com.faitmain.www.model;

public class ShoeImg {

	private Long id;
	private Long shoeId;
	private String filename;
	private String uuid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getShoeId() {
		return shoeId;
	}

	public void setShoeId(Long shoeId) {
		this.shoeId = shoeId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
