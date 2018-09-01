package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Flights;
import com.flightpub.base.model.Review;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * FlightsDAOImpl
 *
 * DB query mappings for Flights table
 */
public class ReviewsDAOImpl implements ReviewsDAO {

    private SessionFactory sf;

    public ReviewsDAOImpl(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public List<Review> getReviews() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Reviews ");

        List<Review> fltList = query.list();
        if (!fltList.isEmpty()) {
            System.out.println("Reviews Retrieved from DB.");
        }
        tx.commit();
        session.close();

        return fltList;
    }

    @Override
    public boolean saveReview(Review review) {
        try {
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            session.save(review);

            tx.commit();
            session.close();

            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
