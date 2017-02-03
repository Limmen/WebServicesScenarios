package kth.se.id2208.bottom_up.model.data.records;

import kth.se.id2208.bottom_up.faults.TicketNotAvailable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * @author Kim Hammar on 2017-02-03.
 */
@XmlRootElement(name="Initiary")
public class Initiary {

    private ArrayList<Flight> flights = new ArrayList<Flight>();


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
        Initiary initiary = (Initiary) obj;
        return initiary.getFlights().equals(flights);
    }

}
