package kth.se.id2208.hw3.server.model.data.records;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Receipt POJO, will be marshalled of XML and transferred over the wire for certain operations
 *
 * @author Kim Hammar on 2017-02-03.
 */
@XmlRootElement(name="Receipt")
public class Receipt {

    private int creditCardNumber;
    private ArrayList<Ticket> tickets;
    public static int staticReferenceCounter = 0;
    private int receiptId;

    public Receipt(){
        receiptId = staticReferenceCounter;
        staticReferenceCounter++;
    }

    public Receipt(int creditCardNumber, ArrayList<Ticket> tickets) {
        this.creditCardNumber = creditCardNumber;
        this.tickets = tickets;
        receiptId = staticReferenceCounter;
        staticReferenceCounter++;
    }

    @XmlElement(name = "CreditCardNumber")
    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @XmlElement(name = "Tickets")
    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    @XmlElement(name = "ReceiptId")
    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public int getReceiptId() {
        return receiptId;
    }
}
