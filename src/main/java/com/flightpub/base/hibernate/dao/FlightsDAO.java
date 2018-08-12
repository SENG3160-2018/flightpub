package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Flights;

import java.util.List;

/**
 * FlightsDAO
 *
 * Consumed be FlightsDAOImpl
 */
public interface FlightsDAO {

    Flights getFlightById(int id);

    List<Flights> getFlights(List params);

    List<Flights> getFlightRecommendations();
}
