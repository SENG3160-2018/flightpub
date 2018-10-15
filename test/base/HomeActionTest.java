package base;

import com.flightpub.base.actions.HomeAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsTestCase;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.junit.Test;

public class HomeActionTest extends StrutsTestCase {
    @Test
    public void testGetActionMapping() {
        ActionMapping mapping = getActionMapping("/home.action");
        assertNotNull(mapping);
        assertEquals("/", mapping.getNamespace());
        assertEquals("home", mapping.getName());
    }

    @Test
    public void testGetActionProxy() throws Exception {
        ActionProxy proxy = getActionProxy("/home.action");
        assertNotNull(proxy);

        HomeAction action = (HomeAction) proxy.getAction();
        assertNotNull(action);
    }

    @Test
    public void testExecuteAction() throws Exception {
        ActionProxy proxy = getActionProxy("/home.action");
        assertNotNull(proxy);

        String result = proxy.execute();
        assertEquals(Action.SUCCESS, result);
    }
}
