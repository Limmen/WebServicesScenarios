package kth.se.id2208.hw3.server.resources;

import kth.se.id2208.hw3.server.model.auth.AuthenticationManager;
import kth.se.id2208.hw3.server.model.data.DataManager;
import kth.se.id2208.hw3.server.model.data.records.BookTicketRequest;
import kth.se.id2208.hw3.server.model.data.records.Receipt;
import kth.se.id2208.hw3.server.model.faults.AuthorizationException;
import kth.se.id2208.hw3.server.model.faults.TicketNotAvailable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * REST resource, relative path: /bookticket
 *
 * @author Mallu
 */
@Path("/bookticket")
public class BookTicket {

    private AuthenticationManager authenticationManager = AuthenticationManager.getInstance();
    private DataManager dataManager = DataManager.getInstance();

    /**
     * Book ticket, returns receipt. This method is  authorized and requires security token
     *
     * @param bookTicketRequest - contains creditCardNumber and tickets
     * @return
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Receipt book(@QueryParam("token") String token, BookTicketRequest bookTicketRequest) {
        try {
            authenticationManager.authorize(token);
        } catch (AuthorizationException e) {
            throw new WebApplicationException(401); //401-Unauthorized
        }
        try {
            Receipt receipt = dataManager.bookTickets(bookTicketRequest.getCreditCardNumber(), bookTicketRequest.getTickets());
            return  receipt;
        } catch (TicketNotAvailable ticketNotAvailable) {
            throw new WebApplicationException(403); //Forbidden, request was understood, but cannot be served.
        }
    }

}
