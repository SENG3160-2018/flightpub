package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Price;

import java.util.List;

/**
 * PriceDAO
 *
 * Consumed be PriceDAOImpl
 */
public interface PriceDAO {

    List<Price> getPrices();
    Price getPrice(String airlineCode, String classCode, String ticketCode, String flightNumber);
}
