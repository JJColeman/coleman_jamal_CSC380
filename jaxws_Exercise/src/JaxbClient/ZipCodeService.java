package JaxbClient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2013-08-09T20:05:42.967-06:00
 * Generated source version: 2.7.6
 * 
 */
@WebService(targetNamespace = "http://localhost/ZipCodeService", name = "ZipCodeService")
@XmlSeeAlso({ObjectFactory.class})
public interface ZipCodeService {

    @RequestWrapper(localName = "addZipCode", targetNamespace = "http://localhost/ZipCodeService", className = "JaxbClient.AddZipCode")
    @WebMethod
    @ResponseWrapper(localName = "addZipCodeResponse", targetNamespace = "http://localhost/ZipCodeService", className = "JaxbClient.AddZipCodeResponse")
    public void addZipCode(
        @WebParam(name = "state", targetNamespace = "")
        JaxbClient.State state,
        @WebParam(name = "zipCodes", targetNamespace = "")
        java.util.List<java.lang.Integer> zipCodes
    );

    @WebResult(name = "state", targetNamespace = "")
    @RequestWrapper(localName = "getState", targetNamespace = "http://localhost/ZipCodeService", className = "JaxbClient.GetState")
    @WebMethod
    @ResponseWrapper(localName = "getStateResponse", targetNamespace = "http://localhost/ZipCodeService", className = "JaxbClient.GetStateResponse")
    public JaxbClient.State getState(
        @WebParam(name = "zipCode", targetNamespace = "")
        java.lang.Integer zipCode
    );
}
