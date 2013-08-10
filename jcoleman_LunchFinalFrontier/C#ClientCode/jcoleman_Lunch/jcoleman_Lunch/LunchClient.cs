using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using jcoleman_Lunch.RestaurantService;

namespace jcoleman_Lunch
{
    class LunchClient
    {
        static void Main(string[] args)
        {
            RestaurantServiceClient restaurantClient = new RestaurantServiceClient();
            menu[] menus = restaurantClient.getMenus();
            order[] order;
            string grabbedMenuName = "";

            bool choosenCorrectly1 = true;

            while (choosenCorrectly1)
            {
                Console.WriteLine("Choose your menu by typing in the name of the menu of your choosing");

                foreach (menu currentMenu in menus)
                {
                    Console.WriteLine(currentMenu.menuName);
                }
                
                string userInput1 = Console.ReadLine();

                foreach(menu currentMenu in menus)
                {
                    if (currentMenu.menuName.Equals(userInput1))
                    {
                        choosenCorrectly1 = false;
                        grabbedMenuName = userInput1;
                    }
                }

                if (choosenCorrectly1)
                {
                    Console.WriteLine("Incorrect name or format, please follow the instructions :D");
                }
            }

            order = restaurantClient.getOrders(grabbedMenuName);
            bool choosenCorrectly2 = true;

            while (choosenCorrectly2)
            {
                Console.WriteLine("Choose an order by typing in the number next to the order");

                int orderCount = 1;
                foreach(order currentOrder in order)
                {
                    Console.WriteLine(orderCount + ": " + currentOrder.orderName);
                    Console.WriteLine("$" + currentOrder.price);
                    Console.WriteLine();
                    orderCount++;
                }

                try
                {
                    int userInput2 = int.Parse(Console.ReadLine());

                    foreach (order currentOrder in order)
                    {
                        if (order.ElementAt(userInput2 - 1).Equals(currentOrder))
                        {
                            choosenCorrectly2 = false;
                            Console.WriteLine("Order has been sent for " + currentOrder.orderName + " at a price of: $" + currentOrder.price);
                        }
                    }
                }

                catch (Exception e)
                {
                    Console.WriteLine("Incorrect name or format, please follow the instructions :D");
                }
            }

            Console.ReadLine();
        }
    }
}
