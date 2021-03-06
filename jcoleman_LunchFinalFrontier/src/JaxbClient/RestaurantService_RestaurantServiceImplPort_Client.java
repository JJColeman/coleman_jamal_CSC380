
package JaxbClient;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2013-08-09T23:53:57.919-06:00
 * Generated source version: 2.7.6
 * 
 */
public final class RestaurantService_RestaurantServiceImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://services/", "RestaurantService");

    private RestaurantService_RestaurantServiceImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = RestaurantService_Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        RestaurantService_Service ss = new RestaurantService_Service(wsdlURL, SERVICE_NAME);
        RestaurantService port = ss.getRestaurantServiceImplPort();  
        
        {
            boolean choosenCorrectly1 = true;
            java.lang.String _getOrders_menuName = "";
            while(choosenCorrectly1)
            {
                System.out.println("Choose your menu by typing in the name of the menu of your choosing");
                java.util.List<JaxbClient.Menu> _getMenus__return = port.getMenus();
                Scanner scanner = new Scanner(System.in);

                for(Menu menu: _getMenus__return)
                {
                    System.out.println(menu.getMenuName());
                }

                String userInput1 = scanner.nextLine();

                for(Menu menu: _getMenus__return)
                {
                    if(menu.getMenuName().equals(userInput1))
                    {
                        choosenCorrectly1 = false;
                        _getOrders_menuName = userInput1;
                    }
                }

                if(choosenCorrectly1)
                {
                    System.out.println("Incorrect name or format, please follow the instructions :D");
                }
            }

            System.out.println("Invoking getOrders...");
            java.util.List<JaxbClient.Order> _getOrders__return = port.getOrders(_getOrders_menuName);
            boolean choosenCorrectly2 = true;

            while(choosenCorrectly2)
            {
                System.out.println("Choose an order by typing in the number next to the order");
                Scanner scanner = new Scanner(System.in);

                int orderCount = 1;
                for(Order order: _getOrders__return)
                {
                    System.out.println(orderCount + ": " + order.getOrderName());
                    System.out.println("$" + order.getPrice());
                    System.out.println();
                    orderCount++;
                }

                try
                {
                int userInput2 = scanner.nextInt();

                for(Order order: _getOrders__return)
                {
                    if(_getOrders__return.get(userInput2 - 1).equals(order))
                    {
                        choosenCorrectly2 = false;
                        System.out.println("Order has been sent for " + order.getOrderName() + " at a price of: $" + order.getPrice());
                    }
                }

                }
                catch(Exception e)
                {
                    System.out.println("Incorrect name or format, please follow the instructions :D");
                }
            }
        }

        System.exit(0);
    }

}
