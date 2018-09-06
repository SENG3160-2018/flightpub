package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Price;
import com.flightpub.base.model.Price_;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * PriceDAOImpl
 *
 * DB query mappings for Prices table
 */
public class PriceDAOImpl implements PriceDAO {
    static EntityManager EM = Persistence.createEntityManagerFactory("FlightPub").createEntityManager();

    @Override
    public List<Price> getPrices() {
        CriteriaBuilder builder = EM.getCriteriaBuilder();
        CriteriaQuery<Price> criteria = builder.createQuery(Price.class);
        Root<Price> root = criteria.from(Price.class);
        criteria.select(root);

        return EM.createQuery(criteria).getResultList();
    }

    @Override
    public Price getPrice(String airlineCode, String classCode, String ticketCode, String flightNumber) {
        CriteriaBuilder builder = EM.getCriteriaBuilder();
        CriteriaQuery<Price> criteria = builder.createQuery(Price.class);
        Root<Price> root = criteria.from(Price.class);
        criteria.select(root);

        criteria.where(builder.equal(root.get(Price_.airlineCode), airlineCode));
        criteria.where(builder.equal(root.get(Price_.classCode), classCode));
        criteria.where(builder.equal(root.get(Price_.ticketCode), ticketCode));
        criteria.where(builder.equal(root.get(Price_.flightNumber), flightNumber));

        return EM.createQuery(criteria).getSingleResult();
    }
}
