package com.faitmain.www.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faitmain.www.model.Review;
import com.faitmain.www.model.ReviewImg;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDao dao;
	
	@Override
	public void add(Review item) {
		dao.add(item);
		
		if(item.getReviewImg() != null) {
			for(ReviewImg reviewImg : item.getReviewImg()) {
				reviewImg.setReivewId(item.getId());
				dao.addReviewImg(reviewImg);
			}
		}
	}

}
