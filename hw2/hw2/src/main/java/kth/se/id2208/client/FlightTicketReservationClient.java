package kth.se.id2208.client;

import kth.se.id2208.client.artifacts.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * WebService Client consuming the FlightTicketReservationService
 *
 * @author Kim Hammar on 2017-02-04.
 */
public class FlightTicketReservationClient {
    public static void main(String[] argv) {
        FlightTicketReservationPortType service = new FlightTicketReservationService().getFlightTicketReservationPortTypePort();
        try {
            String AUTH_TOKEN = service.login("kim", "id2208");
            System.out.println("Successfully logged in as user 'kim', AUTH_TOKEN received:" + AUTH_TOKEN);
            System.out.print("Looking up price-list of all itineraries...");
            ArrayList<PriceEntry> priceList = (ArrayList) service.getPriceList(AUTH_TOKEN);
            System.out.println("SUCCESS! Price list:");
            printPriceList(priceList);
            System.out.print("Querying for  itinerary from Stockholm to Mumbai...");
            ArrayList<Itinerary> itineraries = (ArrayList) service.getItineraries("Stockholm", "Mumbai", AUTH_TOKEN);
            System.out.println("SUCCESS! itineraries received: ");
            printItineraries(itineraries);
            System.out.print("Looking up available tickets for the itinerary Stockholm-Madrid-Mumbai...");
            ArrayList<Ticket> availableTickets = (ArrayList) service.getAvailableTickets(getXMLDate(new Date()), itineraries.get(1), AUTH_TOKEN);
            System.out.println("SUCCESS! available tickets: ");
            printTickets(availableTickets);
            System.out.println("Booking tickets for itinerary Stockholm - Madrid - Mumbai...");
            Receipt receipt = service.bookTickets(1337, availableTickets, AUTH_TOKEN);
            System.out.println("SUCCESS! Received receipt: ");
            printReceipt(receipt);
            System.out.print("Request issue of booked tickets...");
            ArrayList<PurchasedTicket> purchasedTickets = (ArrayList) service.issueTickets(receipt, AUTH_TOKEN);
            System.out.println("SUCCESS! issued tickets: ");
            printIssuedTickets(purchasedTickets);

        } catch (AuthorizationException_Exception e) {
            e.printStackTrace();
        }
    }

    private static XMLGregorianCalendar getXMLDate(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void printIssuedTickets(ArrayList<PurchasedTicket> issuedTickets) {
        for (PurchasedTicket purchasedTicket : issuedTickets) {
            System.out.print("ReceiptId: " + purchasedTicket.getReceipt().getReceiptId() + " Ticket: ");
            System.out.println("#ticket " + purchasedTicket.getTicket().getFlight().getDepartmentCity() +
                    " - " + purchasedTicket.getTicket().getFlight().getDestinationCity() +
                    " price: " + purchasedTicket.getTicket().getPrice() + " date: " +
                    purchasedTicket.getTicket().getDate());
        }
    }

    private static void printReceipt(Receipt receipt) {
        System.out.println("ReceiptId: " + receipt.getReceiptId() + " CreditCardNumber: " + receipt.getCreditCardNumber()
                + " Booked tickets: ");
        printTickets((ArrayList) receipt.getTickets());
    }

    private static void printTickets(ArrayList<Ticket> availableTickets) {
        for (Ticket ticket : availableTickets) {
            System.out.println("#ticket " + ticket.getFlight().getDepartmentCity() + " - " + ticket.getFlight().getDestinationCity() +
                    " price: " + ticket.getPrice() + " date: " + ticket.getDate());
        }
    }

    private static void printItineraries(ArrayList<Itinerary> itineraries) {
        for (Itinerary itinerary : itineraries) {
            if (itinerary.getFlights().size() > 0)
                System.out.print(itinerary.getFlights().get(0).getDepartmentCity());
            for (Flight flight : itinerary.getFlights()) {
                System.out.print(" - " + flight.getDestinationCity());
            }
            System.out.print("\n");
        }
    }

    private static void printPriceList(ArrayList<PriceEntry> priceList) {
        for (PriceEntry priceEntry : priceList) {
            System.out.print("Price: " + priceEntry.getPrice() + "$  ");
            Itinerary itinerary = priceEntry.getItinerary();
            if (itinerary.getFlights().size() > 0)
                System.out.print(itinerary.getFlights().get(0).getDepartmentCity());
            for (Flight flight : itinerary.getFlights()) {
                System.out.print(" - " + flight.getDestinationCity());
            }
            System.out.print("\n");
        }
    }
}
