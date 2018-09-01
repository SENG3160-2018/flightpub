package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Review;

import java.util.List;

/**
 * ReviewsDAO
 *
 * Consumed be ReviewsDAOImpl
 */
public interface ReviewsDAO {

    List<Review> getReviews();
    boolean saveReview(Review review);
}
