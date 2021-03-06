package JaxbClient;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2013-08-09T23:53:58-06:00
 * Generated source version: 2.7.6
 * 
 */
@WebServiceClient(name = "RestaurantService", 
                  wsdlLocation = "file:/C:/Users/jcoleman/Documents/Assignment Folder/Quarter 12/Java III/coleman_jamal_CSC380/jcoleman_LunchFinalFrontier/src/JaxbClient/RestaurantService.wsdl",
                  targetNamespace = "http://services/") 
public class RestaurantService_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://services/", "RestaurantService");
    public final static QName RestaurantServiceImplPort = new QName("http://services/", "RestaurantServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/jcoleman/Documents/Assignment Folder/Quarter 12/Java III/coleman_jamal_CSC380/jcoleman_LunchFinalFrontier/src/JaxbClient/RestaurantService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(RestaurantService_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/jcoleman/Documents/Assignment Folder/Quarter 12/Java III/coleman_jamal_CSC380/jcoleman_LunchFinalFrontier/src/JaxbClient/RestaurantService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public RestaurantService_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public RestaurantService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RestaurantService_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public RestaurantService_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public RestaurantService_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public RestaurantService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns RestaurantService
     */
    @WebEndpoint(name = "RestaurantServiceImplPort")
    public RestaurantService getRestaurantServiceImplPort() {
        return super.getPort(RestaurantServiceImplPort, RestaurantService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RestaurantService
     */
    @WebEndpoint(name = "RestaurantServiceImplPort")
    public RestaurantService getRestaurantServiceImplPort(WebServiceFeature... features) {
        return super.getPort(RestaurantServiceImplPort, RestaurantService.class, features);
    }

}
