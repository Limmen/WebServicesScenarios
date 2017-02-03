package client;

import java.util.ArrayList;

/**
 * @author Kim Hammar on 2017-02-03.
 */
public class FlightTicketReservationServiceClient {
    public static void main(String[] argv) {
        client.FlightTicketReservationService service = new FlightTicketReservationServiceService().getFlightTicketReservationServicePort();
        //invoke business method
        service.getFlight();
        service.getFlights();
        ArrayList<Initiary> inits = (ArrayList) service.getInitiaries2();
        System.out.println(inits.size());
        inits = (ArrayList) service.getInitiaries3(inits);
        System.out.println(inits.size());
    }
}
