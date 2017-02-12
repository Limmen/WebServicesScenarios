package kth.se.id2208.hw3.server.model.data.records;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author Kim Hammar on 2017-02-12.
 */
@XmlRootElement
public class SearchTicketRequest {

    private Itinerary itinerary;
    private Date date;

    public SearchTicketRequest(Itinerary itinerary, Date date) {
        this.itinerary = itinerary;
        this.date = date;
    }

    public SearchTicketRequest(){

    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    @XmlElement(name="itinerary")
    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public Date getDate() {
        return date;
    }

    @XmlElement(name="date")
    public void setDate(Date date) {
        this.date = date;
    }
}
