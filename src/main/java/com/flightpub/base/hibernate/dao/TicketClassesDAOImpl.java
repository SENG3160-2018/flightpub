package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.TicketClass;
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
public class TicketClassesDAOImpl implements TicketClassesDAO {

    private SessionFactory sf;

    public TicketClassesDAOImpl(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public List<TicketClass> getTicketClasses() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from TicketClass ");

        List<TicketClass> dstList = query.list();
        if (!dstList.isEmpty()) {
            System.out.println("Ticket Classes Retrieved from DB.");
        }
        tx.commit();
        session.close();

        return dstList;
    }
}
