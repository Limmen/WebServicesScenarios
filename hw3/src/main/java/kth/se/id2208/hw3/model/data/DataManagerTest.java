package kth.se.id2208.hw3.model.data;
import kth.se.id2208.hw3.model.data.records.*;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Date;

/**
 * Unit-test suite for the DataManager
 *
 * @author Kim Hammar on 2017-02-03.
 */
public class DataManagerTest {

    private DataManager dataManager;

    @org.junit.Before
    public void setUp() throws Exception {
        dataManager = DataManager.getInstance();
    }

    @org.junit.Test
    public void testGetPriceList() throws Exception {
        ArrayList<PriceEntry> priceList = dataManager.getPriceList();
        dataManager.getPriceList();
        Assert.assertEquals(4, priceList.size());
        for(PriceEntry priceEntry : priceList){
            if(priceEntry.getItinerary().getFlights().size() == 2){
                Assert.assertEquals(450.0f, priceEntry.getPrice(), 0.0f);
            }
        }
    }

    @org.junit.Test
    public void testIssueTickets() throws Exception {
        Receipt receipt = dataManager.bookTickets(1337, dataManager.getTickets());
        ArrayList<PurchasedTicket> issuedTickets = dataManager.issueTickets(receipt);
        Assert.assertEquals(issuedTickets.size(), dataManager.getTickets().size());
        for (PurchasedTicket purchasedTicket : issuedTickets) {
            Assert.assertEquals(purchasedTicket.getReceipt(), receipt);
        }
    }

    @org.junit.Test
    public void testBookTickets() throws Exception {
        Receipt receipt = dataManager.bookTickets(1337, dataManager.getTickets());
        Assert.assertEquals(dataManager.getTickets().size(), dataManager.getPurchasedTickets().size());
        Assert.assertEquals(receipt.getCreditCardNumber(), 1337);
        Assert.assertEquals(receipt.getTickets().size(), dataManager.getTickets().size());

    }

    @org.junit.Test
    public void testGetAvailableTickets() throws Exception {
        ArrayList<Ticket> availableTickets = dataManager.getAvailableTickets(dataManager.getAllItineraries("Stockholm", "Paris").get(0), new Date());
        Assert.assertEquals(1, availableTickets.size());
        availableTickets = dataManager.getAvailableTickets(dataManager.getAllItineraries("Paris", "Madrid").get(0), new Date());
        Assert.assertEquals(0, availableTickets.size());
        availableTickets = dataManager.getAvailableTickets(dataManager.getAllItineraries("Stockholm", "Mumbai").get(0), new Date());
        Assert.assertEquals(2, availableTickets.size());
    }

    @org.junit.Test
    public void testGetAllInitiaries() throws Exception {
        ArrayList<Itinerary> initiaries = dataManager.getAllItineraries();
        Assert.assertEquals(7, initiaries.size());
    }

    @org.junit.Test
    public void testGetAllInitiaries1() throws Exception {
        ArrayList<Itinerary> initiaries = dataManager.getAllItineraries("Stockholm", "Mumbai");
        Assert.assertEquals(2, initiaries.size());
        initiaries = dataManager.getAllItineraries("Stockholm", "Madrid");
        Assert.assertEquals(2, initiaries.size());
        initiaries = dataManager.getAllItineraries("Stockholm", "Paris");
        Assert.assertEquals(1, initiaries.size());
    }
}