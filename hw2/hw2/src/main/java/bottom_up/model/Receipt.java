package bottom_up.model;

import java.util.ArrayList;

/**
 * @author Kim Hammar on 2017-02-03.
 */
public class Receipt {

    private int creditCardNumber;
    private ArrayList<Ticket> tickets;

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
}
