package kth.se.id2208.hw3.server.resources;

import kth.se.id2208.hw3.model.data.DataManager;
import kth.se.id2208.hw3.model.data.records.Itinerary;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * @author Kim Hammar on 2017-02-08.
 */
@Path("/itineraries")
public class Itineraries {

    private DataManager dataManager = DataManager.getInstance();

    //http://localhost:8080/rest/itineraries?departmentCity=Stockholm&destinationCity=Mumbai
    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<Itinerary> getSpecificItineraries(@QueryParam("departmentCity") String departmentCity,
                                                       @QueryParam("destinationCity") String destinationCity) {
        if (departmentCity != null & destinationCity != null)
            return dataManager.getAllItineraries(departmentCity, destinationCity);
        else
            return dataManager.getAllItineraries();
    }

    @GET
    @Path("/{index}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Itinerary getItinerary(@PathParam("index") int index) {
        return dataManager.getAllItineraries().get(index);
    }

}
