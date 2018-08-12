package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Flights;
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
public class FlightsDAOImpl implements FlightsDAO {

    private SessionFactory sf;

    public FlightsDAOImpl(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public Flights getFlightById(int id) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Flights where id=:id");
        query.setInteger("id", id);

        Flights flight = (Flights) query.uniqueResult();
        if (flight != null) {
            System.out.println("Flight Retrieved from DB::" + flight);
        }
        tx.commit();
        session.close();

        return flight;
    }

    @Override
    public List<Flights> getFlights(List params) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Flights");

        List<Flights> fltList = query.list();
        if (!fltList.isEmpty()) {
            System.out.println("Flights Retrieved from DB.");
        }
        tx.commit();
        session.close();

        return fltList;
    }

    @Override
    public List<Flights> getFlightRecommendations() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Flights");
        query.setFirstResult(0);
        query.setMaxResults(2);

        List<Flights> fltList = query.list();
        if (!fltList.isEmpty()) {
            System.out.println("Flights Retrieved from DB.");
        }
        tx.commit();
        session.close();

        return fltList;
    }
}
