package com.flightpub.queryFlights.actions;

import com.flightpub.base.hibernate.dao.DestinationsDAO;
import com.flightpub.base.hibernate.dao.DestinationsDAOImpl;
import com.flightpub.base.hibernate.listener.HibernateListener;
import com.flightpub.base.model.Destination;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * SearchAction
 *
 * Handles requests to search page, using user type to deliver relevant views
 */
public class SearchAction extends ActionSupport implements SessionAware {

    private String userType;
    private Map<String, Object> userSession ;
    private List<Destination> destinations = new ArrayList<Destination>();

    public String execute() {
        userSession.put("USER_TYPE", userType);

        SessionFactory sessionFactory =
                (SessionFactory) ServletActionContext.getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);

        // Get destinations
        DestinationsDAO destinationsDAO = new DestinationsDAOImpl(sessionFactory);
        destinations = destinationsDAO.getDestinations();

        if (destinations.isEmpty()) {
            //return ERROR;
        }
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("destinations", destinations);

        // Get cabin classes

        // Get carriers

        return SUCCESS;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setSession(Map<String, Object> session) {
        userSession = session ;
    }
}
