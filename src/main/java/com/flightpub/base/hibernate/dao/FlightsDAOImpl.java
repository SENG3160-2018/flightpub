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
    public List<Flights> getFlights() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // @TODO: this needs to receive params from the Action and iterate through them to add dynamic queries
        // https://www.baeldung.com/hibernate-criteria-queries
        Query query = session.createQuery("from Flights where destinationCode = :destinationCode and departureCode = :departureCode");
        query.setFirstResult(0);
        query.setMaxResults(20);

        // limiting the output to the first 10 flights in the database
        query.setFirstResult(0);
        query.setMaxResults(10);

        List<Flights> fltList = query.list();

        // Testing out some stuff with flightList printing out departure time
        for (Flights f : fltList) {
            System.out.println(f.getDepartureTime());
        }

        if (!fltList.isEmpty()) {
            System.out.println("Flights Retrieved from DB.");
        }
        tx.commit();
        session.close();

        return fltList;
    }

    /*@Override
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
    }*/
}
