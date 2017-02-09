package kth.se.id2208.hw3.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import kth.se.id2208.hw3.server.model.data.records.Itinerary;
import kth.se.id2208.hw3.server.model.data.records.LoginRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Test client for the RESTful FlightTicketReservationService
 *
 * @author Kim Hammar on 2017-02-09.
 */
public class ServiceClientTest {
    ClientConfig clientConfig;
    Client client;
    WebResource webResource;

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
        String response = webResource.path("/itineraries").accept(MediaType.APPLICATION_XML).get(String.class);
        Assert.assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><itineraries><Itinerary><Flights><DepartmentCity>Stockholm</DepartmentCity><DestinationCity>Paris</DestinationCity></Flights><Flights><DepartmentCity>Paris</DepartmentCity><DestinationCity>Madrid</DestinationCity></Flights><Flights><DepartmentCity>Madrid</DepartmentCity><DestinationCity>Mumbai</DestinationCity></Flights></Itinerary><Itinerary><Flights><DepartmentCity>Stockholm</DepartmentCity><DestinationCity>Madrid</DestinationCity></Flights><Flights><DepartmentCity>Madrid</DepartmentCity><DestinationCity>Mumbai</DestinationCity></Flights></Itinerary><Itinerary><Flights><DepartmentCity>Stockholm</DepartmentCity><DestinationCity>Paris</DestinationCity></Flights><Flights><DepartmentCity>Paris</DepartmentCity><DestinationCity>Madrid</DestinationCity></Flights></Itinerary><Itinerary><Flights><DepartmentCity>Stockholm</DepartmentCity><DestinationCity>Madrid</DestinationCity></Flights></Itinerary><Itinerary><Flights><DepartmentCity>Stockholm</DepartmentCity><DestinationCity>Paris</DestinationCity></Flights></Itinerary><Itinerary><Flights><DepartmentCity>Paris</DepartmentCity><DestinationCity>Madrid</DestinationCity></Flights></Itinerary><Itinerary><Flights><DepartmentCity>Madrid</DepartmentCity><DestinationCity>Mumbai</DestinationCity></Flights></Itinerary></itineraries>", response);
        response = webResource.path("/itineraries").accept(MediaType.APPLICATION_JSON).get(String.class);
        Assert.assertEquals("[{\"Flights\":[{\"DepartmentCity\":\"Stockholm\",\"DestinationCity\":\"Paris\"},{\"DepartmentCity\":\"Paris\",\"DestinationCity\":\"Madrid\"},{\"DepartmentCity\":\"Madrid\",\"DestinationCity\":\"Mumbai\"}]},{\"Flights\":[{\"DepartmentCity\":\"Stockholm\",\"DestinationCity\":\"Madrid\"},{\"DepartmentCity\":\"Madrid\",\"DestinationCity\":\"Mumbai\"}]},{\"Flights\":[{\"DepartmentCity\":\"Stockholm\",\"DestinationCity\":\"Paris\"},{\"DepartmentCity\":\"Paris\",\"DestinationCity\":\"Madrid\"}]},{\"Flights\":[{\"DepartmentCity\":\"Stockholm\",\"DestinationCity\":\"Madrid\"}]},{\"Flights\":[{\"DepartmentCity\":\"Stockholm\",\"DestinationCity\":\"Paris\"}]},{\"Flights\":[{\"DepartmentCity\":\"Paris\",\"DestinationCity\":\"Madrid\"}]},{\"Flights\":[{\"DepartmentCity\":\"Madrid\",\"DestinationCity\":\"Mumbai\"}]}]", response);

        Itinerary itinerary = webResource.path("/itineraries/1").accept(MediaType.APPLICATION_JSON).get(Itinerary.class);
        Assert.assertEquals(2, itinerary.getFlights().size());
        itinerary = webResource.path("/itineraries/2").accept(MediaType.APPLICATION_XML).get(Itinerary.class);
        Assert.assertEquals(2, itinerary.getFlights().size());
        itinerary = webResource.path("/itineraries/3").accept(MediaType.APPLICATION_JSON).get(Itinerary.class);
        Assert.assertEquals(1, itinerary.getFlights().size());

        ArrayList<Itinerary> itineraries = (ArrayList) webResource.path("/itineraries").accept(MediaType.APPLICATION_XML).get(new GenericType<List<Itinerary>>() {});
        Assert.assertEquals(7, itineraries.size());
        itineraries = (ArrayList) webResource.path("/itineraries")
                .queryParam("departmentCity", "Stockholm")
                .queryParam("destinationCity", "Mumbai")
                .accept(MediaType.APPLICATION_XML)
                .get(new GenericType<List<Itinerary>>() {
                });
        Assert.assertEquals(2, itineraries.size());
        itineraries = (ArrayList) webResource.path("/itineraries")
                .queryParam("departmentCity", "Stockholm")
                .queryParam("destinationCity", "The MOON!")
                .accept(MediaType.APPLICATION_XML)
                .get(new GenericType<List<Itinerary>>() {
                });
        Assert.assertEquals(0, itineraries.size());

        thrown.expect(UniformInterfaceException.class);
        thrown.expectMessage("GET http://localhost:8080/rest/itineraries/20 returned a response status of 404 Not Found");
        webResource.path("/itineraries/20").accept(MediaType.APPLICATION_JSON).get(Itinerary.class);
    }

    /**
     * Unit test for /login resource
     */
    @Test
    public void loginTest(){
        LoginRequest loginRequest = new LoginRequest("kim", "id2208");
        String token = webResource.path("/login").accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_JSON).post(String.class, loginRequest);
        Assert.assertEquals("ID2208_AUTH_TOKEN", token);
        loginRequest = new LoginRequest("trudy", "id2208");
        thrown.expect(UniformInterfaceException.class);
        thrown.expectMessage("POST http://localhost:8080/rest/login returned a response status of 401 Unauthorized");
        webResource.path("/login").accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_JSON).post(String.class, loginRequest);
        webResource.path("/itineraries/20").accept(MediaType.APPLICATION_JSON).get(Itinerary.class);
    }
}