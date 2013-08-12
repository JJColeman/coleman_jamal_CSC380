import mypackage.Menu;
import mypackage.Order;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
/**
 * Created with IntelliJ IDEA.
 * User: jcoleman
 * Date: 7/27/13
 * Time: 2:57 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet
        (name = "Rest")
public class Restaurant extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ServletOutputStream out = response.getOutputStream();
        ServletInputStream in = request.getInputStream();

        try
        {
            out.println("<Restaurant>");
            out.println("<Menu name=\"American\">");
            out.println("<Order name=\"Tator tots\" price=\".99\">");
            out.println("</Order>");
            out.println("<Order name=\"Jerky\" price=\"2.99\">");
            out.println("</Order>");
            out.println("<Order name=\"Popcorn\" price=\"1.99\">");
            out.println("</Order>");
            out.println("</Menu>");
            out.println("<Menu name=\"Chinese\">");
            out.println("<Order name=\"Orange Chicken\" price=\"1.99\">");
            out.println("</Order>");
            out.println("<Order name=\"Noodles\" price=\"3.99\">");
            out.println("</Order>");
            out.println("<Order name=\"Rice\" price=\".99\">");
            out.println("</Order>");
            out.println("</Menu>");
            out.println("</Restaurant>");
        }

        catch (Exception e1)
        {
            e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        out.close();
        in.close();

    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    private static String getValue(String tag, Element element)
    {
        NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodes.item(0);

        return node.getNodeValue();
    }


}
