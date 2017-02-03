package bottom_up.model;

import java.util.ArrayList;

/**
 * @author Kim Hammar on 2017-02-03.
 */
public class Initiary {

    private ArrayList<Flight> flights = new ArrayList<Flight>();

    public Initiary(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public static ArrayList<Initiary> getAllInitiaries(String departmentCity, String destinationCity){
        return new ArrayList<Initiary>();
    }
}
