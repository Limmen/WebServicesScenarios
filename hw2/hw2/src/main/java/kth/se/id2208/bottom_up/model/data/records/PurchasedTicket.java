package kth.se.id2208.bottom_up.model.data.records;

/**
 * @author Kim Hammar on 2017-02-03.
 */
public class PurchasedTicket extends Ticket {

    private Receipt receipt;

    public PurchasedTicket(Flight flight, float price, Receipt receipt) {
        super(flight, price);
        this.receipt = receipt;
    }

    public PurchasedTicket(Ticket ticket, Receipt receipt) {
        super(ticket.getFlight(), ticket.getPrice());
        this.receipt = receipt;
    }

    public Receipt getReceipt() {
        return receipt;
    }

}
