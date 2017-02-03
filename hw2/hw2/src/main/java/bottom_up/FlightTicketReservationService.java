package bottom_up;

import bottom_up.faults.AuthorizationException;
import bottom_up.model.Initiary;
import bottom_up.model.PurchasedTicket;
import bottom_up.model.Receipt;
import bottom_up.model.Ticket;

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

    private static String SECRET_TOKEN = "ID2208_AUTH_TOKEN";

    @WebMethod
    public String sayHelloWorldFrom(String from) {
        String result = "Hello, world, from " + from;
        System.out.println(result);
        return result;
    }


    @WebMethod
    public String login(String username, String pw) throws AuthorizationException {
        if (username.equalsIgnoreCase("kim") || username.equalsIgnoreCase("mallu")) {
            if (pw.equalsIgnoreCase("id2208"))
                return SECRET_TOKEN;
            else
                throw new AuthorizationException("wrong credentials");
        } else
            throw new AuthorizationException("wrong credentials");
    }

    @WebMethod
    public ArrayList<Initiary> getInitiaries(String departureCity, String destinationCity){
        return new ArrayList<Initiary> ();
    }

    @WebMethod
    public ArrayList<Ticket> getAvailableTickets(Date date, Initiary initiary){
        return new ArrayList<Ticket>();
    }

    /**
    @WebMethod
    public HashMap<Integer, Ticket> getInitiaryPrice(){
        return new HashMap<Integer, Ticket>();
    }
**/
    @WebMethod
    public Receipt bookTickets(int creditCardNumber, ArrayList<Ticket> tickets){
        return new Receipt();
    }

    @WebMethod
    public ArrayList<PurchasedTicket> issueTickets(Receipt receipt){
        return new ArrayList<PurchasedTicket>();
    }


    public static void main(String[] argv) {
        Object implementor = new FlightTicketReservationService();
        String address = "http://localhost:9000/bottom_up.FlightTicketReservationService";
        Endpoint.publish(address, implementor);
    }


}
