package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Airlines;
import com.flightpub.base.model.Availability;

import java.util.Date;
import java.util.List;

/**
 * AirlinesDAO
 *
 * Consumed be FlightsDAOImpl
 */
public interface AvailabilityDAO {

    List<Availability> getAvailabilities();
    Availability getAvailability(String airlineCode, String flightNumber, Date departureTime, String classCode, String ticketType);
}
