package kth.se.id2208.hw3.model.data.records;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Ticket POJO, will be marshalled of XML and transferred over the wire for certain operations
 *
 * @author Kim Hammar on 2017-02-03.
 */
@XmlRootElement(name = "Ticket")
public class Ticket {

    private Flight flight;
    private float price;
    private Date date = new Date();

    public Ticket(){}

    public Ticket(Flight flight, float price) {
        this.flight = flight;
        this.price = price;
    }

    @XmlElement(name = "Flight")
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @XmlElement(name = "Price")
    public void setPrice(float price) {
        this.price = price;
    }

    public Flight getFlight() {
        return flight;
    }

    public float getPrice() {
        return price;
    }

    @XmlElement(name = "Date")
    public Date getDate() {
        return date;
    }

    @Override
    public String toString(){
        return "#ticket " + flight.toString() + "price: " + price;
    }
}
