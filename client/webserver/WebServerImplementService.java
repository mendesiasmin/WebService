
package webserver;

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
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WebServerImplementService", targetNamespace = "http://webserver/", wsdlLocation = "http://localhost:3000/webserver?wsdl")
public class WebServerImplementService
    extends Service
{

    private final static URL WEBSERVERIMPLEMENTSERVICE_WSDL_LOCATION;
    private final static WebServiceException WEBSERVERIMPLEMENTSERVICE_EXCEPTION;
    private final static QName WEBSERVERIMPLEMENTSERVICE_QNAME = new QName("http://webserver/", "WebServerImplementService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:3000/webserver?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVERIMPLEMENTSERVICE_WSDL_LOCATION = url;
        WEBSERVERIMPLEMENTSERVICE_EXCEPTION = e;
    }

    public WebServerImplementService() {
        super(__getWsdlLocation(), WEBSERVERIMPLEMENTSERVICE_QNAME);
    }

    public WebServerImplementService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVERIMPLEMENTSERVICE_QNAME, features);
    }

    public WebServerImplementService(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVERIMPLEMENTSERVICE_QNAME);
    }

    public WebServerImplementService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVERIMPLEMENTSERVICE_QNAME, features);
    }

    public WebServerImplementService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServerImplementService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WebServer
     */
    @WebEndpoint(name = "WebServerImplementPort")
    public WebServer getWebServerImplementPort() {
        return super.getPort(new QName("http://webserver/", "WebServerImplementPort"), WebServer.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServer
     */
    @WebEndpoint(name = "WebServerImplementPort")
    public WebServer getWebServerImplementPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webserver/", "WebServerImplementPort"), WebServer.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVERIMPLEMENTSERVICE_EXCEPTION!= null) {
            throw WEBSERVERIMPLEMENTSERVICE_EXCEPTION;
        }
        return WEBSERVERIMPLEMENTSERVICE_WSDL_LOCATION;
    }

}
