package com.flightpub.base.actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ResultsAction
 *
 * Handles all search requests, performs DB queries and returns results listing
 */
public class HomeAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
