package QueryFlights;

import com.flightpub.base.model.Flights;
import com.flightpub.queryFlights.actions.SearchAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsTestCase;
import org.apache.struts2.dispatcher.mapper.ActionMapping;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SearchActionTest extends StrutsTestCase {
    public void testGetActionMapping() {
        ActionMapping mapping = getActionMapping("/search.action");
        assertNotNull(mapping);
        assertEquals("/search", mapping.getNamespace());
        assertEquals("search", mapping.getName());
    }

    public void testGetActionProxy() throws Exception {
        ActionProxy proxy = getActionProxy("/search.action");
        assertNotNull(proxy);

        SearchAction action = (SearchAction) proxy.getAction();
        assertNotNull(action);

        String result = proxy.execute();
        assertEquals(Action.SUCCESS, result);
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
    public void testSearchExecute() {
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
    }

    // Case 2. Business flight - with connecting

    // Case 3. Business flight - no results

    // Case 4. Couple flight

    // Case 5. Group flight
}
