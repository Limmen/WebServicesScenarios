package kth.se.id2208.top_down.generated;


import kth.se.id2208.top_down.generated.artifacts.AuthorizationException;
import kth.se.id2208.top_down.generated.artifacts.AuthorizationException_Exception;
import kth.se.id2208.top_down.generated.artifacts.GetPriceListResponse;
import kth.se.id2208.top_down.generated.artifacts.ItineraryType;
import kth.se.id2208.top_down.generated.model.AuthenticationManager;
import kth.se.id2208.top_down.generated.model.DataManager;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;


/**
 * WebService Endpoint, service: FlightTicketReservationServiceTopDown, implemented with SOAP Binding over HTTP
 *
 * @author Kim Hammar on 2017-02-03.
 */
@WebService(targetNamespace = "http://flight_reservation", serviceName="FlightTicketReservationServiceTopDown",
        name="FlightTicketReservationPortType")
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
        use=SOAPBinding.Use.LITERAL,
        parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
public class FlightTicketReservationServiceTopDown {

    private DataManager dataManager;
    private AuthenticationManager authenticationManager;

    public FlightTicketReservationServiceTopDown(){
        dataManager = new DataManager();
        authenticationManager = new AuthenticationManager();
    }

    /**
     * login operation. Authenticates the user and returns security token
     *
     * @param username username
     * @param pw password
     * @return AUTH_TOKEN
     * @throws AuthorizationException thrown if the login failed
     */
    @WebMethod
    public String login(String username, String pw) throws AuthorizationException_Exception {
        return authenticationManager.login(username, pw);
    }

    /**
     * getItineraries operation, returns all itinerary given a departureCity and destinationCity.
     * Authorized operation that requires security token.
     *
     * @param departureCity
     * @param destinationCity
     * @param token security token
     * @return ArrayList of Itineraries
     * @throws AuthorizationException thrown if the security token was invalid
     */
    @WebMethod
    public ArrayList<ItineraryType> getItineraries(String departureCity, String destinationCity, String token) throws AuthorizationException_Exception {
        authenticationManager.authorize(token);
        return dataManager.getAllItineraries(departureCity, destinationCity);

    }

    /**
     * getPriceList operation, returns a list of all itineraries and corresponding price.
     * Authorized operation that requires security token.
     *
     * @param token
     * @return ArrayList of PriceEntry (Itinerary - Price pairs)
     * @throws AuthorizationException thrown if the security token was invalid
     */
    @WebMethod
    public ArrayList<GetPriceListResponse.Return> getPriceList(String token) throws AuthorizationException_Exception {
        authenticationManager.authorize(token);
        return dataManager.getPriceList();
    }


    /**
     * Main entry point of the program, publishes the webservice on a light-weight webserver at URL:
     * http://localhost:9000/kth.se.id2208.bottom_up.FlightTicketReservationService
     *
     * @param argv
     */
    public static void main(String[] argv) {
        Object implementor = new FlightTicketReservationServiceTopDown();
        String address = "http://localhost:9001/kth.se.id2208.top_down.FlightTicketReservationService";
        Endpoint.publish(address, implementor);
    }
}
