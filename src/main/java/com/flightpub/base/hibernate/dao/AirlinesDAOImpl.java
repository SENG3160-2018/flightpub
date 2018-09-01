package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Airlines;
import com.flightpub.base.model.Destination;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * FlightsDAOImpl
 *
 * DB query mappings for Flights table
 */
public class AirlinesDAOImpl implements AirlinesDAO {

    private SessionFactory sf;

    public AirlinesDAOImpl(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public List<Airlines> getAirlines() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Airlines ");

        List<Airlines> dstList = query.list();
        if (!dstList.isEmpty()) {
            System.out.println("Airlines Retrieved from DB.");
        }
        tx.commit();
        session.close();

        return dstList;
    }
}
