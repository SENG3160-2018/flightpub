package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Flights;

import java.util.HashMap;
import java.util.List;

/**
 * FlightsDAO
 *
 * Consumed be FlightsDAOImpl
 */
public interface FlightsDAO {
    Flights getFlight(int id);
    List<Flights> getFlights(HashMap params, HashMap dates);
}
