
package org.foi.emp.web;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-2b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "LibraryWS", targetNamespace = "http://web.emp.foi.org/", wsdlLocation = "http://localhost:8080/LibraryWS/LibraryWS?WSDL")
public class LibraryWS_Service
    extends Service
{

    private final static URL LIBRARYWS_WSDL_LOCATION;
    private final static WebServiceException LIBRARYWS_EXCEPTION;
    private final static QName LIBRARYWS_QNAME = new QName("http://web.emp.foi.org/", "LibraryWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/LibraryWS/LibraryWS?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        LIBRARYWS_WSDL_LOCATION = url;
        LIBRARYWS_EXCEPTION = e;
    }

    public LibraryWS_Service() {
        super(__getWsdlLocation(), LIBRARYWS_QNAME);
    }

    public LibraryWS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), LIBRARYWS_QNAME, features);
    }

    public LibraryWS_Service(URL wsdlLocation) {
        super(wsdlLocation, LIBRARYWS_QNAME);
    }

    public LibraryWS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, LIBRARYWS_QNAME, features);
    }

    public LibraryWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LibraryWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns LibraryWS
     */
    @WebEndpoint(name = "LibraryWSPort")
    public LibraryWS getLibraryWSPort() {
        return super.getPort(new QName("http://web.emp.foi.org/", "LibraryWSPort"), LibraryWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LibraryWS
     */
    @WebEndpoint(name = "LibraryWSPort")
    public LibraryWS getLibraryWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://web.emp.foi.org/", "LibraryWSPort"), LibraryWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (LIBRARYWS_EXCEPTION!= null) {
            throw LIBRARYWS_EXCEPTION;
        }
        return LIBRARYWS_WSDL_LOCATION;
    }

}