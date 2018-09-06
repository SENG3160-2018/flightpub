package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Airlines;

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
public class AirlinesDAOImpl implements AirlinesDAO {
    static EntityManager EM = Persistence.createEntityManagerFactory("FlightPub").createEntityManager();

    @Override
    public List<Airlines> getAirlines() {
        CriteriaBuilder builder = EM.getCriteriaBuilder();
        CriteriaQuery<Airlines> criteria = builder.createQuery(Airlines.class);
        Root<Airlines> root = criteria.from(Airlines.class);
        criteria.select(root);

        return EM.createQuery(criteria).getResultList();
    }
}
