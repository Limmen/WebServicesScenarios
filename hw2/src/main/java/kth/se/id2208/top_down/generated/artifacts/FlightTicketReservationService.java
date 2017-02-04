
package kth.se.id2208.top_down.generated.artifacts;

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
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "FlightTicketReservationServiceTopDown", targetNamespace = "http://id2208.se.kth.top_down.FlightTicketReservationServiceTopDown", wsdlLocation = "file:///home/kim/workspace/java/WebServicesScenarios/hw2/src/main/java/kth/se/id2208/top_down/wsdl/FlightTicketReservationServiceTopDown.wsdl")
public class FlightTicketReservationService
    extends Service
{

    private final static URL FLIGHTTICKETRESERVATIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException FLIGHTTICKETRESERVATIONSERVICE_EXCEPTION;
    private final static QName FLIGHTTICKETRESERVATIONSERVICE_QNAME = new QName("http://id2208.se.kth.top_down.FlightTicketReservationServiceTopDown", "FlightTicketReservationServiceTopDown");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:///home/kim/workspace/java/WebServicesScenarios/hw2/src/main/java/kth/se/id2208/top_down/wsdl/FlightTicketReservationServiceTopDown.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FLIGHTTICKETRESERVATIONSERVICE_WSDL_LOCATION = url;
        FLIGHTTICKETRESERVATIONSERVICE_EXCEPTION = e;
    }

    public FlightTicketReservationService() {
        super(__getWsdlLocation(), FLIGHTTICKETRESERVATIONSERVICE_QNAME);
    }

    public FlightTicketReservationService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FLIGHTTICKETRESERVATIONSERVICE_QNAME, features);
    }

    public FlightTicketReservationService(URL wsdlLocation) {
        super(wsdlLocation, FLIGHTTICKETRESERVATIONSERVICE_QNAME);
    }

    public FlightTicketReservationService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FLIGHTTICKETRESERVATIONSERVICE_QNAME, features);
    }

    public FlightTicketReservationService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FlightTicketReservationService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FlightTicketReservationPortType
     */
    @WebEndpoint(name = "FlightTicketReservationServiceTopDown")
    public FlightTicketReservationPortType getFlightTicketReservationService() {
        return super.getPort(new QName("http://id2208.se.kth.top_down.FlightTicketReservationServiceTopDown", "FlightTicketReservationServiceTopDown"), FlightTicketReservationPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FlightTicketReservationPortType
     */
    @WebEndpoint(name = "FlightTicketReservationServiceTopDown")
    public FlightTicketReservationPortType getFlightTicketReservationService(WebServiceFeature... features) {
        return super.getPort(new QName("http://id2208.se.kth.top_down.FlightTicketReservationServiceTopDown", "FlightTicketReservationServiceTopDown"), FlightTicketReservationPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FLIGHTTICKETRESERVATIONSERVICE_EXCEPTION!= null) {
            throw FLIGHTTICKETRESERVATIONSERVICE_EXCEPTION;
        }
        return FLIGHTTICKETRESERVATIONSERVICE_WSDL_LOCATION;
    }

}
