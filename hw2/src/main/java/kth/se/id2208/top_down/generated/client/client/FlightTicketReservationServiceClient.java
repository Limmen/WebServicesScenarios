package kth.se.id2208.top_down.generated.client.client;

import kth.se.id2208.top_down.generated.client.*;

import java.util.ArrayList;

/**
 * @author Kim Hammar on 2017-02-04.
 */
public class FlightTicketReservationServiceClient {
  public static void main(String[] argv) {
    FlightTicketReservationPortType service = new FlightTicketReservationServiceTopDown().getFlightTicketReservationPortTypePort();
    //invoke business method
      try {
          String AUTH_TOKEN = service.login("kim", "id2208");
          System.out.println("Successfully logged in as user 'kim', AUTH_TOKEN received:" + AUTH_TOKEN);
          System.out.print("Looking up price-list of all itineraries...");
          ArrayList<GetPriceListResponse.Return> priceList = (ArrayList) service.getPriceList(AUTH_TOKEN);
          System.out.println("SUCCESS! Price list:");
          printPriceList(priceList);
          System.out.print("Querying for  itinerary from Stockholm to Madrid...");
          ArrayList<ItineraryType> itineraries = (ArrayList) service.getItineraries("Stockholm", "Madrid", AUTH_TOKEN);
          System.out.println("SUCCESS! itineraries received: ");
          printItineraries(itineraries);
      } catch (AuthorizationExceptionException e) {
          e.printStackTrace();
      }
  }

    private static void printPriceList(ArrayList<kth.se.id2208.top_down.generated.client.GetPriceListResponse.Return> priceList) {
        for (kth.se.id2208.top_down.generated.client.GetPriceListResponse.Return priceEntry : priceList) {
            System.out.print("Price: " + priceEntry.getPrice() + "$  ");
            ItineraryType itinerary = priceEntry.getItinerary();
            if (itinerary.getFlights().size() > 0)
                System.out.print(itinerary.getFlights().get(0).getDepartmentCity());
            for (ItineraryType.Flights flight : itinerary.getFlights()) {
                System.out.print(" - " + flight.getDestinationCity());
            }
            System.out.print("\n");
        }
    }

    private static void printItineraries(ArrayList<ItineraryType> itineraries) {
        for (ItineraryType itinerary : itineraries) {
            if (itinerary.getFlights().size() > 0)
                System.out.print(itinerary.getFlights().get(0).getDepartmentCity());
            for (ItineraryType.Flights flight : itinerary.getFlights()) {
                System.out.print(" - " + flight.getDestinationCity());
            }
            System.out.print("\n");
        }
    }
}
