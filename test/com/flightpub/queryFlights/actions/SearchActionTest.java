package com.flightpub.queryFlights.actions;

import com.flightpub.base.model.*;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsTestCase;
import org.apache.struts2.dispatcher.mapper.ActionMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SearchActionTest extends StrutsTestCase {
    private SearchAction searchAction;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        searchAction = new SearchAction();
    }

    public void testGetActionMapping() {
        ActionMapping mapping = getActionMapping("/search.action");
        assertNotNull(mapping);
        assertEquals("/", mapping.getNamespace());
        assertEquals("search", mapping.getName());
    }

    public void testGetActionProxy() throws Exception {
        ActionProxy proxy = getActionProxy("/search.action");
        assertNotNull(proxy);

        SearchAction action = (SearchAction) proxy.getAction();
        assertNotNull(action);
    }

    public void testDisplayNoUserType() {
        ActionProxy proxy = getActionProxy("/search.action");
        SearchAction action = (SearchAction) proxy.getAction();
        String result = action.display();
        assertEquals(Action.ERROR, result);
    }

    public void testDisplay() {
        ActionProxy proxy = getActionProxy("/search.action");
        SearchAction action = (SearchAction) proxy.getAction();

        Map session = new HashMap();
        action.setSession(session);
        action.setUserType("business");

        String result = action.display();
        assertEquals(Action.SUCCESS, result);
        assertTrue("Destinations is empty.", !action.getDestinations().isEmpty());
        assertTrue("Ticket Types is empty.", !action.getTicketTypes().isEmpty());
        assertTrue("Ticket Classes is empty.", !action.getTicketClasses().isEmpty());
        assertTrue("Airlines is empty.", !action.getAirlines().isEmpty());
    }

    // Case 1. Business flight - no connecting
    public void testSearchBusinessFlightsWithoutStopovers() {
        // First test results that should appear
        ActionProxy proxy = getActionProxy("/search.action");
        SearchAction action = (SearchAction) proxy.getAction();
        Map session = new HashMap();
        action.setSession(session);

        action.setUserType("business");
        action.setDptCode("MEL");
        action.setDstCode("SYD");
        action.setTcktClass("ECO");
        action.setTcktType("F");
        try {
            action.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("23/09/2017"));
        } catch (ParseException e) {
            // Invalid date
        }
        action.setDirectFlightsOnly(true);
        action.setStopOvers(-1);
        action.setPassengers(-1);

        String result = action.execute();
        assertTrue("Available flights are empty when some should be shown.", !action.getFlights().isEmpty());
        assertEquals(Action.SUCCESS, result);

        // Test params that shouldn't return flights
        action.setDptCode("GIG");
        action.setDstCode("ATL");
        action.setTcktClass("BUS");
        action.setTcktType("A");
        try {
            action.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("23/09/2017"));
        } catch (ParseException e) {
            // Invalid date
        }
        action.setDirectFlightsOnly(true);
        action.setStopOvers(-1);
        action.setPassengers(-1);

        result = action.execute();
        assertTrue("Available flights are returned when should be empty.", action.getFlights().isEmpty());
        assertEquals(Action.SUCCESS, result);
    }

    // Case 2. Business flight - with connecting
    public void testSearchBusinessFlightsWithStopovers() {
        ActionProxy proxy = getActionProxy("/search.action");
        SearchAction action = (SearchAction) proxy.getAction();
        Map session = new HashMap();
        action.setSession(session);

        action.setUserType("business");
        action.setTcktClass("BUS");
        action.setTcktType("A");
        try {
            action.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2018"));
        } catch (ParseException e) {
            // Invalid date
        }
        action.setDirectFlightsOnly(false);
        action.setStopOvers(-1);
        action.setPassengers(1);

        // Case 1: Destination == first stopover
        action.setDptCode("GIG");
        action.setDstCode("JFK");
        String result = action.execute();
        assertTrue("Available flights are empty when some should be shown.", !action.getFlights().isEmpty());
        assertEquals(Action.SUCCESS, result);

        // Case 2: Destination == first destination but flight has stopover
        action.setDptCode("GIG");
        action.setDstCode("ATL");
        result = action.execute();
        assertTrue("Available flights are empty when some should be shown.", !action.getFlights().isEmpty());
        assertEquals(Action.SUCCESS, result);

        // Case 3: Destination == first destination with no stopover
        action.setDptCode("HEL");
        action.setDstCode("FCO");
        result = action.execute();
        assertTrue("Available flights are empty when some should be shown.", !action.getFlights().isEmpty());
        assertEquals(Action.SUCCESS, result);

        // Case 4: Destination == second flights stopover, and first flight has a stopover
        action.setDptCode("GIG");
        action.setDstCode("MIA");
        result = action.execute();
        assertTrue("Available flights are empty when some should be shown.", !action.getFlights().isEmpty());
        assertEquals(Action.SUCCESS, result);

        // Case 5: Destination == second flight stopover, and first flight has no stopover
        action.setDptCode("FCO");
        action.setDstCode("SIN");
        result = action.execute();
        assertTrue("Available flights are empty when some should be shown.", !action.getFlights().isEmpty());
        assertEquals(Action.SUCCESS, result);

        // Case 6: Destination == second flight destination and both flights have stopovers
        action.setDptCode("HEL");
        action.setDstCode("MUC");
        result = action.execute();
        assertTrue("Available flights are empty when some should be shown.", !action.getFlights().isEmpty());
        assertEquals(Action.SUCCESS, result);

        // Case 7: Destination == second flight destination and only 1 of the flights has a stopover
        action.setDptCode("MEL");
        action.setDstCode("ORY");
        result = action.execute();
        assertTrue("Available flights are empty when some should be shown.", !action.getFlights().isEmpty());
        assertEquals(Action.SUCCESS, result);

        // Case 8: Destination == second flight destination and no flights have stopovers
        action.setDptCode("ADL");
        action.setDstCode("SYD");
        result = action.execute();
        assertTrue("Available flights are empty when some should be shown.", !action.getFlights().isEmpty());
        assertEquals(Action.SUCCESS, result);
    }

    // Case 3. Business flight - no results
    public void testSearchNullResults() {
        ActionProxy proxy = getActionProxy("/search.action");
        SearchAction action = (SearchAction) proxy.getAction();
        Map session = new HashMap();
        action.setSession(session);

        action.setUserType("business");
        action.setDptCode("MEL");
        action.setDstCode("SYD");
        action.setTcktClass("ECO");
        action.setTcktType("F");
        try {
            action.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/09/2017"));
        } catch (ParseException e) {
            // Invalid date
        }
        action.setDirectFlightsOnly(true);
        action.setStopOvers(-1);
        action.setPassengers(-1);

        String result = action.execute();
        assertTrue("Available flights are returned when should be empty.", action.getFlights().isEmpty());
        assertEquals(Action.SUCCESS, result);

        try {
            action.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/09/2020"));
        } catch (ParseException e) {
            // Invalid date
        }
        result = action.execute();
        assertTrue("Available flights are returned when should be empty.", action.getFlights().isEmpty());
        assertEquals(Action.SUCCESS, result);
    }

    // Case 4. Couple flight
    public void testSearchCoupleFlights() {
        // First test results that should appear
        ActionProxy proxy = getActionProxy("/search.action");
        SearchAction action = (SearchAction) proxy.getAction();
        Map session = new HashMap();
        action.setSession(session);

        action.setUserType("couple");
        action.setDptCode("MEL");
        action.setDstCode("SYD");
        action.setTcktClass("ECO");
        action.setTcktType("F");
        try {
            action.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("23/09/2017"));
        } catch (ParseException e) {
            // Invalid date
        }
        action.setDirectFlightsOnly(true);
        action.setStopOvers(-1);
        action.setPassengers(2);

        String result = action.execute();
        assertTrue("Available flights are empty when some should be shown.", !action.getFlights().isEmpty());
        assertEquals(Action.SUCCESS, result);
    }

    // Case 5. Group flight


    public void testFlightAvailabilities() {
        ActionProxy proxy = getActionProxy("/search.action");
        SearchAction action = (SearchAction) proxy.getAction();
        Map session = new HashMap();
        action.setSession(session);

        action.setUserType("couple");
        action.setDptCode("MEL");
        action.setDstCode("SYD");
        action.setTcktClass("ECO");
        action.setTcktType("F");
        try {
            action.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("23/09/2017"));
        } catch (ParseException e) {
            // Invalid date
        }
        action.setDirectFlightsOnly(false);
        action.setStopOvers(-1);
        action.setPassengers(10);

        // Note - only 2 seats available for this leg.
        String result = action.execute();
        assertTrue("Available flights are shown when all should be unavailable.", action.getFlights().isEmpty());
        assertEquals(Action.SUCCESS, result);

        action.setPassengers(2);
        result = action.execute();
        assertTrue("Available flights are not when they should be available.", !action.getFlights().isEmpty());
        assertEquals(Action.SUCCESS, result);

        action.setDptCode("HNL");
        action.setDstCode("HKG");
        action.setTcktClass("BUS");
        action.setTcktType("A");
        try {
            action.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("26/09/2017"));
        } catch (ParseException e) {
            // Invalid date
        }
        result = action.execute();
        assertTrue("Available flights are not when they should be available.", !action.getFlights().isEmpty());
        assertEquals(Action.SUCCESS, result);
    }

    public void testPriceAvailabilities() {
        ActionProxy proxy = getActionProxy("/search.action");
        SearchAction action = (SearchAction) proxy.getAction();
        Map session = new HashMap();
        action.setSession(session);

        action.setUserType("business");
        action.setDptCode("CBR");
        action.setDstCode("OOL");
        action.setTcktClass("BUS");
        action.setTcktType("A");
        try {
            action.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("30/09/2017"));
        } catch (ParseException e) {
            // Invalid date
        }
        action.setDirectFlightsOnly(false);
        action.setStopOvers(-1);
        action.setPassengers(1);

        // Flight cost is $479
        action.setMinPrice(500);
        String result = action.execute();
        assertTrue("Available flights are shown when all should be unavailable.", action.getFlights().isEmpty());
        assertEquals(Action.SUCCESS, result);

        action.setMinPrice(0);
        action.setMaxPrice(450);
        result = action.execute();
        assertTrue("Available flights are shown when all should be unavailable.", action.getFlights().isEmpty());
        assertEquals(Action.SUCCESS, result);

        action.setMinPrice(400);
        action.setMaxPrice(500);
        result = action.execute();
        assertTrue("Available flights are not when they should be available.", !action.getFlights().isEmpty());
        assertEquals(Action.SUCCESS, result);
    }

    public void testGetTodayDate() {
        Date date = searchAction.getTodayDate();
        assertEquals(new Date().getDay(), date.getDay());
    }

    public void testSetSession() {
        Map<String, Object> session = new HashMap<String, Object>();
        searchAction.setSession(session);
        assertEquals(session, searchAction.getUserSession());
    }

    public void testGetUserType() {
        searchAction.setUserType("business");
        assertEquals("business", searchAction.getUserType());
    }

    public void testGetDestinations() {
        List<Destination> destinations = new ArrayList<Destination>();
        destinations.add(new Destination());
        searchAction.setDestinations(destinations);
        assertEquals(1, searchAction.getDestinations().size());
    }

    public void testGetTicketClasses() {
        List<TicketClass> ticketClasses = new ArrayList<TicketClass>();
        ticketClasses.add(new TicketClass());
        searchAction.setTicketClasses(ticketClasses);
        assertEquals(1, searchAction.getTicketClasses().size());
    }

    public void testGetTicketTypes() {
        List<TicketType> ticketTypes = new ArrayList<TicketType>();
        ticketTypes.add(new TicketType());
        searchAction.setTicketTypes(ticketTypes);
        assertEquals(1, searchAction.getTicketTypes().size());
    }

    public void testGetAirlines() {
        List<Airlines> airlines = new ArrayList<Airlines>();
        airlines.add(new Airlines());
        searchAction.setAirlines(airlines);
        assertEquals(1, searchAction.getAirlines().size());
    }

    public void testGetFlights() {
        List<Flights> flights = new ArrayList<Flights>();
        flights.add(new Flights());
        searchAction.setFlights(flights);
        assertEquals(1, searchAction.getFlights().size());
    }

    public void testGetDptCode() {
        searchAction.setDptCode("SYD");
        assertEquals("SYD", searchAction.getDptCode());
    }

    public void testGetUserSession() {
        Map<String, Object> session = new HashMap<String, Object>();
        searchAction.setUserSession(session);
        assertEquals(session, searchAction.getUserSession());
    }

    public void testGetDstCode() {
        searchAction.setDstCode("SYD");
        assertEquals("SYD", searchAction.getDstCode());
    }

    public void testGetTcktClass() {
        searchAction.setTcktClass("BUS");
        assertEquals("BUS", searchAction.getTcktClass());
    }

    public void testGetTcktType() {
        searchAction.setTcktType("A");
        assertEquals("A", searchAction.getTcktType());
    }

    public void testGetDate() {
        Date date = new Date();
        searchAction.setDate(date);
        assertEquals(date, searchAction.getDate());
    }

    public void testIsDirectFlightsOnly() {
        searchAction.setDirectFlightsOnly(true);
        assertTrue(searchAction.isDirectFlightsOnly());
    }

    public void testIsArriveDayBefore() {
        searchAction.setArriveDayBefore(true);
        assertTrue(searchAction.isArriveDayBefore());
    }

    public void testIsIncludeReturn() {
        searchAction.setIncludeReturn(true);
        assertTrue(searchAction.isIncludeReturn());
    }

    public void testIsMultiCity() {
        searchAction.setMultiCity(true);
        assertTrue(searchAction.isMultiCity());
    }

    public void testIsSurroundingDays() {
        searchAction.setSurroundingDays(true);
        assertTrue(searchAction.isSurroundingDays());
    }

    public void testGetMinPrice() {
        searchAction.setMinPrice(100);
        assertEquals(100, searchAction.getMinPrice());
    }

    public void testGetMaxPrice() {
        searchAction.setMaxPrice(2000);
        assertEquals(2000, searchAction.getMaxPrice());
    }

    public void testGetStopOvers() {
        searchAction.setStopOvers(1);
        assertEquals(1, searchAction.getStopOvers());
    }

    public void testGetPassengers() {
        searchAction.setPassengers(3);
        assertEquals(3, searchAction.getPassengers());
    }

    public void testIsSameFlight() {
        searchAction.setSameFlight(true);
        assertTrue(searchAction.isSameFlight());
    }

    public void testIsGroupDiscount() {
        searchAction.setGroupDiscount(true);
        assertTrue(searchAction.isGroupDiscount());
    }

    public void testGetCarrier() {
        searchAction.setCarrier("QTN");
        assertEquals("QTN", searchAction.getCarrier());
    }
}
