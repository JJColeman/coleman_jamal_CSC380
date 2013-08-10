package servlet;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import services.RestaurantServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.xml.ws.Endpoint;

/**
 * Created with IntelliJ IDEA.
 * User: jcoleman
 * Date: 8/9/13
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */

@WebServlet("/services/*")
public class RestaurantServlet extends CXFNonSpringServlet
{
    @Override
    protected void loadBus(ServletConfig sc)
    {
        super.loadBus(sc);

        Bus bus = getBus();
        BusFactory.setDefaultBus(bus);
        Endpoint.publish("/RestaurantService" , new RestaurantServiceImpl());
    }
}
