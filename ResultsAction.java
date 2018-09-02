package com.flightpub.flightSelection.actions;

import com.flightpub.base.hibernate.dao.FlightsDAO;
import com.flightpub.base.hibernate.dao.FlightsDAOImpl;
import com.flightpub.base.hibernate.listener.HibernateListener;
import com.flightpub.base.model.Flights;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ResultsAction extends ActionSupport implements ModelDriven, ServletContextAware, SessionAware {
    public List<String> params;
    private List<Flights> flights = new ArrayList<Flights>();
    private ServletContext ctx;
    private String userType;
    private Map<String, Object> userSession;
    private String departureCode;
    private String destinationCode;
//    private String details;
//    private String name;
//    private Timestamp departureTime;
//    private Timestamp arrivalTime;
//    private boolean directFlightsOnly;
//    private boolean arriveDayBefore;

    public ResultsAction() {

        params = getParams();
        setParams(params);

    }

    public String execute() {

        HttpSession session = ServletActionContext.getRequest().getSession(false);
        if (session != null && session.getAttribute("USER_TYPE") != null) {
            userType = session.getAttribute("USER_TYPE").toString();
            userSession.put("USER_TYPE", userType);
        }

        SessionFactory sessionFactory =
                (SessionFactory) ServletActionContext.getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);

        params = new ArrayList<String>();
        params.add(departureCode);
        params.add(destinationCode);

        System.out.println(params);

        FlightsDAO flightDAO = new FlightsDAOImpl(sessionFactory);
        flights = flightDAO.getFlights(new ArrayList());
        if (flights.isEmpty()) {
            return "error";
        }
        return "success";
    }
    @Override
    public Object getModel() {
        return flights;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.ctx = servletContext;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
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

    public List<Flights> getFlights() {
        return flights;
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
//    public String getDetails() {
//        return details;
//    }
//
//    public void setDetails(String details) {
//        this.details = details;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Date getDepartureTime() {
//        return departureTime;
//    }
//
//    public void setDepartureTime(Date departureTime) {
//        this.departureTime = departureTime;
//    }
//
//    public Date getArrivalTime() {
//        return arrivalTime;
//    }
//
//    public void setArrivalTime(Date arrivalTime) {
//        this.arrivalTime = arrivalTime;
//    }
//
//    public boolean isDirectFlightsOnly() {
//        return directFlightsOnly;
//    }
//
//    public void setDirectFlightsOnly(boolean directFlightsOnly) {
//        this.directFlightsOnly = directFlightsOnly;
//    }
//
//    public boolean isArriveDayBefore() {
//        return arriveDayBefore;
//    }
//
//    public void setArriveDayBefore(boolean arriveDayBefore) {
//        this.arriveDayBefore = arriveDayBefore;
//    }

    public void setFlights(List<Flights> flights) {
        this.flights = flights;
    }
}