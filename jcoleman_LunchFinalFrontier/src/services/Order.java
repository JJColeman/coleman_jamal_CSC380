package services;

/**
 * Created with IntelliJ IDEA.
 * User: jcoleman
 * Date: 8/9/13
 * Time: 9:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Order
{
    private double price;
    private String orderName;

    public Order(String orderName, double price)
    {
        this.price = price;
        this.orderName = orderName;
    }

    public double getPrice()
    {
        return this.price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getOrderName()
    {
        return this.orderName;
    }

    public void setOrderName(String orderName)
    {
        this.orderName = orderName;
    }
}
