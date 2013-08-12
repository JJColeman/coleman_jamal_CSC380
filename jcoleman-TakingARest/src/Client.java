import mypackage.Restaurant;
import sun.net.www.http.HttpClient;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Scanner;
import mypackage.*;


/**
 * Created with IntelliJ IDEA.
 * User: jcoleman
 * Date: 7/27/13
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Client
{
    public static void main(String [] args) throws IOException
    {
        BufferedReader in1;
        PrintWriter out2;

        try
        {
            HttpURLConnection conn1 = (HttpURLConnection) new URL("http://localhost:8080/Restaurant").openConnection();
            conn1.setRequestMethod("GET");

            in1 = new BufferedReader(new InputStreamReader(conn1.getInputStream()));
            String input1 = "";
            String result1 = "";
            while((input1=in1.readLine()) !=null){
                result1 += input1 + "\n";
            }
            JAXBContext jc1 = JAXBContext.newInstance(Restaurant.class);
            Unmarshaller u1 = jc1.createUnmarshaller();
            Object obj1 = u1.unmarshal(new URL("http://localhost:8080/Restaurant"));

            Restaurant restaurant = (Restaurant) obj1;

            boolean choosenCorrectly1 = true;
            Menu pickedMenu = null;
            while(choosenCorrectly1)
            {
                System.out.println("Choose an menu by typing in the number next to the menu");                List<Menu> Menus = restaurant.getMenu();
                Scanner scanner = new Scanner(System.in);

                int MenuCount = 1;
                for(Menu menu: Menus)
                {
                    System.out.println(MenuCount + ": " + menu.getName());
                    MenuCount++;
                }

                int userInput1 = scanner.nextInt();

                for(Menu menu: Menus)
                {
                    if(Menus.get(userInput1 - 1).equals(menu))
                    {
                        choosenCorrectly1 = false;
                        pickedMenu = menu;
                    }
                }

                if(choosenCorrectly1)
                {
                    System.out.println("Incorrect name or format, please follow the instructions :D");
                }
            }

            boolean choosenCorrectly2 = true;
            Order order = new Order();
            while(choosenCorrectly2)
            {
                System.out.println("Choose an order by typing in the number next to the order");
                Scanner scanner = new Scanner(System.in);

                int orderCount = 1;
                for(Order order1: pickedMenu.getOrder())
                {
                    System.out.println(orderCount + ": " + order1.getName());
                    System.out.println(order1.getPrice());
                    orderCount++;
                }

                int userInput2 = scanner.nextInt();

                for(Order order2: pickedMenu.getOrder())
                {
                    if(pickedMenu.getOrder().get(userInput2 - 1).equals(order2))
                    {
                        choosenCorrectly2 = false;
                        order = order2;
                        System.out.println("Order has been sent for: " + order.getName());
                    }
                }

                if(choosenCorrectly2)
                {
                    System.out.println("Incorrect name or format, please follow the instructions :D");
                }
            }

            HttpURLConnection conn2 = (HttpURLConnection) new URL("http://localhost:8080/PickOrder").openConnection();
            conn2.setDoOutput(true);
            conn2.setRequestMethod("POST");

            out2 = new PrintWriter(new OutputStreamWriter(conn2.getOutputStream()));

            JAXBContext jc2 = JAXBContext.newInstance(Order.class);
            Marshaller marshaller = jc2.createMarshaller();

            marshaller.marshal(order,out2);

            in1.close();
            out2.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
