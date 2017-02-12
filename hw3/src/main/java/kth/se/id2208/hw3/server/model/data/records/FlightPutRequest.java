package kth.se.id2208.hw3.server.model.data.records;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Kim Hammar on 2017-02-09.
 */
@XmlRootElement
public class FlightPutRequest {
    private Flight flight;


    public FlightPutRequest(){

    }

    public Flight getFlight() {
        return flight;
    }

    @XmlElement(name="flight")
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public FlightPutRequest(Flight flight) {
        this.flight = flight;
    }
}
