package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Flights;
import com.flightpub.base.model.Flights_;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * FlightsDAOImpl
 *
 * DB query mappings for Flights table
 */
public class FlightsDAOImpl implements FlightsDAO {
    static EntityManager EM = Persistence.createEntityManagerFactory("FlightPub").createEntityManager();

    @Override
    public Flights getFlight(int id) {
        CriteriaBuilder builder = EM.getCriteriaBuilder();
        CriteriaQuery<Flights> criteria = builder.createQuery(Flights.class);
        Root<Flights> root = criteria.from(Flights.class);
        criteria.select(root);

        criteria.where(builder.equal(root.get(Flights_.id), id));

        return EM.createQuery(criteria).getSingleResult();
    }

    @Override
    public List<Flights> getFlights(HashMap params, HashMap dates) {
        CriteriaBuilder builder = EM.getCriteriaBuilder();
        CriteriaQuery<Flights> criteria = builder.createQuery(Flights.class);
        Root<Flights> root = criteria.from(Flights.class);
        criteria.select(root);

        Iterator it = params.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();

            if (pair.getKey().equals("directFlightsOnly")) {
                criteria.where(builder.isNull(root.get(Flights_.stopOverCode)));
            } else if (pair.getKey().equals("departureCode")) {
                criteria.where(builder.equal(root.get(Flights_.departure), pair.getValue()));
            } else if (pair.getKey().equals("arrivalCode")) {
                criteria.where(builder.equal(root.get(Flights_.destination), pair.getValue()));
            } else if (pair.getKey().equals("carrier")) {
                criteria.where(builder.equal(root.get(Flights_.airlineCode), pair.getValue()));
            }

            it.remove(); // avoids a ConcurrentModificationException
        }

        Iterator its = dates.entrySet().iterator();
        while (its.hasNext()) {
            Map.Entry pair = (Map.Entry)its.next();
            if (pair.getKey().equals("date")) {
                criteria.where(builder.equal(root.get(Flights_.departureTime), pair.getValue()));
            }

            its.remove(); // avoids a ConcurrentModificationException
        }

        return EM.createQuery(criteria).getResultList();
    }
}
