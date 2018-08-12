package com.flightpub.flightSelection.actions;

import com.flightpub.base.model.Flights;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ResultsAction
 *
 * Handles all search requests, performs DB queries and returns results listing
 */
public class ResultsAction implements Action, ModelDriven, ServletContextAware, SessionAware {
    private List<Flights> flights = new ArrayList<Flights>();
    private List<Flights> recommendations = new ArrayList<Flights>();
    private ServletContext ctx;

    private String departureCity;
    private String arrivalCity;
    private String cabinClass;
    private Boolean arriveDayBefore;
    private Date departureDateTime;
    private Date arrivalDateTime;
    private Boolean directFlightsOnly;

    private String userType;
    private Map<String, Object> userSession ;

    public String execute() {
        // Get session and usertype
        HttpSession session = ServletActionContext.getRequest().getSession(false);
        if (session != null && session.getAttribute("USER_TYPE") != null) {
            userType = session.getAttribute("USER_TYPE").toString();
            userSession.put("USER_TYPE", userType);
        }

        // Setup DB
        /* Removed DB access as no other work was done on the database by the team

        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");

        // Query DB
        FlightsDAO flightDAO = new FlightsDAOImpl(sf);
        flights = flightDAO.getFlights(new ArrayList());

        if (flights.isEmpty()) {
            return ERROR;
        }

        // Get recommendations
        if (!userType.equals("business")) {
            // Query DB
            FlightsDAO recommendationsDAO = new FlightsDAOImpl(sf);
            recommendations = recommendationsDAO.getFlightRecommendations();
        }
        */

        return SUCCESS;
    }

    @Override
    public Object getModel() {
        return flights;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.ctx = servletContext;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    public Boolean getArriveDayBefore() {
        return arriveDayBefore;
    }

    public void setArriveDayBefore(Boolean arriveDayBefore) {
        this.arriveDayBefore = arriveDayBefore;
    }

    public Date getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(Date departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(Date arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public Boolean getDirectFlightsOnly() {
        return directFlightsOnly;
    }

    public void setDirectFlightsOnly(Boolean directFlightsOnly) {
        this.directFlightsOnly = directFlightsOnly;
    }

    public void setSession(Map<String, Object> session) {
        userSession = session ;
    }
}
