package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Flights;
import com.flightpub.base.model.Flights_;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
    private EntityManager EM = Persistence.createEntityManagerFactory("FlightPub").createEntityManager();
    private List<Predicate> predicates;

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

        // Iterate to first find destination code
        String destination = "";
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (pair.getKey().equals("arrivalCode")) {
                destination = pair.getValue().toString();
            }
        }

        it = params.entrySet().iterator();
        predicates = new ArrayList<Predicate>();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();

            if (pair.getKey().equals("directFlightsOnly")) {
                Predicate stopOverIsDestination = builder.equal(root.get(Flights_.stopOverCode), destination);
                Predicate stopOverIsNull = builder.isNull(root.get(Flights_.stopOverCode));
                predicates.add(builder.or(stopOverIsDestination, stopOverIsNull));
            } else if (pair.getKey().equals("departureCode")) {
                predicates.add(builder.equal(root.get(Flights_.departure), pair.getValue()));
            } else if (pair.getKey().equals("arrivalCode")) {
                // Query flights where stopover OR destination is equal to param
                Predicate stopOver = builder.equal(root.get(Flights_.stopOverCode), pair.getValue());
                Predicate destinationPred = builder.equal(root.get(Flights_.destination), pair.getValue());
                predicates.add(builder.or(stopOver, destinationPred));
            } else if (pair.getKey().equals("carrier")) {
                predicates.add(builder.equal(root.get(Flights_.airlineCode), pair.getValue()));
            } else if (pair.getKey().equals("date")) {
                try {
                    String start = pair.getValue().toString();
                    Calendar endDate = Calendar.getInstance();
                    endDate.setTime(df.parse(start));
                    endDate.add(Calendar.DAY_OF_MONTH, 1);

                    Predicate before = builder.greaterThanOrEqualTo(root.get(Flights_.departureTime), df.parse(start));
                    Predicate after = builder.lessThanOrEqualTo(root.get(Flights_.departureTime), endDate.getTime());

                    predicates.add(before);
                    predicates.add(after);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        return EM.createQuery(criteria.where(predicates.toArray(new Predicate[predicates.size()]))).getResultList();
    }
}
