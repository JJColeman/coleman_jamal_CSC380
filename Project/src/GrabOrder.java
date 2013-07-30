import mypackage.Menu;
import mypackage.Order;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jcoleman
 * Date: 7/29/13
 * Time: 11:13 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "GrabOrder")
public class GrabOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ServletOutputStream out = response.getOutputStream();
        ServletInputStream in = request.getInputStream();
        out.println("Pick Order");

        try
        {
            File file = new File("C:\\Users\\jcoleman\\Documents\\Assignment Folder\\Quarter 12\\Java III\\coleman_jamal_CSC380\\Project\\src\\Restaurant");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            org.w3c.dom.Document document = documentBuilder.parse(file);

            List<Menu> menus = new ArrayList<Menu>();
            NodeList nodes = document.getDocumentElement().getElementsByTagName("Menu");

            for(int i = 0; i < nodes.getLength(); i++)
            {
                Menu newMenu = new Menu();

                newMenu.setName(nodes.item(i).getAttributes().getNamedItem("name").getNodeValue());

                Node node = nodes.item(i);

                Element element = (Element)node;

                NodeList ordersNode = element.getElementsByTagName("Order");
                for(int j=0; j< ordersNode.getLength(); j++){

                    Order newOrder = new Order();
                    newOrder.setName(ordersNode.item(j).getAttributes().getNamedItem("name").getNodeValue());
                    newOrder.setPrice(new BigDecimal(ordersNode.item(j).getAttributes().getNamedItem("price").getNodeValue()));
                    newMenu.getOrder().add(newOrder);
                }
                menus.add(newMenu);
            }

            int count = 15;
            Order order = menus.get(0).getOrder().get(0);
            File menuFile = new File("C:\\file" + count + ".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Order.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            jaxbMarshaller.marshal(order,menuFile);
            jaxbMarshaller.marshal(order,out);
        }

        catch (Exception e1)
        {
            e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        out.close();
        in.close();

    }
}
