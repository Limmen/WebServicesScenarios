package client;/**
 * @author Kim Hammar on 2017-02-03.
 */
public class FlightTicketReservationServiceClient {
  public static void main(String[] argv) {
      client.FlightTicketReservationService service = new FlightTicketReservationServiceService().getFlightTicketReservationServicePort();
      //invoke business method
      service.sayHelloWorldFrom("kim");
  }
}
