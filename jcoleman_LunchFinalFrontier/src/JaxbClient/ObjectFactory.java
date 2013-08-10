
package JaxbClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the JaxbClient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetOrdersResponse_QNAME = new QName("http://localhost/RestaurantService", "getOrdersResponse");
    private final static QName _GetMenus_QNAME = new QName("http://localhost/RestaurantService", "getMenus");
    private final static QName _GetMenusResponse_QNAME = new QName("http://localhost/RestaurantService", "getMenusResponse");
    private final static QName _GetOrders_QNAME = new QName("http://localhost/RestaurantService", "getOrders");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: JaxbClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetOrdersResponse }
     * 
     */
    public GetOrdersResponse createGetOrdersResponse() {
        return new GetOrdersResponse();
    }

    /**
     * Create an instance of {@link GetMenus }
     * 
     */
    public GetMenus createGetMenus() {
        return new GetMenus();
    }

    /**
     * Create an instance of {@link GetOrders }
     * 
     */
    public GetOrders createGetOrders() {
        return new GetOrders();
    }

    /**
     * Create an instance of {@link GetMenusResponse }
     * 
     */
    public GetMenusResponse createGetMenusResponse() {
        return new GetMenusResponse();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link Menu }
     * 
     */
    public Menu createMenu() {
        return new Menu();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrdersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/RestaurantService", name = "getOrdersResponse")
    public JAXBElement<GetOrdersResponse> createGetOrdersResponse(GetOrdersResponse value) {
        return new JAXBElement<GetOrdersResponse>(_GetOrdersResponse_QNAME, GetOrdersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMenus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/RestaurantService", name = "getMenus")
    public JAXBElement<GetMenus> createGetMenus(GetMenus value) {
        return new JAXBElement<GetMenus>(_GetMenus_QNAME, GetMenus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMenusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/RestaurantService", name = "getMenusResponse")
    public JAXBElement<GetMenusResponse> createGetMenusResponse(GetMenusResponse value) {
        return new JAXBElement<GetMenusResponse>(_GetMenusResponse_QNAME, GetMenusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrders }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/RestaurantService", name = "getOrders")
    public JAXBElement<GetOrders> createGetOrders(GetOrders value) {
        return new JAXBElement<GetOrders>(_GetOrders_QNAME, GetOrders.class, null, value);
    }

}
