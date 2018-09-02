package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Destination;
import com.flightpub.base.model.Flights;

import java.util.List;

/**
 * FlightsDAO
 *
 * Consumed be FlightsDAOImpl
 */
public interface DestinationsDAO {

    List<Destination> getDestinations();
    Destination getDestination(String code);
}
