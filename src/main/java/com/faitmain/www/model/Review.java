package com.faitmain.www.model;

import java.util.Date;
import java.util.List;

public class Review {

	private Long id;
	private Long storeId;
	private String custId;
	private int rating;
	private String content;
	private Date regDate;
	private List<ReviewImg> reviewImg;

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

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public List<ReviewImg> getReviewImg() {
		return reviewImg;
	}

	public void setReviewImg(List<ReviewImg> reviewImg) {
		this.reviewImg = reviewImg;
	}

}
