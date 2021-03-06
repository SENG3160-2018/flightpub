package com.flightpub.checkoutPayment.actions;

import com.flightpub.base.model.Flights;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

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
        // If business user then do not yet delete the cart as it is used to generate the email/receipt.
        if (!userSession.get("USER_TYPE").toString().equals("business")) {
            userSession.remove("CART");
        }
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
