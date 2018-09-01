package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.TicketClass;

import java.util.List;

/**
 * FlightsDAO
 *
 * Consumed be FlightsDAOImpl
 */
public interface TicketClassesDAO {

    List<TicketClass> getTicketClasses();
}
