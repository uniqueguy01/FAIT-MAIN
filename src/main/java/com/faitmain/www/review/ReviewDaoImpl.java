package com.faitmain.www.review;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.faitmain.www.model.Review;
import com.faitmain.www.model.ReviewImg;

public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public void add(Review item) {
		sql.insert("review.add", item);

	}

	@Override
	public void addReviewImg(ReviewImg reviewImg) {
		sql.insert("review.addReviewImg", reviewImg);

	}

}
