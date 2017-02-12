package kth.se.id2208.hw3.server.model.data.records;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * @author Kim Hammar on 2017-02-09.
 */
@XmlRootElement
public class FlightsPutRequest {
    private ArrayList<Flight> flights;

    public FlightsPutRequest(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public FlightsPutRequest(){

    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    @XmlElement(name="flights")
    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }
}
