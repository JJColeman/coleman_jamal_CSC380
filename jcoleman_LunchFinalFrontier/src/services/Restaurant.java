package services;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jcoleman
 * Date: 8/9/13
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Restaurant
{
    private List<Menu> menus;

    public Restaurant()
    {
         this.menus = new ArrayList<Menu>();
    }

    public List<Menu> getMenus()
    {
        return this.menus;
    }

    public void addMenu(Menu menu)
    {
        this.menus.add(menu);
    }

}
