package com.faitmain.www.model;

public class ShoeImg {

	private Long id;
	private Long shoeid;
	private String file;
	private String uuid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getShoeid() {
		return shoeid;
	}

	public void setShoeid(Long shoeid) {
		this.shoeid = shoeid;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
