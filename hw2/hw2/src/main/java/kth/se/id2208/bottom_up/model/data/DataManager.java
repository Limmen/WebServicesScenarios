package kth.se.id2208.bottom_up.model.data;

import kth.se.id2208.bottom_up.faults.TicketNotAvailable;
import kth.se.id2208.bottom_up.model.data.records.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Kim Hammar on 2017-02-03.
 */
public class DataManager {

    private ArrayList<Flight> flights = new ArrayList();
    private ArrayList<PurchasedTicket> purchasedTickets = new ArrayList();
    private ArrayList<Receipt> receipts = new ArrayList();
    private ArrayList<Ticket> tickets = new ArrayList();

    public DataManager() {
        Flight flight = new Flight();
        flight.setDepartmentCity("Stockholm");
        flight.setDestinationCity("Paris");
        flights.add(flight);
        flight = new Flight();
        flight.setDepartmentCity("Stockholm");
        flight.setDestinationCity("Madrid");
        flights.add(flight);
        flight = new Flight();
        flight.setDepartmentCity("Paris");
        flight.setDestinationCity("Madrid");
        flights.add(flight);
        /*
        flights.add(new Flight("Stockholm", "Paris"));
        flights.add(new Flight("Stockholm", "Madrid"));
        flights.add(new Flight("Paris", "Madrid"));
        flights.add(new Flight("Madrid", "Mumbai"));
        */
        tickets.add(new Ticket(flights.get(0), 100));
//        tickets.add(new Ticket(flights.get(1), 150));
//        tickets.add(new Ticket(flights.get(3), 300));
    }

    public ArrayList<PriceEntry> getPriceList() {
        ArrayList<PriceEntry> priceList = new ArrayList();
        ArrayList<Initiary> initiaries = getAllInitiaries();
        for(Initiary initiary : initiaries){
            try {
                float price = initiary.getPrice(tickets);
                priceList.add(new PriceEntry(initiary, price));
            } catch (TicketNotAvailable ticketNotAvailable) {
            }
        }
        return priceList;
    }

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
            PurchasedTicket purchasedTicket = new PurchasedTicket(ticket, receipt);
            purchasedTickets.add(purchasedTicket);
        }
        return receipt;
    }

    public ArrayList<Ticket> getAvailableTickets(Initiary initiary, Date date) {
        ArrayList<Ticket> availableTickets = new ArrayList();
        for (Flight flight : initiary.getFlights()) {
            for (Ticket ticket : tickets) {
                if (ticket.getFlight().equals(flight))
                    availableTickets.add(ticket);
            }
        }
        return availableTickets;
    }

    public ArrayList<Initiary> getAllInitiaries() {
        ArrayList<Initiary> initiaries = new ArrayList();
        initiaries.addAll(getAllInitiaries("Stockholm", "Mumbai"));
        initiaries.addAll(getAllInitiaries("Stockholm", "Madrid"));
        initiaries.addAll(getAllInitiaries("Stockholm", "Paris"));
        initiaries.addAll(getAllInitiaries("Paris", "Madrid"));
        initiaries.addAll(getAllInitiaries("Madrid", "Mumbai"));
        return initiaries;
    }

    public ArrayList<Initiary> getAllInitiaries(String departmentCity, String destinationCity) {
        boolean done = false;
        ArrayList<Initiary> initiaries = new ArrayList<Initiary>();
        while (!done) {
            Initiary initiary = getInitiary(departmentCity, destinationCity, new Initiary(), initiaries);
            if (initiary == null)
                done = true;
            else
                initiaries.add(initiary);
        }
        return initiaries;
    }

    private Initiary getInitiary(String currentLocation, String destinationCity, Initiary initiary, ArrayList<Initiary> initiaries) {
        if (currentLocation.equalsIgnoreCase(destinationCity))
            return initiary;
        else {
            for (Flight flight : flights)
                if (flight.getDepartmentCity().equalsIgnoreCase(currentLocation)) {
                    Initiary arg = new Initiary();
                    for(Flight fl : initiary.getFlights()){
                        arg.addFlight(fl);
                    }
                    arg.addFlight(flight);
                    Initiary result = getInitiary(flight.getDestinationCity(), destinationCity, arg, initiaries);
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
