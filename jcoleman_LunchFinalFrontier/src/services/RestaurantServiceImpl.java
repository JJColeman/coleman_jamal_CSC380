package services;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jcoleman
 * Date: 8/9/13
 * Time: 9:58 PM
 * To change this template use File | Settings | File Templates.
 */

@WebService(endpointInterface = "services.RestaurantService", serviceName = "RestaurantService")
public class RestaurantServiceImpl implements RestaurantService
{
    private static final Restaurant RESTAURANT;

    static
    {
        RESTAURANT = new Restaurant();
        List<Order> orders1 = new ArrayList<Order>();
        orders1.add(new Order("Burger",2.50));
        orders1.add(new Order("HotDog", 1.50));
        orders1.add(new Order("Beer", 1.25));
        Menu menu1 = new Menu("American",orders1);

        List<Order> orders2 = new ArrayList<Order>();
        orders2.add(new Order("Burrito",4.25));
        orders2.add(new Order("Fajito",3.25));
        orders2.add(new Order("Flan",1.25));
        Menu menu2 = new Menu("Mexican",orders2);

        RESTAURANT.addMenu(menu1);
        RESTAURANT.addMenu(menu2);
    }

    @Override
    public List<Menu> getMenus()
    {
        return RESTAURANT.getMenus();
    }

    @Override
    public List<Order> getOrders(String menuName)
    {
        List<Order> orders = null;
        Menu[] menus = RESTAURANT.getMenus().toArray(new Menu[RESTAURANT.getMenus().size()]);

        for(int i=0;i<menus.length;i++)
        {
            if(menus[i].getMenuName().equals(menuName))
            {
                orders = menus[i].getOrders();
            }
        }

        return orders;
    }


}
