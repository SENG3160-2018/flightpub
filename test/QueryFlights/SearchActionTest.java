package QueryFlights;

import com.flightpub.queryFlights.actions.SearchAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsTestCase;
import org.apache.struts2.dispatcher.mapper.ActionMapping;

import java.util.HashMap;
import java.util.Map;

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

    public void testSearchExecute() {

    }
}
