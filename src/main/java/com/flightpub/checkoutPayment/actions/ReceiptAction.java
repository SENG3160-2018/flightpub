package com.flightpub.checkoutPayment.actions;

import com.flightpub.base.hibernate.listener.HibernateListener;
import com.flightpub.base.model.Flights;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReceiptAction extends ActionSupport implements SessionAware {

    private String name;
    private String email;
    private List<Flights> cart;
    private Map<String, Object> userSession;

    public String execute() {
        System.out.println("Sending the receipt");

        SessionFactory sessionFactory =
                (SessionFactory) ServletActionContext.getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);

        if (userSession.containsKey("CART")) {
            cart = (ArrayList<Flights>) userSession.get("CART");
        } else {
            cart = new ArrayList<Flights>();
        }

        /* Access all the flights. (How to access flights in the cart) */
        for (Flights f : cart) {
            System.out.println(f.getDepartureTime());
            System.out.println(f.getAirlineCode());
        }
        System.out.println(name);
        System.out.println(email);

        /* Send the email */
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Flights> getCart() {
        return cart;
    }

    public void setCart(List<Flights> cart) {
        this.cart = cart;
    }

    public Map<String, Object> getUserSession() {
        return userSession;
    }

    public void setUserSession(Map<String, Object> userSession) {
        this.userSession = userSession;
    }
}
