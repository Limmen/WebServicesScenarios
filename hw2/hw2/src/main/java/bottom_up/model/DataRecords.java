package bottom_up.model;

import java.util.ArrayList;

/**
 * @author Kim Hammar on 2017-02-03.
 */
public class DataRecords {

    private ArrayList<Flight> flights = new ArrayList();
    private ArrayList<Initiary> initiaries = new ArrayList();
    private ArrayList<PurchasedTicket> purchasedTickets = new ArrayList();
    private ArrayList<Receipt> receipts = new ArrayList();
    private ArrayList<Ticket> tickets;

    public DataRecords(){
        flights.add(new Flight("Stockholm", "Paris"));
        flights.add(new Flight("Stockholm", "Madrid"));
        flights.add(new Flight("Paris", "Madrid"));
        flights.add(new Flight("Madrid", "Mumbai"));

    }

    public void addInitiaries(ArrayList<Initiary> initiaries){
        for(Initiary initiary : initiaries){
            initiaries.add(initiary);
        }
    }
}
