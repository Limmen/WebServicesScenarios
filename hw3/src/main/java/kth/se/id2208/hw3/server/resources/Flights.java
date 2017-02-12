package kth.se.id2208.hw3.server.resources;

import kth.se.id2208.hw3.server.model.auth.AuthenticationManager;
import kth.se.id2208.hw3.server.model.data.DataManager;
import kth.se.id2208.hw3.server.model.data.records.Flight;
import kth.se.id2208.hw3.server.model.data.records.FlightPutRequest;
import kth.se.id2208.hw3.server.model.data.records.FlightsPutRequest;
import kth.se.id2208.hw3.server.model.faults.AuthorizationException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 *
 * REST resource, relative path: /flights
 *
 * @author Mallu
 */
@Path("/flights")
public class Flights {

    private DataManager dataManager = DataManager.getInstance();
    private AuthenticationManager authenticationManager = AuthenticationManager.getInstance();

    /**
     * Returns list of flights. This method is  authorized and requires security token
     *
     * @param token
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<Flight> getFlights(@QueryParam("token") String token){
        try {
            authenticationManager.authorize(token);
        } catch (AuthorizationException e) {
            throw new WebApplicationException(401); //401-Unauthorized
        }
        return dataManager.getFlights();
    }

    /**
     * Put flights, return updated resource. This method is  authorized and requires security token
     *
     * @param token
     * @param flightsPutRequest
     * @return
     */
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<Flight> putFlights(@QueryParam("token") String token, FlightsPutRequest flightsPutRequest){
        try {
            authenticationManager.authorize(token);
        } catch (AuthorizationException e) {
            throw new WebApplicationException(401); //401-Unauthorized
        }
        return dataManager.putFlights(flightsPutRequest.getFlights());
    }

    /**
     * Delete flights. This method is  authorized and requires security token
     *
     * @param token
     */
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteFlights(@QueryParam("token") String token){
        try {
            authenticationManager.authorize(token);
        } catch (AuthorizationException e) {
            throw new WebApplicationException(401); //401-Unauthorized
        }
        dataManager.deleteFlights();
    }

    /**
     * Returns flight with {index}. This method is  authorized and requires security token
     *
     * @param index
     * @param token
     * @return
     */
    @GET
    @Path("/{index}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Flight getFlight(@PathParam("index") int index, @QueryParam("token") String token) {
        try {
            authenticationManager.authorize(token);
        } catch (AuthorizationException e) {
            throw new WebApplicationException(401); //401-Unauthorized
        }
        ArrayList<Flight> flights = dataManager.getFlights();
        if (index < 0 || index > flights.size() - 1)
            throw new WebApplicationException(404);//404-Not found
        else
            return flights.get(index);
    }

    /**
     * Deletes flight with {index}. This method is  authorized and requires security token
     *
     * @param index
     * @param token
     */
    @Path("/{index}")
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteFlights(@PathParam("index") int index, @QueryParam("token") String token){
        try {
            authenticationManager.authorize(token);
        } catch (AuthorizationException e) {
            throw new WebApplicationException(401); //401-Unauthorized
        }
        dataManager.deleteFlight(index);
    }

    /**
     * Puts flight with {index}, returns updated resource. This method is  authorized and requires security token
     *
     * @param index
     * @param token
     * @param flightPutRequest
     * @return
     */
    @Path("/{index}")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Flight putFlights(@PathParam("index") int index, @QueryParam("token") String token, FlightPutRequest flightPutRequest){
        try {
            authenticationManager.authorize(token);
        } catch (AuthorizationException e) {
            throw new WebApplicationException(401); //401-Unauthorized
        }
        return dataManager.putFlight(flightPutRequest.getFlight(), index);
    }
}
