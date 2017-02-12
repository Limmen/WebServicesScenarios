package kth.se.id2208.hw3.server.resources;

import kth.se.id2208.hw3.server.model.auth.AuthenticationManager;
import kth.se.id2208.hw3.server.model.data.DataManager;
import kth.se.id2208.hw3.server.model.data.records.Itinerary;
import kth.se.id2208.hw3.server.model.faults.AuthorizationException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * REST resource, relative path: /itineraries
 *
 * @author Kim Hammar on 2017-02-08.
 */
@Path("/itineraries")
public class Itineraries {

    private DataManager dataManager = DataManager.getInstance();
    private AuthenticationManager authenticationManager = AuthenticationManager.getInstance();

    /**
     * Returns the list of itineraries, sorting, authorization etc can be done through query parameters.
     * Requester can specify query param departmentCity and destinationCity to get all itineraries from
     * departmentCity to destinationCity. This method is  authorized and requires security token.
     *
     * @param departmentCity
     * @param destinationCity
     * @param token
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<Itinerary> getItineraries(@QueryParam("departmentCity") String departmentCity,
                                               @QueryParam("destinationCity") String destinationCity,
                                               @QueryParam("token") String token) {
        try {
            authenticationManager.authorize(token);
        } catch (AuthorizationException e) {
            throw new WebApplicationException(401); //401-Unauthorized
        }
        if (departmentCity != null & destinationCity != null)
            return dataManager.getAllItineraries(departmentCity, destinationCity);
        else
            return dataManager.getAllItineraries();
    }

    /**
     * Returns itinerary with {index}. This method is  authorized and requires security token
     *
     * @param index
     * @param token
     * @return
     */
    @GET
    @Path("/{index}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Itinerary getItinerary(@PathParam("index") int index, @QueryParam("token") String token) {
        try {
            authenticationManager.authorize(token);
        } catch (AuthorizationException e) {
            throw new WebApplicationException(401); //401-Unauthorized
        }
        ArrayList<Itinerary> itineraries = dataManager.getAllItineraries();
        if (index < 0 || index > itineraries.size() - 1)
            throw new WebApplicationException(404);//404-Not found
        else
            return itineraries.get(index);
    }

}
