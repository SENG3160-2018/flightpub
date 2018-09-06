package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.TicketClass;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * TicketClassesDAOImpl
 *
 * DB query mappings for TicketClasses table
 */
public class TicketClassesDAOImpl implements TicketClassesDAO {
    static EntityManager EM = Persistence.createEntityManagerFactory("FlightPub").createEntityManager();

    @Override
    public List<TicketClass> getTicketClasses() {
        CriteriaBuilder builder = EM.getCriteriaBuilder();
        CriteriaQuery<TicketClass> criteria = builder.createQuery(TicketClass.class);
        Root<TicketClass> root = criteria.from(TicketClass.class);
        criteria.select(root);

        return EM.createQuery(criteria).getResultList();
    }
}
