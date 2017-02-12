package kth.se.id2208.hw3.server.model.data.records;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * @author Kim Hammar on 2017-02-09.
 */
@XmlRootElement
public class TicketsPutRequest {
    private ArrayList<Ticket> tickets;

    public TicketsPutRequest(){

    }

    public TicketsPutRequest(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    @XmlElement(name="tickets")
    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }
}
