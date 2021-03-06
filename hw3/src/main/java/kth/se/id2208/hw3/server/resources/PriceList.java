package kth.se.id2208.hw3.server.resources;

import kth.se.id2208.hw3.server.model.auth.AuthenticationManager;
import kth.se.id2208.hw3.server.model.data.DataManager;
import kth.se.id2208.hw3.server.model.data.records.PriceEntry;
import kth.se.id2208.hw3.server.model.faults.AuthorizationException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * REST resource, relative path: /pricelist
 *
 * @author Kim Hammar on 2017-02-08.
 */
@Path("/pricelist")
public class PriceList {
    private DataManager dataManager = DataManager.getInstance();
    private AuthenticationManager authenticationManager = AuthenticationManager.getInstance();

    /**
     * Returns pricelist. This method is  authorized and requires security token
     *
     * @param token
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<PriceEntry> getPriceList(@QueryParam("token") String token){
        try {
            authenticationManager.authorize(token);
        } catch (AuthorizationException e) {
            throw new WebApplicationException(401); //401-Unauthorized
        }
        return dataManager.getPriceList();
    }
}
