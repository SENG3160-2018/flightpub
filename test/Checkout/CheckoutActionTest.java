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

    public void testRemoveCart() {
//        Case 3 - Remove from cart functionality (results page)
        ActionProxy proxy = getActionProxy("/checkout.action");
        CheckoutAction action = (CheckoutAction) proxy.getAction();

        Map session = new HashMap();
        session.put("USER_TYPE", "group");
        session.put("PASSENGERS", 2);
        action.setSession(session);

        action.setFlightId(1);
        action.setTcktClass("ECO");
        action.setTcktType("D");
        action.addToGroup();
        action.setFlightCt(1);

        String result = action.removeCart();
        assertEquals(Action.SUCCESS, result);
        assertTrue("Flight was not removed from cart.", action.getCart().isEmpty());
    }

    public void testShare() {
//        Case 4 - Share flight functionality
        ActionProxy proxy = getActionProxy("/checkout.action");
        CheckoutAction action = (CheckoutAction) proxy.getAction();

        Map session = new HashMap();
        session.put("USER_TYPE", "group");
        session.put("PASSENGERS", 2);
        action.setSession(session);

        action.setFlightId(1);
        action.setTcktClass("ECO");
        action.setTcktType("D");
        action.addToGroup();

        action.setFlightId(2);
        action.setTcktClass("BUS");
        action.setTcktType("D");
        action.addToGroup();
        action.groupCheckout();

//        Two flights in cart, one shared.
        action.setFlightCt2(2);
        String result = action.share();
        assertEquals(Action.SUCCESS, result);
        assertTrue("Flight was not added to share table when it should have.", action.getShare().size()==1&action.getCart().size()==1);


    }

    public void testUndo(){
//        Case 5 - Add flights back to cart
        ActionProxy proxy = getActionProxy("/checkout.action");
        CheckoutAction action = (CheckoutAction) proxy.getAction();

        Map session = new HashMap();
        session.put("USER_TYPE", "group");
        session.put("PASSENGERS", 2);
        action.setSession(session);

        action.setFlightId(1);
        action.setTcktClass("ECO");
        action.setTcktType("D");
        action.addToGroup();

        action.setFlightId(2);
        action.setTcktClass("BUS");
        action.setTcktType("D");
        action.addToGroup();

        action.groupCheckout();
        action.setFlightCt2(2);
        action.share();
//        Multiple passengers, adding flight back to cart
        action.setFlightCt3(0);
        String result = action.undo();
        assertEquals(Action.SUCCESS, result);
        assertTrue("Flight added back to cart", action.getCart().size()==2);
//        &action.getShare().isEmpty()
    }

    public void testRemoveCartCO() {
//        Case 6 - Remove from cart functionality (checkout page)
        ActionProxy proxy = getActionProxy("/checkout.action");
        CheckoutAction action = (CheckoutAction) proxy.getAction();

        Map session = new HashMap();
        session.put("USER_TYPE", "group");
        session.put("PASSENGERS", 2);
        action.setSession(session);

        action.setFlightId(1);
        action.setTcktClass("ECO");
        action.setTcktType("D");
        action.addToGroup();

        action.setFlightId(2);
        action.setTcktClass("BUS");
        action.setTcktType("D");
        action.addToGroup();
        action.groupCheckout();

//        Remove flight from cart without emptying it
        action.setFlightCt2(2);
        String result = action.removeCartCO();
        assertEquals(Action.SUCCESS, result);
        assertTrue("Flight was not removed from cart when it should have been", action.getCart().size()==1);

//        Empty cart
        action.setFlightCt2(1);
        result = action.removeCartCO();
        assertEquals(Action.ERROR, result);
        assertTrue("Flight was not removed from cart when it should have been", action.getCart().isEmpty());

//        Empty cart after clicking share flight
//        action.setFlightId(1);
//        action.setTcktClass("ECO");
//        action.setTcktType("D");
//        action.addToGroup();
//        action.setFlightId(2);
//        action.setTcktClass("BUS");
//        action.setTcktType("D");
//        action.addToGroup();
//        action.groupCheckout();
//        action.setFlightCt2(1);
//        action.share();
//        result = action.removeCartCO();
//        assertEquals(Action.ERROR, result);
//        assertTrue("Flight was not removed from cart when it should have been", action.getCart().isEmpty()&action.getShare().isEmpty());
    }

}
