package kth.se.id2208.hw3.server.resources;

import kth.se.id2208.hw3.server.model.auth.AuthenticationManager;
import kth.se.id2208.hw3.server.model.data.DataManager;
import kth.se.id2208.hw3.server.model.data.records.PurchasedTicket;
import kth.se.id2208.hw3.server.model.faults.AuthorizationException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * @author Kim Hammar on 2017-02-12.
 */
@Path("/purchasedtickets")
public class PurchasedTickets {
    private DataManager dataManager = DataManager.getInstance();
    private AuthenticationManager authenticationManager = AuthenticationManager.getInstance();

    /**
     * Returns list of tickets purchased by receiptId. This method is  authorized and requires security token
     *
     * @param token
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<PurchasedTicket> getTickets(@QueryParam("token") String token,
                                                 @QueryParam("receiptId") int receiptId){
        try {
            authenticationManager.authorize(token);
        } catch (AuthorizationException e) {
            throw new WebApplicationException(401); //401-Unauthorized
        }
        return dataManager.issueTickets(receiptId);
    }
}
