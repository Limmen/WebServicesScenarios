package kth.se.id2208.hw3.server.model.data.records;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Kim Hammar on 2017-02-09.
 */
@XmlRootElement
public class TicketPutRequest {
    private Ticket ticket;


    public TicketPutRequest(){

    }

    public TicketPutRequest(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    @XmlElement(name="ticket")
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
