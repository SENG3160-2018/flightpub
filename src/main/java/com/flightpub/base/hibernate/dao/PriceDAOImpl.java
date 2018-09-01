package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Airlines;
import com.flightpub.base.model.Price;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * PriceDAOImpl
 *
 * DB query mappings for Prices table
 */
public class PriceDAOImpl implements PriceDAO {

    private SessionFactory sf;

    public PriceDAOImpl(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public List<Price> getPrices() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Price ");

        List<Price> dstList = query.list();
        if (!dstList.isEmpty()) {
            System.out.println("Prices Retrieved from DB.");
        }
        tx.commit();
        session.close();

        return dstList;
    }

    @Override
    public Price getPrice(String airlineCode, String classCode, String ticketCode) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Price where AirlineCode=:airlineCode and ClassCode=:classCode and TicketCode=:ticketCode");
        query.setString("airlineCode", airlineCode);
        query.setString("classCode", classCode);
        query.setString("ticketCode", ticketCode);

        Price price = (Price) query.uniqueResult();
        tx.commit();
        session.close();

        return price;
    }
}
