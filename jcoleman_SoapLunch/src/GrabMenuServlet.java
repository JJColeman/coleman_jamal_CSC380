import JAXBClasses.Menu;
import JAXBClasses.Order;
import JAXBClasses.Restaurant;
import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;
import org.w3c.dom.NodeList;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPEnvelope;
import java.io.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jcoleman
 * Date: 7/30/13
 * Time: 5:42 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "GrabMenu")
public class GrabMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {

            InputStream inputStream = request.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String input = "";
            String result = "";
            while((input= bufferedReader.readLine()) !=null){
                result += input;
            }

            boolean isGrabbingMenu = result.matches("[\\w\\W]*<Menu:name>\\w*<\\WMenu:name>[\\w\\W]*");
            boolean isGrabbingOrder = result.matches("[\\w\\W]*<Order:name>\\w*<\\WOrder:name>[\\w\\W]*");

            File menuFile = new File("C:\\Users\\jcoleman\\Documents\\Assignment Folder\\Quarter 12\\Java III\\coleman_jamal_CSC380\\jcoleman_SoapLunch\\src\\Restaurant");
            JAXBContext jaxbContext = JAXBContext.newInstance(Restaurant.class);
            Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
            Restaurant restaurant = (Restaurant) jaxbUnMarshaller.unmarshal(menuFile);
            ServletOutputStream out = response.getOutputStream();

            if(isGrabbingMenu)
            {
                String[] MenuParseOut1 = result.split("<Menu:name>");
                String[] MenuParseOut2 = MenuParseOut1[1].split("</Menu:name>");
                String MenuOrder = MenuParseOut2[0];

                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: application/soap+xml; charset=utf-8");
                out.println("Content-Length: nnn");
                out.println("<?xml version=\"1.0\"?>");
                out.println("<soap:Envelope");
                out.println("xmlns:soap=\"http://www.w3.org/2001/12/soap-envelope\"");
                out.println("soap:encodingStyle=\"http://www.w3.org/2001/12/soap-encoding\">");
                out.println("<soap:Body xmlns:m=\"http://localhost:8080/GrabMenu\">");
                out.println("<Menu:GetMenuResponse>");
                for(Menu menu: restaurant.getMenu())
                {
                    if(menu.getName().equals(MenuOrder))
                    {
                        out.println("<Menu:name>" + menu.getName());
                        for(Order order: menu.getOrder())
                        {
                            out.println("<Order:name>" + order.getName() + "</Order:name>");
                            out.println("<Order:price>" + order.getPrice() + "</Order:price>");
                        }
                        out.println("</Menu:name>");
                    }
                }
                out.println("</Menu:GetMenuResponse>");
                out.println("</soap:Body>");
                out.println("</soap:Envelope>");
            }

            else if(isGrabbingOrder)
            {
                String[] orderParseOut1 = result.split("<Order:name>");
                String[] korderParseOut2 = orderParseOut1[1].split("</Order:name>");
                String grabbedOrder = korderParseOut2[0];

                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: application/soap+xml; charset=utf-8");
                out.println("Content-Length: nnn");
                out.println("<?xml version=\"1.0\"?>");
                out.println("<soap:Envelope");
                out.println("xmlns:soap=\"http://www.w3.org/2001/12/soap-envelope\"");
                out.println("soap:encodingStyle=\"http://www.w3.org/2001/12/soap-encoding\">");
                out.println("<soap:Body xmlns:m=\"http://localhost:8080/GrabMenu\">");
                out.println("<Menu:GetOrderResponse>");
                for(Menu menu: restaurant.getMenu())
                {
                    for(Order order: menu.getOrder())
                    {
                        if(order.getName().equals(grabbedOrder))
                        {
                             out.println("<Order:GrabbingOrder>" + order.getName() + "</Order:GrabbingOrder>");
                        }
                    }
                }
                out.println("</Menu:GetOrderResponse>");
                out.println("</soap:Body>");
                out.println("</soap:Envelope>");
            }

            else
            {
                out.println("POST /GrabMenu HTTP/1.1 3018 Invalid Line");
            }

            out.close();
            inputStream.close();
            reader.close();
            bufferedReader.close();
        }

        catch (Exception e)
        {
              e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
