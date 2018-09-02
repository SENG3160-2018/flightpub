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
    public List<Flights> getFlights(List params) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println(params);
        Query query = session.createQuery("from Flights where destinationCode = :destinationCode");
        query.setFirstResult(0);
        query.setMaxResults(20);

        List<Flights> fltList = query.list();
        if (!fltList.isEmpty()) {
            System.out.println("Flights Retrieved from DB.");
        }
        tx.commit();
        session.close();

        return fltList;
    }
}
