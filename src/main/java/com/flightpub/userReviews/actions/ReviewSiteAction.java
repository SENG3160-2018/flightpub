package com.flightpub.userReviews.actions;

import com.flightpub.base.hibernate.dao.ReviewsDAO;
import com.flightpub.base.hibernate.dao.ReviewsDAOImpl;
import com.flightpub.base.hibernate.listener.HibernateListener;
import com.flightpub.base.model.Review;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ReviewSiteAction
 *
 * Handles requests to site review
 */
public class ReviewSiteAction extends ActionSupport {
    private List<String> navigations;
    private List<Integer> ratings;
    private List<String> recommendations;

    private Review review;

    public ReviewSiteAction() {
        navigations = new ArrayList<String>();
        navigations.add("Very Easy");
        navigations.add("Easy");
        navigations.add("So so");
        navigations.add("Difficult");
        navigations.add("Where am I?");

        ratings = new ArrayList<Integer>();
        ratings.add(5);
        ratings.add(4);
        ratings.add(3);
        ratings.add(2);
        ratings.add(1);
        ratings.add(0);

        recommendations = new ArrayList<String>();
        recommendations.add("Absolutely");
        recommendations.add("Sure");
        recommendations.add("Not Sure");
        recommendations.add("Unlikely");
        recommendations.add("Never");
    }

    public List<String> getNavigations() {
        return navigations;
    }

    public void setNavigations(List<String> navigations) {
        this.navigations = navigations;
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(List<Integer> ratings) {
        this.ratings = ratings;
    }

    public List<String> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<String> recommendations) {
        this.recommendations = recommendations;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public String execute() {
        SessionFactory sessionFactory =
                (SessionFactory) ServletActionContext.getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);
        ReviewsDAO reviewsDAO = new ReviewsDAOImpl(sessionFactory);
        review.setCreated(new Date());
        reviewsDAO.saveReview(review);
        return SUCCESS;
    }
    public String display() {
        return SUCCESS;
    }
}
