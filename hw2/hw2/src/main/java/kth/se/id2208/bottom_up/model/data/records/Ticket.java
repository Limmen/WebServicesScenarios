package kth.se.id2208.bottom_up.model.data.records;

import java.util.Date;

/**
 * @author Kim Hammar on 2017-02-03.
 */
public class Ticket {

    private Flight flight;
    private float price;
    private Date date = new Date();

    public Ticket(Flight flight, float price) {
        this.flight = flight;
        this.price = price;
    }

    public Flight getFlight() {
        return flight;
    }

    public float getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString(){
        return "#ticket " + flight.toString() + "price: " + price;
    }
}
