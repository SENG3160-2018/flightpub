package com.flightpub.queryFlights.actions;

import com.flightpub.base.hibernate.dao.*;
import com.flightpub.base.model.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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

    private String dptCode;
    private String dstCode;
    private String tcktClass;
    private String tcktType;
    private Date date;
    private boolean directFlightsOnly;
    private boolean arriveDayBefore;
    private boolean includeReturn;
    private boolean multiCity;
    private boolean surroundingDays;
    private int minPrice;
    private int maxPrice;
    private int stopOvers;
    private int passengers;
    private boolean sameFlight;
    private boolean groupDiscount;
    private String carrier;

    public SearchAction() {
        this.stopOvers = -1;
    }

    public String display() {
        userSession.put("USER_TYPE", userType);

        // Get destinations
        DestinationsDAO destinationsDAO = new DestinationsDAOImpl();
        this.destinations = destinationsDAO.getDestinations();

        // Get cabin classes
        TicketTypesDAO ticketTypesDAO = new TicketTypesDAOImpl();
        this.ticketTypes = ticketTypesDAO.getTicketTypes();

        TicketClassesDAO ticketClassesDAO = new TicketClassesDAOImpl();
        this.ticketClasses = ticketClassesDAO.getTicketClasses();

        // Get carriers
        AirlinesDAO airlinesDAO = new AirlinesDAOImpl();
        this.airlines = airlinesDAO.getAirlines();

        setDate(new Date());

        return SUCCESS;
    }

    public String execute() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        userType = userSession.get("USER_TYPE").toString();

        HashMap<String, String> params = new HashMap<String, String>();

        if (directFlightsOnly) {
            params.put("directFlightsOnly", "true");
        }
        if (arriveDayBefore) {
            params.put("arriveDayBefore", "true");
        }

        if (carrier != null && !carrier.isEmpty()) {
            params.put("carrier", carrier);
        }

        if (date != null) {
            params.put("date", df.format(date));
        }

        // For 0 stopovers, simply get flights
        FlightsDAO flightsDAO = new FlightsDAOImpl();
        if (stopOvers == 0 || directFlightsOnly) {
            params.put("departureCode", dptCode);
            params.put("arrivalCode", dstCode);
            flights = flightsDAO.getFlights(params);
        } else {
            // Get combinations of flights
            // Start by getting all flights matching departure location
            params.put("departureCode", dptCode);

            List<Flights> initialLeg = flightsDAO.getFlights(params);

            // Iterate flights
            for (Flights f : initialLeg) {
                if (f.getDestination().equals(dstCode)) {
                    flights.add(f);
                } else {
                    // Get all flights departing from f.destination and arriving in dstCode
                    HashMap<String, String> params2 = new HashMap<String, String>();
                    params2.put("departureCode", f.getDestination());
                    params2.put("arrivalCode", dstCode);
                    params2.put("date", df.format(f.getArrivalTime()));

                    List<Flights> secondLeg = flightsDAO.getFlights(params2);
                    // Iterate secondLeg and create combinations
                    for (Flights f2 : secondLeg) {
                        Flights newFlight = f;
                        newFlight.setConnectingFlight(f2);

                        flights.add(newFlight);
                    }
                }
            }
        }

        // Iterate flights and add pricing and availability
        PriceDAO priceDAO = new PriceDAOImpl();
        AvailabilityDAO availabilityDAO = new AvailabilityDAOImpl();
        List<Flights> toRemove = new ArrayList<Flights>();
        for (Flights f : flights) {
            f.setPrice(priceDAO.getPrice(f, tcktClass, tcktType));

            if (f.hasConnectingFlight()) {
                f.getConnectingFlight().setPrice(priceDAO.getPrice(f.getConnectingFlight(), tcktClass, tcktType));
            }

            // Get availability.  If not enough seats remove flight from results.  Else add availability to flight
            Availability availability = availabilityDAO.getAvailability(f.getAirlineCode(), f.getFlightNumber(), f.getDepartureTime(), tcktClass, tcktType);
            if (passengers > availability.getSeatsLeg1() || (availability.getSeatsLeg2() > 0 && passengers > availability.getSeatsLeg2())) {
                toRemove.add(f);
            } else {
                if (f.hasConnectingFlight()) {
                    Availability connectingAvailability = availabilityDAO.getAvailability(f.getConnectingFlight().getAirlineCode(), f.getConnectingFlight().getFlightNumber(), f.getConnectingFlight().getDepartureTime(), tcktClass, tcktType);
                    if (passengers > connectingAvailability.getSeatsLeg1() || (connectingAvailability.getSeatsLeg2() > 0 && passengers > connectingAvailability.getSeatsLeg2())) {
                        toRemove.add(f);
                    } else {
                        f.setAvailability(availability);
                        f.getConnectingFlight().setAvailability(connectingAvailability);
                    }
                } else {
                    f.setAvailability(availability);
                }
            }

            // Calculate number of legs and price
            if (f.getStopOverCode().equals(dstCode)) {
                f.setTotalLegs(1);
                f.setTotalPrice(f.getPrice().getPrice1());
            } else if (f.getDestination().equals(dstCode)) {
                if (!f.getStopOverCode().equals("")) {
                    f.setTotalLegs(2);
                } else {
                    f.setTotalLegs(1);
                }
                f.setTotalPrice(f.getPrice().getPrice());
            } else if (f.hasConnectingFlight() && f.getConnectingFlight().getStopOverCode().equals(dstCode)) {
                if (!f.getStopOverCode().equals("")) {
                    f.setTotalLegs(3);
                } else {
                    f.setTotalLegs(2);
                }

                f.setTotalPrice(f.getPrice().getPrice() + f.getConnectingFlight().getPrice().getPrice1());
            } else {
                if (!f.getStopOverCode().equals("") && !f.getConnectingFlight().getStopOverCode().equals("")) {
                    f.setTotalLegs(4);
                } else if (!f.getStopOverCode().equals("") || !f.getConnectingFlight().getStopOverCode().equals("")) {
                    f.setTotalLegs(3);
                } else {
                    f.setTotalLegs(2);
                }
                f.setTotalPrice(f.getPrice().getPrice() + f.getConnectingFlight().getPrice().getPrice());
            }

            if (minPrice > 0 && f.getTotalPrice() < minPrice) {
                toRemove.add(f);
            }
            if (maxPrice > 0 && f.getTotalPrice() > maxPrice) {
                toRemove.add(f);
            }
        }

        for (Flights f : toRemove) {
            flights.remove(f);
        }

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

    public String getDptCode() {
        return dptCode;
    }

    public void setDptCode(String dptCode) {
        this.dptCode = dptCode;
    }

    public Map<String, Object> getUserSession() {
        return userSession;
    }

    public void setUserSession(Map<String, Object> userSession) {
        this.userSession = userSession;
    }

    public String getDstCode() {
        return dstCode;
    }

    public void setDstCode(String dstCode) {
        this.dstCode = dstCode;
    }

    public String getTcktClass() {
        return tcktClass;
    }

    public void setTcktClass(String tcktClass) {
        this.tcktClass = tcktClass;
    }

    public String getTcktType() {
        return tcktType;
    }

    public void setTcktType(String tcktType) {
        this.tcktType = tcktType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public boolean isIncludeReturn() {
        return includeReturn;
    }

    public void setIncludeReturn(boolean includeReturn) {
        this.includeReturn = includeReturn;
    }

    public boolean isMultiCity() {
        return multiCity;
    }

    public void setMultiCity(boolean multiCity) {
        this.multiCity = multiCity;
    }

    public boolean isSurroundingDays() {
        return surroundingDays;
    }

    public void setSurroundingDays(boolean surroundingDays) {
        this.surroundingDays = surroundingDays;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getStopOvers() {
        return stopOvers;
    }

    public void setStopOvers(int stopOvers) {
        this.stopOvers = stopOvers;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public boolean isSameFlight() {
        return sameFlight;
    }

    public void setSameFlight(boolean sameFlight) {
        this.sameFlight = sameFlight;
    }

    public boolean isGroupDiscount() {
        return groupDiscount;
    }

    public void setGroupDiscount(boolean groupDiscount) {
        this.groupDiscount = groupDiscount;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
}
