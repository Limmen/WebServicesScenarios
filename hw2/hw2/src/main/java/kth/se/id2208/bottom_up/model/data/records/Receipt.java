package kth.se.id2208.bottom_up.model.data.records;

import java.util.ArrayList;

/**
 * @author Kim Hammar on 2017-02-03.
 */
public class Receipt {

    private int creditCardNumber;
    private ArrayList<Ticket> tickets;
    public static int receiptId = 0;

    /**
     * no-arg constructor required for JAXB
     */
    public Receipt(){

    }

    public Receipt(int creditCardNumber, ArrayList<Ticket> tickets) {
        this.creditCardNumber = creditCardNumber;
        this.tickets = tickets;
        receiptId++;
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
