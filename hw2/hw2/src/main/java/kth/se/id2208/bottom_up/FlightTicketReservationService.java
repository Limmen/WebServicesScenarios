package kth.se.id2208.bottom_up;

import kth.se.id2208.bottom_up.faults.AuthorizationException;
import kth.se.id2208.bottom_up.model.auth.AuthenticationManager;
import kth.se.id2208.bottom_up.model.data.DataManager;
import kth.se.id2208.bottom_up.model.data.records.*;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Kim Hammar on 2017-02-03.
 */
@WebService(targetNamespace = "http://flight_reservation")
public class FlightTicketReservationService {

    private DataManager dataManager;
    private AuthenticationManager authenticationManager;

    public FlightTicketReservationService(){
        dataManager = new DataManager();
        authenticationManager = new AuthenticationManager();
    }

    @WebMethod
    public Flight getFlight(){
        return dataManager.getFlights().get(0);
    }

    @WebMethod
    public ArrayList<Flight> getFlights(){
        return dataManager.getFlights();
    }

    @WebMethod
    public ArrayList<Initiary> getInitiaries2(){
        return dataManager.getAllInitiaries();
    }

    @WebMethod
    public ArrayList<Initiary> getInitiaries3(ArrayList<Initiary> initiaries){
        System.out.println("Received initiarieS: " + initiaries.size());
        return initiaries;
    }

    @WebMethod
    public String login(String username, String pw) throws AuthorizationException {
        return authenticationManager.login(username, pw);
    }

    @WebMethod
    public ArrayList<Initiary> getInitiaries(String departureCity, String destinationCity, String token) throws AuthorizationException {
        authenticationManager.authorize(token);
        return dataManager.getAllInitiaries(departureCity, destinationCity);
    }

    @WebMethod
    public ArrayList<Ticket> getAvailableTickets(Date date, Initiary initiary, String token) throws AuthorizationException {
        authenticationManager.authorize(token);
        return dataManager.getAvailableTickets(initiary, date);
    }

    @WebMethod
    public ArrayList<PriceEntry> getPriceList(String token) throws AuthorizationException {
        authenticationManager.authorize(token);
        return dataManager.getPriceList();
    }

    @WebMethod
    public Receipt bookTickets(int creditCardNumber, ArrayList<Ticket> tickets, String token) throws AuthorizationException {
        authenticationManager.authorize(token);
        return dataManager.bookTickets(creditCardNumber, tickets);
    }

    @WebMethod
    public ArrayList<PurchasedTicket> issueTickets(Receipt receipt, String token) throws AuthorizationException {
        authenticationManager.authorize(token);
        return dataManager.issueTickets(receipt);
    }

    public static void main(String[] argv) {
        Object implementor = new FlightTicketReservationService();
        String address = "http://localhost:9000/kth.se.id2208.bottom_up.FlightTicketReservationService";
        Endpoint.publish(address, implementor);
    }
}
