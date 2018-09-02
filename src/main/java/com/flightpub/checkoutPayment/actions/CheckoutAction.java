package com.flightpub.checkoutPayment.actions;

import com.flightpub.base.hibernate.dao.FlightsDAO;
import com.flightpub.base.hibernate.dao.FlightsDAOImpl;
import com.flightpub.base.hibernate.listener.HibernateListener;
import com.flightpub.base.model.Flights;
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
    private List<Flights> cart;
    private Map<String, Object> userSession ;

    public String execute() {

        return SUCCESS;
    }

    public String addToCart() {
        SessionFactory sessionFactory =
                (SessionFactory) ServletActionContext.getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);

        if (userSession.containsKey("cart")) {
            cart = (ArrayList<Flights>) userSession.get("CART");
        } else {
            cart = new ArrayList<Flights>();
        }
        // Get flight
        FlightsDAO flightsDAO = new FlightsDAOImpl(sessionFactory);
        Flights flight = flightsDAO.getFlight(flightId);

        cart.add(flight);
        userSession.put("CART", cart);

        return INPUT;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }
}
