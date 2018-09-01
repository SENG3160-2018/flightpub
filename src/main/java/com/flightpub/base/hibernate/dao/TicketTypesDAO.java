package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.TicketType;

import java.util.List;

/**
 * FlightsDAO
 *
 * Consumed be FlightsDAOImpl
 */
public interface TicketTypesDAO {

    List<TicketType> getTicketTypes();
}
