package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.TicketType;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * FlightsDAOImpl
 *
 * DB query mappings for Flights table
 */
public class TicketTypesDAOImpl implements TicketTypesDAO {
    static EntityManager EM = Persistence.createEntityManagerFactory("FlightPub").createEntityManager();

    @Override
    public List<TicketType> getTicketTypes() {
        CriteriaBuilder builder = EM.getCriteriaBuilder();
        CriteriaQuery<TicketType> criteria = builder.createQuery(TicketType.class);
        Root<TicketType> root = criteria.from(TicketType.class);
        criteria.select(root);

        return EM.createQuery(criteria).getResultList();
    }
}
