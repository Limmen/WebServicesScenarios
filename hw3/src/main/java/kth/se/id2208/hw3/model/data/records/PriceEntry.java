package kth.se.id2208.hw3.model.data.records;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * PriceEntry POJO, will be marshalled of XML and transferred over the wire for certain operations
 *
 * @author Kim Hammar on 2017-02-03.
 */
@XmlRootElement(name="PriceEntry")
public class PriceEntry {
    private Itinerary itinerary;
    private float price;

    public PriceEntry(Itinerary itinerary, float price) {
        this.itinerary = itinerary;
        this.price = price;
    }

    public PriceEntry(){

    }

    @XmlElement(name = "Itinerary")
    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    @XmlElement(name = "Price")
    public void setPrice(float price) {
        this.price = price;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public float getPrice() {
        return price;
    }
}
