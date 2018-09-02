package com.flightpub.checkoutPayment.actions;

import com.flightpub.base.model.Flights;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.Map;

/**
 * ConfirmationAction
 *
 * Performs all transaction processing and delivers success or error view response
 */
public class ConfirmationAction extends ActionSupport implements SessionAware {
    private Map<String, Object> userSession;

    public String execute() {
        userSession.put("CART", new ArrayList<Flights>());

        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session;
    }
}
