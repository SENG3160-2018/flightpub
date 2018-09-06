package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Flights;
import com.flightpub.base.model.Price;
import com.flightpub.base.model.Price_;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * PriceDAOImpl
 *
 * DB query mappings for Prices table
 */
public class PriceDAOImpl implements PriceDAO {
    static EntityManager EM = Persistence.createEntityManagerFactory("FlightPub").createEntityManager();
    final List<Predicate> predicates = new ArrayList<Predicate>();

    @Override
    public List<Price> getPrices() {
        CriteriaBuilder builder = EM.getCriteriaBuilder();
        CriteriaQuery<Price> criteria = builder.createQuery(Price.class);
        Root<Price> root = criteria.from(Price.class);
        criteria.select(root);

        return EM.createQuery(criteria).getResultList();
    }

    @Override
    public Price getPrice(Flights flight, String classCode, String ticketCode) {
        CriteriaBuilder builder = EM.getCriteriaBuilder();
        CriteriaQuery<Price> criteria = builder.createQuery(Price.class);
        Root<Price> root = criteria.from(Price.class);
        criteria.select(root);

        predicates.add(builder.equal(root.get(Price_.airlineCode), flight.getAirlineCode()));
        predicates.add(builder.equal(root.get(Price_.classCode), classCode));
        predicates.add(builder.equal(root.get(Price_.ticketCode), ticketCode));
        predicates.add(builder.equal(root.get(Price_.flightNumber), flight.getFlightNumber()));
        predicates.add(builder.lessThanOrEqualTo(root.get(Price_.startDate), flight.getDepartureTime()));
        predicates.add(builder.greaterThanOrEqualTo(root.get(Price_.endDate), flight.getDepartureTime()));

        return EM.createQuery(criteria.where(predicates.toArray(new Predicate[predicates.size()]))).setMaxResults(1).getSingleResult();
    }
}
