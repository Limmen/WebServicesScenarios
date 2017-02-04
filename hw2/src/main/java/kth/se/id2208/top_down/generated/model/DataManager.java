package kth.se.id2208.top_down.generated.model;

import kth.se.id2208.top_down.generated.artifacts.GetPriceListResponse;
import kth.se.id2208.top_down.generated.artifacts.ItineraryType;

import java.util.ArrayList;

/**
 *
 * DataManager for this scenario, acts as a sample database and exposes an API for the data.
 *
 * @author Kim Hammar on 2017-02-03.
 */
public class DataManager {

    private ArrayList<ItineraryType.Flights> flights = new ArrayList();

    public DataManager() {
        ItineraryType.Flights flight = new ItineraryType.Flights();
        flight.setDepartmentCity("Stockholm");
        flight.setDestinationCity("Madrid");
        flights.add(flight);
    }

    /**
     * Returns priceList for all itineraries. Price of a itinerary is the sum of price of all flights.
     *
     * @return List of PriceEntrys
     */
    public ArrayList<GetPriceListResponse.Return> getPriceList() {
        ArrayList<GetPriceListResponse.Return> priceList = new ArrayList();
        ArrayList<ItineraryType> initiaries = getAllItineraries();
        for (ItineraryType itinerary : initiaries) {
            float price = 150;
            GetPriceListResponse.Return priceEntry = new GetPriceListResponse.Return();
            priceEntry.setItinerary(itinerary);
            priceEntry.setPrice(price);
            priceList.add(priceEntry);
        }
        return priceList;
    }

    /**
     * Gets all itineraries
     *
     * @return List of itineraries
     */
    public ArrayList<ItineraryType> getAllItineraries() {
        ArrayList<ItineraryType> initiaries = new ArrayList();
        initiaries.addAll(getAllItineraries("Stockholm", "Madrid"));
        return initiaries;
    }

    /**
     * Gets all itineraries given a departmentCity and destinationCity
     *
     * @param departmentCity
     * @param destinationCity
     * @return List of itinerary
     */
    public ArrayList<ItineraryType> getAllItineraries(String departmentCity, String destinationCity) {
        boolean done = false;
        ArrayList<ItineraryType> initiaries = new ArrayList<ItineraryType>();
        while (!done) {
            ItineraryType itinerary = getItinerary(departmentCity, destinationCity, new ItineraryType(), initiaries);
            if (itinerary == null)
                done = true;
            else
                initiaries.add(itinerary);
        }
        return initiaries;
    }

    /**
     * Recusive method that generates a new itinerary if there is one that is not already in the list of itineraries
     *
     * @param currentLocation
     * @param destinationCity
     * @param itinerary
     * @param initiaries
     * @return new Itinerary
     */
    private ItineraryType getItinerary(String currentLocation, String destinationCity, ItineraryType itinerary, ArrayList<ItineraryType> initiaries) {
        if (currentLocation.equalsIgnoreCase(destinationCity))
            return itinerary;
        else {
            for (ItineraryType.Flights flight : flights)
                if (flight.getDepartmentCity().equalsIgnoreCase(currentLocation)) {
                    ItineraryType arg = new ItineraryType();
                    for (ItineraryType.Flights fl : itinerary.getFlights()) {
                        arg.getFlights().add(fl);
                    }
                    arg.getFlights().add(flight);
                    ItineraryType result = getItinerary(flight.getDestinationCity(), destinationCity, arg, initiaries);
                    if (result != null && !initiaries.contains(result))
                        return result;
                }
        }
        return null;
    }

    public ArrayList<ItineraryType.Flights> getFlights() {
        return flights;
    }

}
