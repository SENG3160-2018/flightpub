package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Destination;
import com.flightpub.base.model.TicketType;
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
public class TicketTypesDAOImpl implements TicketTypesDAO {

    private SessionFactory sf;

    public TicketTypesDAOImpl(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public List<TicketType> getTicketTypes() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from TicketType ");

        List<TicketType> dstList = query.list();
        if (!dstList.isEmpty()) {
            System.out.println("Ticket Types Retrieved from DB.");
        }
        tx.commit();
        session.close();

        return dstList;
    }
}
