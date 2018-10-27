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

    public void testAddToGroup() {
        //Case 1
        // Test params that should be added to cart
        ActionProxy proxy = getActionProxy("/checkout.action");
        CheckoutAction action = (CheckoutAction) proxy.getAction();

        Map session = new HashMap();
        session.put("USER_TYPE", "group");
        session.put("PASSENGERS", 1);
        action.setSession(session);

        action.setFlightId(1);
        action.setTcktClass("ECO");
        action.setTcktType("D");

        String result = action.addToGroup();
        assertEquals(Action.SUCCESS, result);
        assertTrue("Cart is empty.", !action.getCart().isEmpty());

        //Ensure user can not add more flights to cart than there is passengers flying
        action.setFlightId(1);
        action.setTcktClass("ECO");
        action.setTcktType("D");

        result = action.addToGroup();
        assertEquals(Action.ERROR, result);
        assertTrue("Flight was added to cart when it should not have been.", action.getCart().size()==1);
    }

    public void testGroupCheckout() {
//        Case 2 - Checking that enough flights have been selected for the group travelling
        ActionProxy proxy = getActionProxy("/checkout.action");
        CheckoutAction action = (CheckoutAction) proxy.getAction();

        Map session = new HashMap();
        session.put("USER_TYPE", "group");
        session.put("PASSENGERS", 2);
        action.setSession(session);

//        Selecting no flights
        String result = action.groupCheckout();
        assertEquals(Action.ERROR, result);

//        Selecting less flights than the number of passengers
        action.setFlightId(1);
        action.setTcktClass("ECO");
        action.setTcktType("D");
        action.addToGroup();

        result = action.groupCheckout();
        assertEquals(Action.ERROR, result);

//        Selecting the enough flights to meet the number of passengers
        action.setFlightId(1);
        action.setTcktClass("ECO");
        action.setTcktType("D");
        action.addToGroup();

        result = action.groupCheckout();
        assertEquals(Action.SUCCESS, result);
    }



}
