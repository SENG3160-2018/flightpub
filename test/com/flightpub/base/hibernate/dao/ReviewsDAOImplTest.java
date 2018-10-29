package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Review;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ReviewsDAOImplTest {
    private ReviewsDAO reviewsDAO;
    private Review review;

    @Before
    public void setUp() throws Exception {
        reviewsDAO = new ReviewsDAOImpl();
        review = new Review();
        review.setUiNavigation("Very Easy");
        review.setRating(5);
        review.setSiteNavigation("Easy");
        review.setRecommendation("Absolutely");
        review.setCreated(new Date());
    }

    @Test
    public void testGetReviews() {
        reviewsDAO.saveReview(review);

        List<Review> reviews = reviewsDAO.getReviews();

        assertTrue(reviews.size() > 0);
    }
}