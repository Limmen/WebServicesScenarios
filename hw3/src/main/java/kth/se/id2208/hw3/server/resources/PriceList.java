package kth.se.id2208.hw3.server.resources;

import kth.se.id2208.hw3.model.data.DataManager;
import kth.se.id2208.hw3.model.data.records.PriceEntry;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * @author Kim Hammar on 2017-02-08.
 */
@Path("/pricelist")
public class PriceList {
    private DataManager dataManager = DataManager.getInstance();

    @Path("")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<PriceEntry> getPriceList(){
        return dataManager.getPriceList();
    }
}
