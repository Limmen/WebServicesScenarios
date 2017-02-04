package kth.se.id2208.bottom_up;

import kth.se.id2208.bottom_up.faults.AuthorizationException;
import kth.se.id2208.bottom_up.model.auth.AuthenticationManager;
import kth.se.id2208.bottom_up.model.data.DataManager;
import kth.se.id2208.bottom_up.model.data.records.*;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.Date;

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
public class FlightTicketReservationService {

    private DataManager dataManager;
    private AuthenticationManager authenticationManager;

    public FlightTicketReservationService(){
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
    public String login(String username, String pw) throws AuthorizationException {
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
    public ArrayList<Itinerary> getItineraries(String departureCity, String destinationCity, String token) throws AuthorizationException {
        authenticationManager.authorize(token);
        return dataManager.getAllItineraries(departureCity, destinationCity);
    }

    /**
     * getAvailableTickets operation, returns all tickets given a date and a itinerary.
     * Authorized operation that requires security token
     *
     * @param date
     * @param itinerary
     * @param token
     * @return ArrayList of Tickets
     * @throws AuthorizationException thrown if the security token was invalid
     */
    @WebMethod
    public ArrayList<Ticket> getAvailableTickets(Date date, Itinerary itinerary, String token) throws AuthorizationException {
        authenticationManager.authorize(token);
        return dataManager.getAvailableTickets(itinerary, date);
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
    public ArrayList<PriceEntry> getPriceList(String token) throws AuthorizationException {
        authenticationManager.authorize(token);
        return dataManager.getPriceList();
    }

    /**
     * bookTickets operation, books a list of tickets given a creditCardNumber, returns receipt if successful.
     * Authorized operaiton that requires security token.
     *
     * @param creditCardNumber
     * @param tickets
     * @param token
     * @return Receipt
     * @throws AuthorizationException thrown if security token was invalid
     */
    @WebMethod
    public Receipt bookTickets(int creditCardNumber, ArrayList<Ticket> tickets, String token) throws AuthorizationException {
        authenticationManager.authorize(token);
        return dataManager.bookTickets(creditCardNumber, tickets);
    }

    /**
     * issueTickets operation, issue previously booked tickets.
     * Authorized operation that requires security token.
     *
     * @param receipt
     * @param token
     * @return ArrayList of purchased tickets
     * @throws AuthorizationException thrown if security token was invalid
     */
    @WebMethod
    public ArrayList<PurchasedTicket> issueTickets(Receipt receipt, String token) throws AuthorizationException {
        authenticationManager.authorize(token);
        return dataManager.issueTickets(receipt);
    }

    /**
     * Main entry point of the program, publishes the webservice on a light-weight webserver at URL:
     * http://localhost:9000/kth.se.id2208.bottom_up.FlightTicketReservationService
     *
     * @param argv
     */
    public static void main(String[] argv) {
        Object implementor = new FlightTicketReservationService();
        String address = "http://localhost:9000/kth.se.id2208.bottom_up.FlightTicketReservationServiceTopDown";
        Endpoint.publish(address, implementor);
    }
}
