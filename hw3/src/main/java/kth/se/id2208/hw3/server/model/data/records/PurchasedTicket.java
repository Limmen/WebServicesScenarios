package kth.se.id2208.hw3.server.model.data.records;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * PurchasedTicket POJO, will be marshalled of XML and transferred over the wire for certain operations
 *
 * @author Kim Hammar on 2017-02-03.
 */

@XmlRootElement(name="PurchasedTicket")
public class PurchasedTicket {

    private Receipt receipt;
    private Ticket ticket;

    public PurchasedTicket(){}

    public PurchasedTicket(Receipt receipt, Ticket ticket) {
        this.receipt = receipt;
        this.ticket = ticket;
    }

    @XmlElement(name = "Receipt")
    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Ticket getTicket() {
        return ticket;
    }

    @XmlElement(name = "Ticket")
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Receipt getReceipt() {
        return receipt;
    }

}
