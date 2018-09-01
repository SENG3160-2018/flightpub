package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Airlines;

import java.util.List;

/**
 * AirlinesDAO
 *
 * Consumed be FlightsDAOImpl
 */
public interface AirlinesDAO {

    List<Airlines> getAirlines();
}
