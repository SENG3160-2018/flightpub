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

/**
 * ConfirmationAction
 *
 * Performs all transaction processing and delivers success or error view response
 */
public class ConfirmationAction extends ActionSupport implements SessionAware {
    private List<Flights> cart;
    private Map<String, Object> userSession;

    public String execute() {
        userSession.remove("CART");
        return SUCCESS;
    }

    public String emailFriend() {
        userSession.remove("SHARE");
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session;
    }
}
