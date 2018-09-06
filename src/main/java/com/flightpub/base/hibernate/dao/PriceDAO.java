package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Flights;
import com.flightpub.base.model.Price;

import java.util.List;

/**
 * PriceDAO
 *
 * Consumed be PriceDAOImpl
 */
public interface PriceDAO {

    List<Price> getPrices();
    Price getPrice(Flights flight, String classCode, String ticketCode);
}
