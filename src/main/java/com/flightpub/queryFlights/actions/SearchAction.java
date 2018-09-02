package com.flightpub.queryFlights.actions;

import com.flightpub.base.hibernate.dao.*;
import com.flightpub.base.hibernate.listener.HibernateListener;
import com.flightpub.base.model.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Date;
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
    private List<TicketClass> ticketClasses = new ArrayList<TicketClass>();
    private List<TicketType> ticketTypes = new ArrayList<TicketType>();
    private List<Airlines> airlines = new ArrayList<Airlines>();

    private List<Flights> flights = new ArrayList<Flights>();

    private String departureCode;
    private String destinationCode;
    private String ticketClass;
    private String ticketType;
    private Date departureTime;
    private Date arrivalTime;
    private boolean directFlightsOnly;
    private boolean arriveDayBefore;

    public String display() {
        userSession.put("USER_TYPE", userType);

        SessionFactory sessionFactory =
                (SessionFactory) ServletActionContext.getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);

        // Get destinations
        DestinationsDAO destinationsDAO = new DestinationsDAOImpl(sessionFactory);
        this.destinations = destinationsDAO.getDestinations();

        // Get cabin classes
        TicketTypesDAO ticketTypesDAO = new TicketTypesDAOImpl(sessionFactory);
        this.ticketTypes = ticketTypesDAO.getTicketTypes();

        TicketClassesDAO ticketClassesDAO = new TicketClassesDAOImpl(sessionFactory);
        this.ticketClasses = ticketClassesDAO.getTicketClasses();

        // Get carriers
        AirlinesDAO airlinesDAO = new AirlinesDAOImpl(sessionFactory);
        this.airlines = airlinesDAO.getAirlines();

        this.directFlightsOnly = true;

        return NONE;
    }

    public String execute() {
        userType = userSession.get("USER_TYPE").toString();
        return SUCCESS;
    }

    public Date getTodayDate(){

        return new Date();
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session ;
    }

    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public List<TicketClass> getTicketClasses() {
        return ticketClasses;
    }

    public void setTicketClasses(List<TicketClass> ticketClasses) {
        this.ticketClasses = ticketClasses;
    }

    public List<TicketType> getTicketTypes() {
        return ticketTypes;
    }

    public void setTicketTypes(List<TicketType> ticketTypes) {
        this.ticketTypes = ticketTypes;
    }

    public List<Airlines> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<Airlines> airlines) {
        this.airlines = airlines;
    }

    public List<Flights> getFlights() {
        return flights;
    }

    public void setFlights(List<Flights> flights) {
        this.flights = flights;
    }

    public String getDepartureCode() {
        return departureCode;
    }

    public void setDepartureCode(String departureCode) {
        this.departureCode = departureCode;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public boolean isDirectFlightsOnly() {
        return directFlightsOnly;
    }

    public void setDirectFlightsOnly(boolean directFlightsOnly) {
        this.directFlightsOnly = directFlightsOnly;
    }

    public boolean isArriveDayBefore() {
        return arriveDayBefore;
    }

    public void setArriveDayBefore(boolean arriveDayBefore) {
        this.arriveDayBefore = arriveDayBefore;
    }
}
