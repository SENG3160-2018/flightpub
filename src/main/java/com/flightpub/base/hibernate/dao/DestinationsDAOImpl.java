package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Destination;
import com.flightpub.base.model.Destination_;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * DestinationsDAOImpl
 *
 * DB query mappings for Destinations table
 */
public class DestinationsDAOImpl implements DestinationsDAO {
    static EntityManager EM = Persistence.createEntityManagerFactory("FlightPub").createEntityManager();

    @Override
    public List<Destination> getDestinations() {
        CriteriaBuilder builder = EM.getCriteriaBuilder();
        CriteriaQuery<Destination> criteria = builder.createQuery(Destination.class);
        Root<Destination> root = criteria.from(Destination.class);
        criteria.select(root);

        return EM.createQuery(criteria).getResultList();
    }

    @Override
    public Destination getDestination(String code) {
        CriteriaBuilder builder = EM.getCriteriaBuilder();
        CriteriaQuery<Destination> criteria = builder.createQuery(Destination.class);
        Root<Destination> root = criteria.from(Destination.class);
        criteria.select(root);

        criteria.where(builder.equal(root.get(Destination_.destinationCode), code));

        Destination destination = EM.createQuery(criteria).setMaxResults(1).getSingleResult();

        return destination;
    }
}
