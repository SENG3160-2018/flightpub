package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Price;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

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
    public Price getPrice(String airlineCode, String classCode, String ticketCode, String flightNumber) {
        Session session = sf.openSession();

        Criteria cr = session.createCriteria(Price.class);

        cr.add(Restrictions.eq("airlineCode", airlineCode));
        cr.add(Restrictions.eq("classCode", classCode));
        cr.add(Restrictions.eq("ticketCode", ticketCode));
        cr.add(Restrictions.eq("flightNumber", flightNumber));

        Price price = (Price) cr.uniqueResult();

        return price;
    }
}
