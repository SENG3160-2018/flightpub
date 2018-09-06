package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Flights;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.*;

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
    public Flights getFlight(int id) {
        Session session = sf.openSession();

        Criteria cr = session.createCriteria(Flights.class);
        cr.add(Restrictions.eq("id", id));

        return (Flights) cr.uniqueResult();
    }

    @Override
    public List<Flights> getFlights(HashMap params, HashMap dates) {
        Session session = sf.openSession();

        Criteria cr = session.createCriteria(Flights.class);

        Iterator it = params.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();

            if (pair.getKey().equals("directFlightsOnly")) {
                cr.add(Restrictions.isNull("stopOverCode"));
            } else if (pair.getKey().equals("departureCode")) {
                cr.add(Restrictions.eq("departure", pair.getValue()));
            } else if (pair.getKey().equals("arrivalCode")) {
                cr.add(Restrictions.eq("destination", pair.getValue()));
            } else if (pair.getKey().equals("carrier")) {
                cr.add(Restrictions.eq("airlineCode", pair.getValue()));
            }

            it.remove(); // avoids a ConcurrentModificationException
        }

        Iterator its = dates.entrySet().iterator();
        while (its.hasNext()) {
            Map.Entry pair = (Map.Entry)its.next();

            if (pair.getKey().equals("date")) {
                cr.add(Restrictions.eq("departureTime", pair.getValue()));
            }

            its.remove(); // avoids a ConcurrentModificationException
        }

        return cr.list();
    }
}
