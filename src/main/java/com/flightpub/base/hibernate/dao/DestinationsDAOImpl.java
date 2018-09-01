package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Destination;
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
public class DestinationsDAOImpl implements DestinationsDAO {

    private SessionFactory sf;

    public DestinationsDAOImpl(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public List<Destination> getDestinations() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Destination ");

        List<Destination> dstList = query.list();
        System.out.println(dstList.toString());
        if (!dstList.isEmpty()) {
            System.out.println("Destinations Retrieved from DB.");
        }
        tx.commit();
        session.close();

        return dstList;
    }
}
