package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Flights;
import com.flightpub.base.model.Flights_;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * FlightsDAOImpl
 *
 * DB query mappings for Flights table
 */
public class FlightsDAOImpl implements FlightsDAO {
    static EntityManager EM = Persistence.createEntityManagerFactory("FlightPub").createEntityManager();
    final List<Predicate> predicates = new ArrayList<Predicate>();

    @Override
    public Flights getFlight(int id) {
        CriteriaBuilder builder = EM.getCriteriaBuilder();
        CriteriaQuery<Flights> criteria = builder.createQuery(Flights.class);
        Root<Flights> root = criteria.from(Flights.class);
        criteria.select(root);

        criteria.where(builder.equal(root.get(Flights_.id), id));

        return EM.createQuery(criteria).getSingleResult();
    }

    @Override
    public List<Flights> getFlights(HashMap params) {
        CriteriaBuilder builder = EM.getCriteriaBuilder();
        CriteriaQuery<Flights> criteria = builder.createQuery(Flights.class);
        Root<Flights> root = criteria.from(Flights.class);
        criteria.select(root);

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Iterator it = params.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();

            if (pair.getKey().equals("directFlightsOnly")) {
                predicates.add(builder.isNull(root.get(Flights_.stopOverCode)));
            } else if (pair.getKey().equals("departureCode")) {
                predicates.add(builder.equal(root.get(Flights_.departure), pair.getValue()));
            } else if (pair.getKey().equals("arrivalCode")) {
                predicates.add(builder.equal(root.get(Flights_.destination), pair.getValue()));
            } else if (pair.getKey().equals("carrier")) {
                predicates.add(builder.equal(root.get(Flights_.airlineCode), pair.getValue()));
            } else if (pair.getKey().equals("date")) {
                try {
                    String start = pair.getValue().toString();
                    Calendar endDate = Calendar.getInstance();
                    endDate.setTime(df.parse(start));
                    endDate.add(Calendar.DAY_OF_MONTH, 1);

                    predicates.add(builder.between(root.get(Flights_.departureTime), df.parse(start), endDate.getTime()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        return EM.createQuery(criteria.where(predicates.toArray(new Predicate[predicates.size()]))).getResultList();
    }
}
