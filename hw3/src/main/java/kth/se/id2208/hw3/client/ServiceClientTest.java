package kth.se.id2208.hw3.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import kth.se.id2208.hw3.server.model.data.records.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Test client for the RESTful FlightTicketReservationService
 *
 * @author Kim Hammar on 2017-02-09.
 */
public class ServiceClientTest {
    private ClientConfig clientConfig;
    private Client client;
    private WebResource webResource;
    private static String SECRET_TOKEN = "ID2208_AUTH_TOKEN";

    @Before
    public void setUp() throws Exception {
        clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        client = Client.create(clientConfig);
        webResource = client.resource("http://localhost:8080/rest");

    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Unit test for /itineraries resource
     */
    @Test
    public void itinerariesTest() {
        /**
         * Test plain /itineraries GET request, test JSON, XML, and test unmarshall into java object
         */
        String response = webResource.path("/itineraries").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).get(String.class);
        Assert.assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><itineraries><Itinerary><Flights><DepartmentCity>Stockholm</DepartmentCity><DestinationCity>Paris</DestinationCity></Flights><Flights><DepartmentCity>Paris</DepartmentCity><DestinationCity>Madrid</DestinationCity></Flights><Flights><DepartmentCity>Madrid</DepartmentCity><DestinationCity>Mumbai</DestinationCity></Flights></Itinerary><Itinerary><Flights><DepartmentCity>Stockholm</DepartmentCity><DestinationCity>Madrid</DestinationCity></Flights><Flights><DepartmentCity>Madrid</DepartmentCity><DestinationCity>Mumbai</DestinationCity></Flights></Itinerary><Itinerary><Flights><DepartmentCity>Stockholm</DepartmentCity><DestinationCity>Paris</DestinationCity></Flights><Flights><DepartmentCity>Paris</DepartmentCity><DestinationCity>Madrid</DestinationCity></Flights></Itinerary><Itinerary><Flights><DepartmentCity>Stockholm</DepartmentCity><DestinationCity>Madrid</DestinationCity></Flights></Itinerary><Itinerary><Flights><DepartmentCity>Stockholm</DepartmentCity><DestinationCity>Paris</DestinationCity></Flights></Itinerary><Itinerary><Flights><DepartmentCity>Paris</DepartmentCity><DestinationCity>Madrid</DestinationCity></Flights></Itinerary><Itinerary><Flights><DepartmentCity>Madrid</DepartmentCity><DestinationCity>Mumbai</DestinationCity></Flights></Itinerary></itineraries>", response);
        response = webResource.path("/itineraries").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_JSON).get(String.class);
        Assert.assertEquals("[{\"Flights\":[{\"DepartmentCity\":\"Stockholm\",\"DestinationCity\":\"Paris\"},{\"DepartmentCity\":\"Paris\",\"DestinationCity\":\"Madrid\"},{\"DepartmentCity\":\"Madrid\",\"DestinationCity\":\"Mumbai\"}]},{\"Flights\":[{\"DepartmentCity\":\"Stockholm\",\"DestinationCity\":\"Madrid\"},{\"DepartmentCity\":\"Madrid\",\"DestinationCity\":\"Mumbai\"}]},{\"Flights\":[{\"DepartmentCity\":\"Stockholm\",\"DestinationCity\":\"Paris\"},{\"DepartmentCity\":\"Paris\",\"DestinationCity\":\"Madrid\"}]},{\"Flights\":[{\"DepartmentCity\":\"Stockholm\",\"DestinationCity\":\"Madrid\"}]},{\"Flights\":[{\"DepartmentCity\":\"Stockholm\",\"DestinationCity\":\"Paris\"}]},{\"Flights\":[{\"DepartmentCity\":\"Paris\",\"DestinationCity\":\"Madrid\"}]},{\"Flights\":[{\"DepartmentCity\":\"Madrid\",\"DestinationCity\":\"Mumbai\"}]}]", response);
        ArrayList<Itinerary> itineraries = (ArrayList) webResource.path("/itineraries").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).get(new GenericType<List<Itinerary>>() {});
        Assert.assertEquals(7, itineraries.size());

        /**
         * Test /itineraries/index GET request
         */
        Itinerary itinerary = webResource.path("/itineraries/1").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_JSON).get(Itinerary.class);
        Assert.assertEquals(2, itinerary.getFlights().size());
        itinerary = webResource.path("/itineraries/2").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).get(Itinerary.class);
        Assert.assertEquals(2, itinerary.getFlights().size());
        itinerary = webResource.path("/itineraries/3").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_JSON).get(Itinerary.class);
        Assert.assertEquals(1, itinerary.getFlights().size());

        /**
         * Test /itineraries GET request with query params for filtering
         */
        itineraries = (ArrayList) webResource.path("/itineraries")
                .queryParam("token", SECRET_TOKEN)
                .queryParam("departmentCity", "Stockholm")
                .queryParam("destinationCity", "Mumbai")
                .accept(MediaType.APPLICATION_XML)
                .get(new GenericType<List<Itinerary>>() {
                });
        Assert.assertEquals(2, itineraries.size());
        itineraries = (ArrayList) webResource.path("/itineraries")
                .queryParam("token", SECRET_TOKEN)
                .queryParam("departmentCity", "Stockholm")
                .queryParam("destinationCity", "The MOON!")
                .accept(MediaType.APPLICATION_XML)
                .get(new GenericType<List<Itinerary>>() {
                });
        Assert.assertEquals(0, itineraries.size());
    }

    /**
     * NotFound 404 test of /itineraries/index
     */
    @Test
    public void itinerariesNotFoundTest() {
        thrown.expect(UniformInterfaceException.class);
        thrown.expectMessage("GET http://localhost:8080/rest/itineraries/20?token=ID2208_AUTH_TOKEN returned a response status of 404 Not Found");
        webResource.path("/itineraries/20").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_JSON).get(Itinerary.class);
    }

    /**
     * Not authorized 401 test of /itineraries
     */
    @Test
    public void itinerariesNotAuthorizedTest() {
        thrown.expect(UniformInterfaceException.class);
        thrown.expectMessage("GET http://localhost:8080/rest/itineraries returned a response status of 401 Unauthorized");
        webResource.path("/itineraries").accept(MediaType.APPLICATION_JSON).get(Itinerary.class);
    }

    /**
     * Unit test for /login resource
     */
    @Test
    public void loginTest() {
        /**
         * Success login POST request test
         */
        LoginRequest loginRequest = new LoginRequest("kim", "id2208");
        String token = webResource.path("/login").accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_JSON).post(String.class, loginRequest);
        Assert.assertEquals("ID2208_AUTH_TOKEN", token);
        /**
         * Failed login POST request test
         */
        loginRequest = new LoginRequest("trudy", "id2208");
        thrown.expect(UniformInterfaceException.class);
        thrown.expectMessage("POST http://localhost:8080/rest/login returned a response status of 401 Unauthorized");
        webResource.path("/login").accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_JSON).post(String.class, loginRequest);
        webResource.path("/itineraries/20").accept(MediaType.APPLICATION_JSON).get(Itinerary.class);
    }

    /**
     * Unit test for /pricelist resource
     */
    @Test
    public void priceListTest() {
        /**
         * Test plain /pricelist GET request, test JSON, XML, and unmarshall into java object
         */
        String response = webResource.path("/pricelist").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).get(String.class);
        Assert.assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><priceEntries><PriceEntry><Itinerary><Flights><DepartmentCity>Stockholm</DepartmentCity><DestinationCity>Madrid</DestinationCity></Flights><Flights><DepartmentCity>Madrid</DepartmentCity><DestinationCity>Mumbai</DestinationCity></Flights></Itinerary><Price>450.0</Price></PriceEntry><PriceEntry><Itinerary><Flights><DepartmentCity>Stockholm</DepartmentCity><DestinationCity>Madrid</DestinationCity></Flights></Itinerary><Price>150.0</Price></PriceEntry><PriceEntry><Itinerary><Flights><DepartmentCity>Stockholm</DepartmentCity><DestinationCity>Paris</DestinationCity></Flights></Itinerary><Price>100.0</Price></PriceEntry><PriceEntry><Itinerary><Flights><DepartmentCity>Madrid</DepartmentCity><DestinationCity>Mumbai</DestinationCity></Flights></Itinerary><Price>300.0</Price></PriceEntry></priceEntries>", response);
        response = webResource.path("/pricelist").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_JSON).get(String.class);
        Assert.assertEquals("[{\"Itinerary\":{\"Flights\":[{\"DepartmentCity\":\"Stockholm\",\"DestinationCity\":\"Madrid\"},{\"DepartmentCity\":\"Madrid\",\"DestinationCity\":\"Mumbai\"}]},\"Price\":450.0},{\"Itinerary\":{\"Flights\":[{\"DepartmentCity\":\"Stockholm\",\"DestinationCity\":\"Madrid\"}]},\"Price\":150.0},{\"Itinerary\":{\"Flights\":[{\"DepartmentCity\":\"Stockholm\",\"DestinationCity\":\"Paris\"}]},\"Price\":100.0},{\"Itinerary\":{\"Flights\":[{\"DepartmentCity\":\"Madrid\",\"DestinationCity\":\"Mumbai\"}]},\"Price\":300.0}]", response);
        ArrayList<PriceEntry> priceList = (ArrayList) webResource.path("/pricelist").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).get(new GenericType<List<PriceEntry>>() {});
        Assert.assertEquals(4, priceList.size());

        thrown.expect(UniformInterfaceException.class);
        thrown.expectMessage("GET http://localhost:8080/rest/pricelist returned a response status of 401 Unauthorized");
        webResource.path("/pricelist").accept(MediaType.APPLICATION_JSON).get(Itinerary.class);
    }

    /**
     * Unit test for /flights resource
     */
    @Test
    public void flightsTest() {
        /**
         * Test plain /flights GET request, test JSON, XML, and unmarshall into java object
         */
        String response = webResource.path("/flights").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).get(String.class);
        Assert.assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><flights><Flight><DepartmentCity>Stockholm</DepartmentCity><DestinationCity>Paris</DestinationCity></Flight><Flight><DepartmentCity>Stockholm</DepartmentCity><DestinationCity>Madrid</DestinationCity></Flight><Flight><DepartmentCity>Paris</DepartmentCity><DestinationCity>Madrid</DestinationCity></Flight><Flight><DepartmentCity>Madrid</DepartmentCity><DestinationCity>Mumbai</DestinationCity></Flight></flights>", response);
        response = webResource.path("/flights").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_JSON).get(String.class);
        Assert.assertEquals("[{\"DepartmentCity\":\"Stockholm\",\"DestinationCity\":\"Paris\"},{\"DepartmentCity\":\"Stockholm\",\"DestinationCity\":\"Madrid\"},{\"DepartmentCity\":\"Paris\",\"DestinationCity\":\"Madrid\"},{\"DepartmentCity\":\"Madrid\",\"DestinationCity\":\"Mumbai\"}]", response);
        ArrayList<Flight> flights = (ArrayList) webResource.path("/flights").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).get(new GenericType<List<Flight>>() {});
        Assert.assertEquals(4, flights.size());

        /**
         * Test /itineraries/index GET request
         */
        Flight flight = webResource.path("/flights/1").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_JSON).get(Flight.class);
        Assert.assertEquals("Stockholm", flight.getDepartmentCity());
        Assert.assertEquals("Madrid", flight.getDestinationCity());

        /**
         * Test PUT request for /flights
         */
        ArrayList<Flight> oldFlights = new ArrayList<Flight>(flights);
        flights.remove(0);
        flights.remove(0);
        FlightsPutRequest flightsPutRequest = new FlightsPutRequest(flights);
        flights = (ArrayList) webResource.path("/flights").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).put(new GenericType<List<Flight>>() {}, flightsPutRequest);
        Assert.assertEquals(2, flights.size());
        flightsPutRequest = new FlightsPutRequest(oldFlights);
        flights = (ArrayList) webResource.path("/flights").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).put(new GenericType<List<Flight>>() {}, flightsPutRequest);
        Assert.assertEquals(4, flights.size());

        /**
         * Test PUT request for /flight/index
         */
        FlightPutRequest flightPutRequest = new FlightPutRequest(flight);
        Flight updatedFlight = webResource.path("/flights/0").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_JSON).put(Flight.class, flightPutRequest);
        Assert.assertEquals(flight.getDepartmentCity(), updatedFlight.getDepartmentCity());
        Assert.assertEquals(flight.getDestinationCity(), updatedFlight.getDestinationCity());

        /**
         * Test DELETE request for /flights
         */
        webResource.path("/flights").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).delete();
        flights = (ArrayList) webResource.path("/flights").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).get(new GenericType<List<Flight>>() {});
        Assert.assertEquals(0, flights.size());
        flightsPutRequest = new FlightsPutRequest(oldFlights);
        flights = (ArrayList) webResource.path("/flights").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).put(new GenericType<List<Flight>>() {}, flightsPutRequest);
        Assert.assertEquals(4, flights.size());

        /**
         * Test DELETE request for /flights/index
         */
        webResource.path("/flights/1").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).delete();
        flights = (ArrayList) webResource.path("/flights").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).get(new GenericType<List<Flight>>() {});
        Assert.assertEquals(3, flights.size());
        flightsPutRequest = new FlightsPutRequest(oldFlights);
        flights = (ArrayList) webResource.path("/flights").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).put(new GenericType<List<Flight>>() {}, flightsPutRequest);
        Assert.assertEquals(4, flights.size());

    }

    /**
     * NotFound 404 test of /flights/index
     */
    @Test
    public void flightsNotFoundTest() {
        thrown.expect(UniformInterfaceException.class);
        thrown.expectMessage("GET http://localhost:8080/rest/flights/20?token=ID2208_AUTH_TOKEN returned a response status of 404 Not Found");
        webResource.path("/flights/20").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_JSON).get(Flight.class);
    }

    /**
     * Not authorized 401 test of /flights
     */
    @Test
    public void flightsNotAuthorizedTest() {
        thrown.expect(UniformInterfaceException.class);
        thrown.expectMessage("GET http://localhost:8080/rest/flights returned a response status of 401 Unauthorized");
        webResource.path("/flights").accept(MediaType.APPLICATION_JSON).get(Flight.class);
    }

    /**
     * Unit test for /tickets resource
     */
    @Test
    public void ticketsTest() {
        /**
         * Test plain /tickets GET request
         */
        ArrayList<Ticket> tickets = (ArrayList) webResource.path("/tickets").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).get(new GenericType<List<Ticket>>() {});
        Assert.assertEquals(3, tickets.size());

        /**
         * Test /tickets/index GET request
         */
        Ticket ticket = webResource.path("/tickets/1").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_JSON).get(Ticket.class);
        Assert.assertEquals("Stockholm", ticket.getFlight().getDepartmentCity());
        Assert.assertEquals("Madrid", ticket.getFlight().getDestinationCity());
        Assert.assertEquals(150.0f, ticket.getPrice(), 0);

        /**
         * Test /tickets POST request for searching available tickets given a itinerary and date
         */
        Itinerary itinerary = webResource.path("/itineraries/1").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_JSON).get(Itinerary.class);
        SearchTicketRequest searchTicketRequest = new SearchTicketRequest(itinerary, new Date());
        ArrayList<Ticket> availableTickets = (ArrayList) webResource.path("/tickets").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_JSON).post(new GenericType<List<Ticket>>() {}, searchTicketRequest);
        Assert.assertEquals(2, availableTickets.size());


        /**
         * Test PUT request for /tickets
         */
        ArrayList<Ticket> oldTickets = new ArrayList<Ticket>(tickets);
        tickets.remove(0);
        TicketsPutRequest ticketsPutRequest = new TicketsPutRequest(tickets);
        tickets = (ArrayList) webResource.path("/tickets").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).put(new GenericType<List<Ticket>>() {}, ticketsPutRequest);
        Assert.assertEquals(2, tickets.size());
        ticketsPutRequest = new TicketsPutRequest(oldTickets);
        tickets = (ArrayList) webResource.path("/tickets").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).put(new GenericType<List<Ticket>>() {}, ticketsPutRequest);
        Assert.assertEquals(3, tickets.size());

        /**
         * Test PUT request for /tickets/index
         */
        TicketPutRequest ticketPutRequest = new TicketPutRequest(ticket);
        Ticket updatedTicket = webResource.path("/tickets/0").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_JSON).put(Ticket.class, ticketPutRequest);
        Assert.assertEquals(ticket.getPrice(), updatedTicket.getPrice(), 0);
        Assert.assertEquals(ticket.toString(), updatedTicket.toString());

        /**
         * Test DELETE request for /tickets
         */
        webResource.path("/tickets").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).delete();
        tickets = (ArrayList) webResource.path("/tickets").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).get(new GenericType<List<Ticket>>() {});
        Assert.assertEquals(0, tickets.size());
        ticketsPutRequest = new TicketsPutRequest(oldTickets);
        tickets = (ArrayList) webResource.path("/tickets").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).put(new GenericType<List<Ticket>>() {}, ticketsPutRequest);
        Assert.assertEquals(3, tickets.size());

        /**
         * Test DELETE request for /tickets/index
         */
        webResource.path("/tickets/1").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).delete();
        tickets = (ArrayList) webResource.path("/tickets").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).get(new GenericType<List<Ticket>>() {});
        Assert.assertEquals(2, tickets.size());
        ticketsPutRequest = new TicketsPutRequest(oldTickets);
        tickets = (ArrayList) webResource.path("/tickets").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).put(new GenericType<List<Ticket>>() {}, ticketsPutRequest);
        Assert.assertEquals(3, tickets.size());

    }

    /**
     * NotFound 404 test of /tickets/index
     */
    @Test
    public void ticketsNotFoundTest() {
        thrown.expect(UniformInterfaceException.class);
        thrown.expectMessage("GET http://localhost:8080/rest/tickets/20?token=ID2208_AUTH_TOKEN returned a response status of 404 Not Found");
        webResource.path("/tickets/20").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_JSON).get(Ticket.class);
    }

    /**
     * Not authorized 401 test of /tickets
     */
    @Test
    public void ticketsNotAuthorizedTest() {
        thrown.expect(UniformInterfaceException.class);
        thrown.expectMessage("GET http://localhost:8080/rest/tickets returned a response status of 401 Unauthorized");
        webResource.path("/tickets").accept(MediaType.APPLICATION_JSON).get(Ticket.class);
    }

    /**
     * Unit test for /bookticket resource
     */
    @Test
    public void bookTicketTest() {
        /**
         * Success bookTicket POST request test
         */
        Itinerary itinerary = webResource.path("/itineraries/1").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_JSON).get(Itinerary.class);
        SearchTicketRequest searchTicketRequest = new SearchTicketRequest(itinerary, new Date());
        ArrayList<Ticket> availableTickets = (ArrayList) webResource.path("/tickets").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_JSON).post(new GenericType<List<Ticket>>() {}, searchTicketRequest);
        BookTicketRequest bookTicketRequest = new BookTicketRequest(1337, availableTickets);
        Receipt receipt = webResource.path("/bookticket").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_JSON).post(Receipt.class, bookTicketRequest);
        Assert.assertEquals(1337, receipt.getCreditCardNumber());
        Assert.assertEquals(receipt.getTickets().size(), availableTickets.size());

    }

    /**
     * Forbidden 403 test of /bookticket
     */
    @Test
    public void bookUnavailableTicketsTest(){
        thrown.expect(UniformInterfaceException.class);
        thrown.expectMessage("POST http://localhost:8080/rest/bookticket?token=ID2208_AUTH_TOKEN returned a response status of 403 Forbidden");
        BookTicketRequest bookTicketRequest = new BookTicketRequest(1337, new ArrayList<Ticket>());
        webResource.path("/bookticket").queryParam("token", SECRET_TOKEN).accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_JSON).post(Receipt.class, bookTicketRequest);
    }

    /**
     * Unit test of /purchasedtickets resource
     */
    @Test
    public void purchasedTicketsTest(){
        ArrayList<PurchasedTicket> issuedTickets = (ArrayList) webResource.path("/purchasedtickets")
                .queryParam("token", SECRET_TOKEN)
                .queryParam("receiptId", "1")
                .accept(MediaType.APPLICATION_XML)
                .get(new GenericType<List<PurchasedTicket>>() {
                });
        Assert.assertTrue(issuedTickets != null);
    }
}