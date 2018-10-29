package com.flightpub.base.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ReviewTest {
    private Review review;

    @Before
    public void setUp() throws Exception {
        review = new Review();
    }

    @Test
    public void getId() {
        review.setId(1);
        assertEquals("ID is invalid.", 1, review.getId());
    }

    @Test
    public void getUiNavigation() {
        review.setUiNavigation("test");
        assertEquals("UiNavigation is invalid.", "test", review.getUiNavigation());
    }

    @Test
    public void getRating() {
        review.setRating(1);
        assertEquals("Rating is invalid.", 1, review.getRating());
    }

    @Test
    public void getSiteNavigation() {
        review.setSiteNavigation("test");
        assertEquals("Navigation is invalid.", "test", review.getSiteNavigation());
    }

    @Test
    public void getRecommendation() {
        review.setRecommendation("test");
        assertEquals("Recommendation is invalid.", "test", review.getRecommendation());
    }

    @Test
    public void getCreated() {
        Date date = new Date();
        review.setCreated(date);
        assertEquals("Created is invalid.", date, review.getCreated());
    }
}