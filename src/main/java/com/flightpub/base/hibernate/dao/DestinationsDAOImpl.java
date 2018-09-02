package com.flightpub.base.hibernate.dao;

import com.flightpub.base.hibernate.listener.HibernateListener;
import com.flightpub.base.model.Destination;
import com.flightpub.base.model.Flights;
import org.apache.struts2.ServletActionContext;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * FlightsDAOImpl
 *
 * DB query mappings for Flights table
 */
public class DestinationsDAOImpl implements DestinationsDAO {

    private SessionFactory sf;

    public DestinationsDAOImpl(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public List<Destination> getDestinations() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Destination ");

        List<Destination> dstList = query.list();
        System.out.println(dstList.toString());
        if (!dstList.isEmpty()) {
            System.out.println("Destinations Retrieved from DB.");
        }
        tx.commit();
        session.close();

        return dstList;
    }

    @Override
    public Destination getDestination(String code) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Criteria cr = session.createCriteria(Destination.class);
        cr.add(Restrictions.eq("DestinationCode", code));

        return (Destination) cr.uniqueResult();
    }
}
