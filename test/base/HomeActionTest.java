package base;

import com.flightpub.base.actions.HomeAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsTestCase;
import org.apache.struts2.dispatcher.mapper.ActionMapping;

public class HomeActionTest extends StrutsTestCase {
    public void testGetActionMapping() {
        ActionMapping mapping = getActionMapping("/home.action");
        assertNotNull(mapping);
        assertEquals("/", mapping.getNamespace());
        assertEquals("home", mapping.getName());
    }

    public void testGetActionProxy() throws Exception {
        ActionProxy proxy = getActionProxy("/home.action");
        assertNotNull(proxy);

        HomeAction action = (HomeAction) proxy.getAction();
        assertNotNull(action);

        String result = proxy.execute();
        assertEquals(Action.SUCCESS, result);
    }
}
