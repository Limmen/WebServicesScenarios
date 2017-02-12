package kth.se.id2208.hw3.server.model.data.records;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * @author Kim Hammar on 2017-02-12.
 */
@XmlRootElement
public class BookTicketRequest {

    private int creditCardNumber;
    private ArrayList<Ticket> tickets;

    public BookTicketRequest(int creditCardNumber, ArrayList<Ticket> tickets) {
        this.creditCardNumber = creditCardNumber;
        this.tickets = tickets;
    }

    public BookTicketRequest(){

    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    @XmlElement(name="creditCardNumber")
    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
    @XmlElement(name="tickets")
    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }
}
