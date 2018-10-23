package Checkout;

import com.flightpub.checkoutPayment.actions.CheckoutAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsTestCase;
import org.apache.struts2.dispatcher.mapper.ActionMapping;

import java.util.HashMap;
import java.util.Map;

public class CheckoutActionTest extends StrutsTestCase {
    public void testGetActionMapping() {
        ActionMapping mapping = getActionMapping("/checkout.action");
        assertNotNull(mapping);
        assertEquals("/", mapping.getNamespace());
        assertEquals("checkout", mapping.getName());
    }

    public void testGetActionProxy() throws Exception {
        ActionProxy proxy = getActionProxy("/checkout.action");
        assertNotNull(proxy);

        CheckoutAction action = (CheckoutAction) proxy.getAction();
        assertNotNull(action);
    }

    public void testExecute() {
        ActionProxy proxy = getActionProxy("/checkout.action");
        CheckoutAction action = (CheckoutAction) proxy.getAction();

        String result = action.execute();
        assertEquals(Action.SUCCESS, result);
    }

    public void testAddToCart() {
        ActionProxy proxy = getActionProxy("/checkout.action");
        CheckoutAction action = (CheckoutAction) proxy.getAction();

        Map session = new HashMap();
        session.put("PASSENGERS", 1);
        action.setSession(session);

        action.setFlightId(1);
        action.setTcktClass("BUS");
        action.setTcktType("A");

        String result = action.addToCart();
        assertEquals(Action.SUCCESS, result);
        assertTrue("Cart is empty.", !action.getCart().isEmpty());
    }
}
