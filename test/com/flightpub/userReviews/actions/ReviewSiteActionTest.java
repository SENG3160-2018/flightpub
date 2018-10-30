package com.flightpub.userReviews.actions;

import com.flightpub.base.model.Review;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsTestCase;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class ReviewSiteActionTest extends StrutsTestCase {
    private ReviewSiteAction reviewSiteAction;
    private Review review;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        reviewSiteAction = new ReviewSiteAction();
        review = new Review();
        review.setUiNavigation("Very Easy");
        review.setRating(5);
        review.setSiteNavigation("Easy");
        review.setRecommendation("test");
        review.setCreated(new Date());
    }

    public void testGetActionMapping() {
        ActionMapping mapping = getActionMapping("/reviewsite.action");
        assertNotNull(mapping);
        assertEquals("/", mapping.getNamespace());
        assertEquals("reviewsite", mapping.getName());
    }

    public void testGetActionProxy() throws Exception {
        ActionProxy proxy = getActionProxy("/reviewsite.action");
        assertNotNull(proxy);

        reviewSiteAction = (ReviewSiteAction) proxy.getAction();
        assertNotNull(reviewSiteAction);
    }

    @Test
    public void testExecute() {
        ActionProxy proxy = getActionProxy("/reviewsite.action");
        reviewSiteAction = (ReviewSiteAction) proxy.getAction();

        reviewSiteAction.setReview(review);

        String result = reviewSiteAction.execute();

        assertEquals("test", reviewSiteAction.getReview().getRecommendation());
    }

    @Test
    public void testDisplay() {
        ActionProxy proxy = getActionProxy("/reviewsite.action");
        reviewSiteAction = (ReviewSiteAction) proxy.getAction();

        String result = reviewSiteAction.display();

        assertEquals(Action.SUCCESS, result);
        assertTrue("Navigations is empty.", !reviewSiteAction.getNavigations().isEmpty());
        assertTrue("Ratings is empty.", !reviewSiteAction.getRatings().isEmpty());
        assertTrue("Recommendations is empty.", !reviewSiteAction.getRecommendations().isEmpty());
    }

    @Test
    public void testGetNavigations() {
        List<String> navigations = new ArrayList<String>();
        navigations.add("test");

        reviewSiteAction.setNavigations(navigations);
        assertEquals("test", reviewSiteAction.getNavigations().get(0));
    }

    @Test
    public void testGetRatings() {
        List<Integer> ratings = new ArrayList<Integer>();
        ratings.add(99);

        reviewSiteAction.setRatings(ratings);
        assertEquals(99, reviewSiteAction.getRatings().get(0), 0);
    }

    @Test
    public void testGetRecommendations() {
        List<String> recommendations = new ArrayList<String>();
        recommendations.add("test");

        reviewSiteAction.setRecommendations(recommendations);
        assertEquals("test", reviewSiteAction.getRecommendations().get(0));
    }

    @Test
    public void testGetReview() {
        reviewSiteAction.setReview(review);
        assertEquals("test", reviewSiteAction.getReview().getRecommendation());
    }
}