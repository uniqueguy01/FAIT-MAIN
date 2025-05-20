package com.faitmain.www.review;

import com.faitmain.www.model.Review;
import com.faitmain.www.model.ReviewImg;

public interface ReviewDao {

	void add(Review item);

	void addReviewImg(ReviewImg reviewImg);

}
