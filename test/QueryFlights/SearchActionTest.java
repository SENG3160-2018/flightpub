package QueryFlights;

import com.flightpub.queryFlights.actions.SearchAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsTestCase;
import org.apache.struts2.dispatcher.mapper.ActionMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SearchActionTest extends StrutsTestCase {
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
        assertTrue("Destinations is empty.", !action.getAirlines().isEmpty());
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
}
