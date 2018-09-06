package com.flightpub.checkoutPayment.actions;

import com.flightpub.base.hibernate.dao.FlightsDAO;
import com.flightpub.base.hibernate.dao.FlightsDAOImpl;
import com.flightpub.base.hibernate.dao.PriceDAO;
import com.flightpub.base.hibernate.dao.PriceDAOImpl;
import com.flightpub.base.hibernate.listener.HibernateListener;
import com.flightpub.base.model.Flights;
import com.flightpub.base.model.Price;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * CheckoutAction
 *
 * Handles all requests to the checkout
 */
public class CheckoutAction extends ActionSupport implements SessionAware {
    private int flightId;
    private String airline;
    private String tcktClass;
    private String tcktType;
    private String flightNumber;

    private List<Flights> cart;
    private Map<String, Object> userSession;

    public String execute() {

        return SUCCESS;
    }

    public String addToCart() {
        if (userSession.containsKey("CART")) {
            cart = (ArrayList<Flights>) userSession.get("CART");
        } else {
            cart = new ArrayList<Flights>();
        }
        // Get flight
        FlightsDAO flightsDAO = new FlightsDAOImpl();
        Flights flight = flightsDAO.getFlight(flightId);

        PriceDAO priceDAO = new PriceDAOImpl();
        Price price = priceDAO.getPrice(airline, tcktClass, tcktType, flightNumber);

        flight.setPrice(price);

        cart.add(flight);
        userSession.put("CART", cart);

        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getTcktClass() {
        return tcktClass;
    }

    public void setTcktClass(String tcktClass) {
        this.tcktClass = tcktClass;
    }

    public String getTcktType() {
        return tcktType;
    }

    public void setTcktType(String tcktType) {
        this.tcktType = tcktType;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }
}
