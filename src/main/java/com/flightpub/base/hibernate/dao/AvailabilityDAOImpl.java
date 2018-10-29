package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Availability;
import com.flightpub.base.model.Availability_;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

/**
 * AvailabilityDAOImpl
 *
 * DB query mappings for Availability table
 */
public class AvailabilityDAOImpl implements AvailabilityDAO {
    static EntityManager EM = Persistence.createEntityManagerFactory("FlightPub").createEntityManager();

    @Override
    public Availability getAvailability(String airlineCode, String flightNumber, Date departureTime, String classCode, String ticketType) {
        CriteriaBuilder builder = EM.getCriteriaBuilder();
        CriteriaQuery<Availability> criteria = builder.createQuery(Availability.class);
        Root<Availability> root = criteria.from(Availability.class);
        criteria.select(root);

        criteria.where(builder.equal(root.get(Availability_.airlineCode), airlineCode));
        criteria.where(builder.equal(root.get(Availability_.flightNumber), flightNumber));
        criteria.where(builder.equal(root.get(Availability_.departureTime), departureTime));
        criteria.where(builder.equal(root.get(Availability_.ticketClass), classCode));
        criteria.where(builder.equal(root.get(Availability_.ticketType), ticketType));

        Availability availability = EM.createQuery(criteria).setMaxResults(1).getSingleResult();

        return availability;
    }
}
