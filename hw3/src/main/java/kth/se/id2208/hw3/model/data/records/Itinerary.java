package kth.se.id2208.hw3.model.data.records;

import kth.se.id2208.hw3.model.faults.TicketNotAvailable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Itinerary POJO, will be marshalled of XML and transferred over the wire for certain operations
 *
 * @author Kim Hammar on 2017-02-03.
 */
@XmlRootElement(name="Itinerary")
public class Itinerary {

    private ArrayList<Flight> flights = new ArrayList<Flight>();

    public Itinerary(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public Itinerary(){}

    public float getPrice(ArrayList<Ticket> tickets) throws TicketNotAvailable {
        float price = 0;
        for (Flight flight : flights) {
            boolean ticketAvail = false;
            for (Ticket ticket : tickets) {
                if (ticket.getFlight().equals(flight)) {
                    price = price + ticket.getPrice();
                    ticketAvail = true;
                    break;
                }
            }
            if (!ticketAvail)
                throw new TicketNotAvailable("ticket not available");
        }
        return price;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    @XmlElement(name = "Flights")
    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    @Override
    public boolean equals(Object obj) {
        Itinerary itinerary = (Itinerary) obj;
        return itinerary.getFlights().equals(flights);
    }

}
