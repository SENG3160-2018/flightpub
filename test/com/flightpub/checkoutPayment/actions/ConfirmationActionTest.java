package com.flightpub.checkoutPayment.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;
import org.junit.Test;
import org.apache.struts2.StrutsTestCase;

import java.util.HashMap;
import java.util.Map;


public class ConfirmationActionTest extends StrutsTestCase {
    public void testExecute()  {
        ActionProxy proxy = getActionProxy("/confirmation.action");
        ConfirmationAction action = (ConfirmationAction) proxy.getAction();

        Map session = new HashMap();
        session.put("CART", null);
        action.setSession(session);

        String result = action.execute();
        assertEquals(Action.SUCCESS, result);
        assertFalse(session.containsValue("CART"));
    }

    @Test
    public void testEmailFriend() {
        ActionProxy proxy = getActionProxy("/confirmation.action");
        ConfirmationAction action = (ConfirmationAction) proxy.getAction();

        Map session = new HashMap();
        session.put("SHARE", null);
        action.setSession(session);

        String result = action.emailFriend();
        assertEquals(Action.SUCCESS, result);
        assertFalse(session.containsValue("SHARE"));
    }
}