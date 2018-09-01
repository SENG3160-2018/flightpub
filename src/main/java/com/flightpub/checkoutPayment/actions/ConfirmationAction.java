package com.flightpub.checkoutPayment.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * ConfirmationAction
 *
 * Performs all transaction processing and delivers success or error view response
 */
public class ConfirmationAction extends ActionSupport {
    public String execute() {


        return SUCCESS;
    }
}
