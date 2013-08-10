package services;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jcoleman
 * Date: 8/9/13
 * Time: 9:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Menu
{
    private List<Order> orders;
    private String menuName;

    public Menu(String menuName, List<Order>order)
    {
        this.orders = order;
        this.menuName = menuName;
    }

    public List<Order> getOrders()
    {
        return this.orders;
    }

    public void addOrder(Order order)
    {
        this.orders.add(order);
    }

    public String getMenuName()
    {
        return this.menuName;
    }

    public void setMenuName(String menuName)
    {
        this.menuName = menuName;
    }
}

