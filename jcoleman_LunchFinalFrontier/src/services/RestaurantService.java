package services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jcoleman
 * Date: 8/9/13
 * Time: 9:58 PM
 * To change this template use File | Settings | File Templates.
 */

@WebService(name = "RestaurantService", targetNamespace = "http://localhost/RestaurantService")
public interface RestaurantService
{
    @WebMethod(operationName = "getMenus")
    public @WebResult(name = "menu") List<Menu> getMenus();

    @WebMethod(operationName = "getOrders")
    public @WebResult(name = "order") List<Order> getOrders(@WebParam(name = "menuName") String menuName);
}
