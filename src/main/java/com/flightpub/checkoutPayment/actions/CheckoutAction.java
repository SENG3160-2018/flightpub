package com.flightpub.checkoutPayment.actions;

import com.flightpub.base.hibernate.dao.FlightsDAO;
import com.flightpub.base.hibernate.dao.FlightsDAOImpl;
import com.flightpub.base.hibernate.dao.PriceDAO;
import com.flightpub.base.hibernate.dao.PriceDAOImpl;
import com.flightpub.base.model.Flights;
import com.flightpub.base.model.Price;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

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

    private List<Flights> flights;
    private List<Flights> cart;
    private List<Flights> share;
    private Map<String, Object> userSession;
    private String userType;
    private int passengers;

    private int flightCt;
    private int flightCt2;
    private int flightCt3;

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
        Price price = priceDAO.getPrice(flight, tcktClass, tcktType);

        flight.setPrice(price);

        int p = Integer.parseInt(userSession.get("PASSENGERS").toString());
        for (int i = 0; i < p; i++) {
            cart.add(flight);
        }

        userSession.put("CART", cart);

        return SUCCESS;
    }

    public String addToGroup() {
        userType = userSession.get("USER_TYPE").toString();
        String p = userSession.get("PASSENGERS").toString();
        passengers = Integer.parseInt(p);

        if (userSession.containsKey("CART")) {
            cart = (ArrayList<Flights>) userSession.get("CART");
            if (cart.size() == passengers){
                flights = (ArrayList<Flights>) userSession.get("FLIGHTS");
                addActionError("You can not add more flights than there are passengers travelling. Remove flights from cart or proceed to checkout.");
                return ERROR;
            }
        } else {
            cart = new ArrayList<Flights>();
        }
        // Get flight
        FlightsDAO flightsDAO = new FlightsDAOImpl();
        Flights flight = flightsDAO.getFlight(flightId);

        PriceDAO priceDAO = new PriceDAOImpl();
        Price price = priceDAO.getPrice(flight, tcktClass, tcktType);

        flight.setPrice(price);

        cart.add(flight);
        userSession.put("CART", cart);

        flights = (ArrayList<Flights>) userSession.get("FLIGHTS");
        addActionMessage("Flight added to cart! "+(passengers-cart.size())+" remaining.");
        return SUCCESS;
    }

    public String groupCheckout() {
        userType = userSession.get("USER_TYPE").toString();
        String p = userSession.get("PASSENGERS").toString();
        passengers = Integer.parseInt(p);

        if (userSession.containsKey("CART")) {
            cart = (ArrayList<Flights>) userSession.get("CART");
            if (cart.size()==passengers){
                userSession.get("CART");
                addActionMessage("Not purchasing on behalf of the group? Click the Share Flight button!");
                return SUCCESS;
            } else {
                flights = (ArrayList<Flights>) userSession.get("FLIGHTS");
                addActionError("You haven't added flights for every member travelling! "+(passengers-cart.size())+" remaining.");
                return ERROR;
            }

        } else {
            flights = (ArrayList<Flights>) userSession.get("FLIGHTS");
            addActionError("You haven't added any flights yet! "+(passengers-cart.size())+" remaining.");
            return ERROR;
        }
    }

    public String removeCart() {
        userType = userSession.get("USER_TYPE").toString();
        cart = (ArrayList<Flights>) userSession.get("CART");
        cart.remove(flightCt-1);
        userSession.put("CART", cart);
        flights = (ArrayList<Flights>) userSession.get("FLIGHTS");
        addActionMessage("Flight removed from cart!");
        return SUCCESS;
    }

    public String removeCartCO() {
        cart = (ArrayList<Flights>) userSession.get("CART");
        if (cart.size()==0){
            userType = userSession.get("USER_TYPE").toString();
            flights = (ArrayList<Flights>) userSession.get("FLIGHTS");
            addActionError("No more flights in cart!");
            return ERROR;
        } else {
            cart.remove(flightCt2-1);
            if (cart.size()==0){
                userType = userSession.get("USER_TYPE").toString();
                if (userSession.containsKey("SHARE")) {
                    userSession.remove("SHARE");
                }
                flights = (ArrayList<Flights>) userSession.get("FLIGHTS");
                addActionError("No more flights in cart!");
                return ERROR;
            } else {
                userSession.put("CART", cart);
                addActionMessage("Flight removed from cart!");
                return SUCCESS;
            }
        }
    }

    public String undo() {
        share = (ArrayList<Flights>) userSession.get("SHARE");
        cart = (ArrayList<Flights>) userSession.get("CART");
        userType = userSession.get("USER_TYPE").toString();
        String p = userSession.get("PASSENGERS").toString();
        passengers = Integer.parseInt(p);
        if (passengers == 1) {
            userSession.remove("SHARE");
            return SUCCESS;
        } else {
            cart.add(share.get(flightCt3));
            userSession.put("CART", cart);
            if (share.size() > 1) {
                share.remove(flightCt3);
                userSession.put("SHARE", share);
                return SUCCESS;
            } else {
                userSession.remove("SHARE");
                return SUCCESS;
            }
        }
    }

    public String share() {
        cart = (ArrayList<Flights>) userSession.get("CART");
        userType = userSession.get("USER_TYPE").toString();
        if (userSession.containsKey("SHARE")) {
            share = (ArrayList<Flights>) userSession.get("SHARE");
        } else {
            share = new ArrayList<Flights>();}
        if (cart.size()>1) {
            share.add(cart.get(flightCt2-1));
            userSession.put("SHARE", share);
            cart.remove(flightCt2-1);
            userSession.put("CART", cart);
            return SUCCESS;
        } else if (cart.size()==1) {
            if (share.size() == 0) {
                share.add(cart.get(flightCt2-1));
                userSession.put("SHARE", share);
                return SUCCESS;
            } else if (share.size() == cart.size()) {
                share.remove(0);
                share.add(cart.get(flightCt2-1));
                userSession.put("SHARE", cart);
                return SUCCESS;
            }
        }
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

    public List<Flights> getFlights() {
        return flights;
    }

    public void setFlights(List<Flights> flights) {
        this.flights = flights;
    }

    public List<Flights> getCart() {
        return cart;
    }

    public void setCart(List<Flights> cart) {
        this.cart = cart;
    }

    public List<Flights> getShare() {
        return share;
    }

    public void setShare(List<Flights> share) {
        this.share = share;
    }

    public Map<String, Object> getUserSession() {
        return userSession;
    }

    public void setUserSession(Map<String, Object> userSession) {
        this.userSession = userSession;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getFlightCt() {
        return flightCt;
    }

    public void setFlightCt(int flightCt) {
        this.flightCt = flightCt;
    }

    public int getFlightCt2() {
        return flightCt2;
    }

    public void setFlightCt2(int flightCt2) {
        this.flightCt2 = flightCt2;
    }

    public int getFlightCt3() {
        return flightCt3;
    }

    public void setFlightCt3(int flightCt3) {
        this.flightCt3 = flightCt3;
    }
}
