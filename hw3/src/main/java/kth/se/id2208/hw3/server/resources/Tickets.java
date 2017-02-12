package kth.se.id2208.hw3.server.resources;

import kth.se.id2208.hw3.server.model.auth.AuthenticationManager;
import kth.se.id2208.hw3.server.model.data.DataManager;
import kth.se.id2208.hw3.server.model.data.records.*;
import kth.se.id2208.hw3.server.model.faults.AuthorizationException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * REST resource, relative path: /tickets
 *
 * @author Kim Hammar
 */
@Path("/tickets")
public class Tickets {

    private DataManager dataManager = DataManager.getInstance();
    private AuthenticationManager authenticationManager = AuthenticationManager.getInstance();

    /**
     * Returns list of tickets. This method is  authorized and requires security token
     *
     * @param token
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<Ticket> getTickets(@QueryParam("token") String token) {
        try {
            authenticationManager.authorize(token);
        } catch (AuthorizationException e) {
            throw new WebApplicationException(401); //401-Unauthorized
        }
        return dataManager.getTickets();
    }

    /**
     * Returns list of tickets. This method is  authorized and requires security token
     *
     * @param token
     * @return
     */
    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<Ticket> getTickets(@QueryParam("token") String token, SearchTicketRequest searchTicketRequest) {
        try {
            authenticationManager.authorize(token);
        } catch (AuthorizationException e) {
            throw new WebApplicationException(401); //401-Unauthorized
        }
        return dataManager.getAvailableTickets(searchTicketRequest.getItinerary(), searchTicketRequest.getDate());
    }

    /**
     * Put tickets, return updated resource. This method is  authorized and requires security token
     *
     * @param token
     * @param ticketsPutRequest
     * @return
     */
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<Ticket> putTickets(@QueryParam("token") String token, TicketsPutRequest ticketsPutRequest) {
        try {
            authenticationManager.authorize(token);
        } catch (AuthorizationException e) {
            throw new WebApplicationException(401); //401-Unauthorized
        }
        return dataManager.putTickets(ticketsPutRequest.getTickets());
    }

    /**
     * Delete tickets. This method is  authorized and requires security token
     *
     * @param token
     */
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteTickets(@QueryParam("token") String token) {
        try {
            authenticationManager.authorize(token);
        } catch (AuthorizationException e) {
            throw new WebApplicationException(401); //401-Unauthorized
        }
        dataManager.deleteTickets();
    }

    /**
     * Returns ticket with {index}. This method is  authorized and requires security token
     *
     * @param index
     * @param token
     * @return
     */
    @GET
    @Path("/{index}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Ticket getTicket(@PathParam("index") int index, @QueryParam("token") String token) {
        try {
            authenticationManager.authorize(token);
        } catch (AuthorizationException e) {
            throw new WebApplicationException(401); //401-Unauthorized
        }
        ArrayList<Ticket> tickets = dataManager.getTickets();
        if (index < 0 || index > tickets.size() - 1)
            throw new WebApplicationException(404);//404-Not found
        else
            return tickets.get(index);
    }

    /**
     * Deletes ticket with {index}. This method is  authorized and requires security token
     *
     * @param index
     * @param token
     */
    @Path("/{index}")
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteTickets(@PathParam("index") int index, @QueryParam("token") String token) {
        try {
            authenticationManager.authorize(token);
        } catch (AuthorizationException e) {
            throw new WebApplicationException(401); //401-Unauthorized
        }
        ArrayList<Ticket> tickets = dataManager.getTickets();
        if (index < 0 || index > tickets.size() - 1)
            throw new WebApplicationException(404);//404-Not found
        else
            dataManager.deleteTicket(index);
    }

    /**
     * Puts ticket with {index}, returns updated resource. This method is  authorized and requires security token
     *
     * @param index
     * @param token
     * @param ticketPutRequest
     * @return
     */
    @Path("/{index}")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Ticket putTicket(@PathParam("index") int index, @QueryParam("token") String token, TicketPutRequest ticketPutRequest) {
        try {
            authenticationManager.authorize(token);
        } catch (AuthorizationException e) {
            throw new WebApplicationException(401); //401-Unauthorized
        }
        ArrayList<Ticket> tickets = dataManager.getTickets();
        if (index < 0 || index > tickets.size() - 1)
            throw new WebApplicationException(404);//404-Not found
        else
            return dataManager.putTicket(ticketPutRequest.getTicket(), index);
    }
}
