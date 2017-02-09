package kth.se.id2208.hw3.server.model.data;


import kth.se.id2208.hw3.server.model.data.records.*;
import kth.se.id2208.hw3.server.model.faults.TicketNotAvailable;

import java.util.ArrayList;
import java.util.Date;

/**
 * DataManager for this scenario, acts as a sample database and exposes an API for the data.
 *
 * @author Kim Hammar on 2017-02-03.
 */
public class DataManager {

    private ArrayList<Flight> flights = new ArrayList();
    private ArrayList<PurchasedTicket> purchasedTickets = new ArrayList();
    private ArrayList<Receipt> receipts = new ArrayList();
    private ArrayList<Ticket> tickets = new ArrayList();
    private static DataManager instance = null;

    private DataManager() {
        flights.add(new Flight("Stockholm", "Paris"));
        flights.add(new Flight("Stockholm", "Madrid"));
        flights.add(new Flight("Paris", "Madrid"));
        flights.add(new Flight("Madrid", "Mumbai"));

        tickets.add(new Ticket(flights.get(0), 100));
        tickets.add(new Ticket(flights.get(1), 150));
        tickets.add(new Ticket(flights.get(3), 300));
    }

    /**
     * Returns singleton instance
     *
     * @return
     */
    public static DataManager getInstance() {
        if (instance == null)
            instance = new DataManager();
        return instance;
    }

    /**
     * Returns priceList for all itineraries. Price of a itinerary is the sum of price of all flights.
     *
     * @return List of PriceEntrys
     */
    public ArrayList<PriceEntry> getPriceList() {
        ArrayList<PriceEntry> priceList = new ArrayList();
        ArrayList<Itinerary> initiaries = getAllItineraries();
        for (Itinerary itinerary : initiaries) {
            try {
                float price = itinerary.getPrice(tickets);
                priceList.add(new PriceEntry(itinerary, price));
            } catch (TicketNotAvailable ticketNotAvailable) {
            }
        }
        return priceList;
    }

    /**
     * Issue tickets given a receiptId
     *
     * @param receipt
     * @return List of PurchasedTickets
     */
    public ArrayList<PurchasedTicket> issueTickets(Receipt receipt) {
        ArrayList<PurchasedTicket> issuedTickets = new ArrayList();
        for (PurchasedTicket purchasedTicket : purchasedTickets) {
            if (purchasedTicket.getReceipt().getReceiptId() == receipt.getReceiptId())
                issuedTickets.add(purchasedTicket);
        }
        return issuedTickets;
    }

    public Receipt bookTickets(int creditCardNumber, ArrayList<Ticket> tickets) {
        Receipt receipt = new Receipt(creditCardNumber, tickets);
        for (Ticket ticket : tickets) {
            PurchasedTicket purchasedTicket = new PurchasedTicket(receipt, ticket);
            purchasedTickets.add(purchasedTicket);
        }
        return receipt;
    }

    /**
     * Returns all availabletickets for a given itinerary and date
     *
     * @param itinerary
     * @param date
     * @return List of tickets
     */
    public ArrayList<Ticket> getAvailableTickets(Itinerary itinerary, Date date) {
        ArrayList<Ticket> availableTickets = new ArrayList();
        for (Flight flight : itinerary.getFlights()) {
            for (Ticket ticket : tickets) {
                if (ticket.getFlight().equals(flight))
                    availableTickets.add(ticket);
            }
        }
        return availableTickets;
    }

    /**
     * Gets all itineraries
     *
     * @return List of itineraries
     */
    public ArrayList<Itinerary> getAllItineraries() {
        ArrayList<Itinerary> initiaries = new ArrayList();
        initiaries.addAll(getAllItineraries("Stockholm", "Mumbai"));
        initiaries.addAll(getAllItineraries("Stockholm", "Madrid"));
        initiaries.addAll(getAllItineraries("Stockholm", "Paris"));
        initiaries.addAll(getAllItineraries("Paris", "Madrid"));
        initiaries.addAll(getAllItineraries("Madrid", "Mumbai"));
        return initiaries;
    }


    /**
     * Gets all itineraries given a departmentCity and destinationCity
     *
     * @param departmentCity
     * @param destinationCity
     * @return List of itinerary
     */
    public ArrayList<Itinerary> getAllItineraries(String departmentCity, String destinationCity) {
        boolean done = false;
        ArrayList<Itinerary> initiaries = new ArrayList<Itinerary>();
        while (!done) {
            Itinerary itinerary = getItinerary(departmentCity, destinationCity, new Itinerary(), initiaries);
            if (itinerary == null)
                done = true;
            else
                initiaries.add(itinerary);
        }
        return initiaries;
    }

    /**
     * Recusive method that generates a new itinerary if there is one that is not already in the list of itineraries
     *
     * @param currentLocation
     * @param destinationCity
     * @param itinerary
     * @param initiaries
     * @return new Itinerary
     */
    private Itinerary getItinerary(String currentLocation, String destinationCity, Itinerary itinerary, ArrayList<Itinerary> initiaries) {
        if (currentLocation.equalsIgnoreCase(destinationCity))
            return itinerary;
        else {
            for (Flight flight : flights)
                if (flight.getDepartmentCity().equalsIgnoreCase(currentLocation)) {
                    Itinerary arg = new Itinerary();
                    for (Flight fl : itinerary.getFlights()) {
                        arg.addFlight(fl);
                    }
                    arg.addFlight(flight);
                    Itinerary result = getItinerary(flight.getDestinationCity(), destinationCity, arg, initiaries);
                    if (result != null && !initiaries.contains(result))
                        return result;
                }
        }
        return null;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public ArrayList<PurchasedTicket> getPurchasedTickets() {
        return purchasedTickets;
    }

    public ArrayList<Receipt> getReceipts() {
        return receipts;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
}