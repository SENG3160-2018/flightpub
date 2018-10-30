package com.flightpub.checkoutPayment.actions;

import com.flightpub.base.hibernate.dao.FlightsDAO;
import com.flightpub.base.hibernate.dao.FlightsDAOImpl;;
import com.flightpub.base.model.Flights;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsTestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReceiptActionTest extends StrutsTestCase {
    public void testCartHasFlights() {
        ActionProxy proxy = getActionProxy("/receipt.action");
        ReceiptAction action = (ReceiptAction) proxy.getAction();

        /* Get a random flight */
        FlightsDAO flightsDAO = new FlightsDAOImpl();
        Flights flight = flightsDAO.getFlight(24810); // legit flight from database

        action.setName("TestName");
        action.setEmail("test@gmail.com");

        ArrayList<Flights> cart = new ArrayList<Flights>();
        cart.add(flight);

        Map session = new HashMap();
        session.put("CART", cart);
        action.setSession(session);


        String result = action.execute();
        /* If this fails Gmail API does not trust the network */
        assertEquals(Action.SUCCESS, result);
    }

    public void testCartHasNoFlights() {
        ActionProxy proxy = getActionProxy("/receipt.action");
        ReceiptAction action = (ReceiptAction) proxy.getAction();

        action.setName("TestName");
        action.setEmail("test@gmail.com");

        Map session = new HashMap();
        action.setSession(session);

        String result = action.execute();
        assertEquals(Action.SUCCESS, result);

    }
}