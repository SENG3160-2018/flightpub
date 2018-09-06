package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Review;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * FlightsDAOImpl
 *
 * DB query mappings for Flights table
 */
public class ReviewsDAOImpl implements ReviewsDAO {
    static EntityManager EM = Persistence.createEntityManagerFactory("FlightPub").createEntityManager();

    @Override
    public List<Review> getReviews() {
        CriteriaBuilder builder = EM.getCriteriaBuilder();
        CriteriaQuery<Review> criteria = builder.createQuery(Review.class);
        Root<Review> root = criteria.from(Review.class);
        criteria.select(root);

        return EM.createQuery(criteria).getResultList();
    }

    @Override
    public boolean saveReview(Review review) {
        try {
            EM.persist(review);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
