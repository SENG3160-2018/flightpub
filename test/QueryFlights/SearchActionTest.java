package QueryFlights;

import com.flightpub.queryFlights.actions.SearchAction;
import com.opensymphony.xwork2.ActionProxy;
import junit.framework.Assert;
import org.apache.struts2.StrutsTestCase;

public class SearchActionTest extends StrutsTestCase {
    public void testDisplay() throws Exception {
        request.setParameter("userName", "");
        request.setParameter("password","");
        ActionProxy proxy = getActionProxy("search");
        SearchAction search = (SearchAction) proxy.getAction();
        proxy.execute();
        Assert.assertEquals("Two errors should be reported", 2, search.getFieldErrors().size());
        Assert.assertEquals("User name should be required", "User Name is required",
                search.getFieldErrors().get("userName").get(0));
        Assert.assertEquals("Password should be required", "Password is required",
                search.getFieldErrors().get("password").get(0));
    }
}
