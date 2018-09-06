package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Availability;
import com.flightpub.base.model.Availability_;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Availability> getAvailabilities() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Availability> criteria = builder.createQuery(Availability.class);
        Root<Availability> root = criteria.from(Availability.class);
        criteria.select(root);

        return em.createQuery(criteria).getResultList();
    }

    @Override
    public Availability getAvailability(String airlineCode, String flightNumber, Date departureTime, String classCode, String ticketType) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Availability> criteria = builder.createQuery(Availability.class);
        Root<Availability> root = criteria.from(Availability.class);
        criteria.select(root);

        criteria.where(builder.equal(root.get(Availability_.airlineCode), airlineCode));
        criteria.where(builder.equal(root.get(Availability_.flightNumber), flightNumber));
        criteria.where(builder.equal(root.get(Availability_.departureTime), departureTime));
        criteria.where(builder.equal(root.get(Availability_.ticketClass), classCode));
        criteria.where(builder.equal(root.get(Availability_.ticketType), ticketType));

        Availability availability = em.createQuery(criteria).getSingleResult();

        return availability;
    }
}