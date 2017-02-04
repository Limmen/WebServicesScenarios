
package kth.se.id2208.top_down.generated.client;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.7-b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "FlightTicketReservationPortType", targetNamespace = "http://flight_reservation")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FlightTicketReservationPortType {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     * @throws AuthorizationExceptionException
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://flight_reservation", className = "kth.se.id2208.top_down.generated.client.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://flight_reservation", className = "kth.se.id2208.top_down.generated.client.LoginResponse")
    @Action(input = "http://flight_reservation/FlightTicketReservationPortType/loginRequest", output = "http://flight_reservation/FlightTicketReservationPortType/loginResponse", fault = {
        @FaultAction(className = AuthorizationExceptionException.class, value = "http://flight_reservation/FlightTicketReservationPortType/login/Fault/AuthorizationException_Exception")
    })
    public String login(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws AuthorizationExceptionException
    ;

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<kth.se.id2208.top_down.generated.client.ItineraryType>
     * @throws AuthorizationExceptionException
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getItineraries", targetNamespace = "http://flight_reservation", className = "kth.se.id2208.top_down.generated.client.GetItineraries")
    @ResponseWrapper(localName = "getItinerariesResponse", targetNamespace = "http://flight_reservation", className = "kth.se.id2208.top_down.generated.client.GetItinerariesResponse")
    @Action(input = "http://flight_reservation/FlightTicketReservationPortType/getItinerariesRequest", output = "http://flight_reservation/FlightTicketReservationPortType/getItinerariesResponse", fault = {
        @FaultAction(className = AuthorizationExceptionException.class, value = "http://flight_reservation/FlightTicketReservationPortType/getItineraries/Fault/AuthorizationException_Exception")
    })
    public List<ItineraryType> getItineraries(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2)
        throws AuthorizationExceptionException
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<kth.se.id2208.top_down.generated.client.GetPriceListResponse.Return>
     * @throws AuthorizationExceptionException
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPriceList", targetNamespace = "http://flight_reservation", className = "kth.se.id2208.top_down.generated.client.GetPriceList")
    @ResponseWrapper(localName = "getPriceListResponse", targetNamespace = "http://flight_reservation", className = "kth.se.id2208.top_down.generated.client.GetPriceListResponse")
    @Action(input = "http://flight_reservation/FlightTicketReservationPortType/getPriceListRequest", output = "http://flight_reservation/FlightTicketReservationPortType/getPriceListResponse", fault = {
        @FaultAction(className = AuthorizationExceptionException.class, value = "http://flight_reservation/FlightTicketReservationPortType/getPriceList/Fault/AuthorizationException_Exception")
    })
    public List<kth.se.id2208.top_down.generated.client.GetPriceListResponse.Return> getPriceList(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws AuthorizationExceptionException
    ;

}
