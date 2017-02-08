package kth.se.id2208.hw3.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import javax.ws.rs.core.MediaType;

/**
 * @author Kim Hammar on 2017-02-07.
 */
public class HelloWorldClient {
    public static void main(String[] argv) {

        /**
         * Create new JAX-WS client
         */
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);

        /**
         * Create webresource to the server to be able to make requests
         */
        WebResource webResource = client.resource("http://localhost:8080/rest");
        /**
         * Get requests to server
         */
        /*
        String response = webResource.accept(MediaType.TEXT_PLAIN).get(String.class);
        System.out.println("Received: " + response);
        response = webResource.accept(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println("Received: " + response);
        response = webResource.path("/hello/helloNested").accept(MediaType.TEXT_PLAIN).get(String.class);
        System.out.println("Received: " + response);
        HelloWorldPOJO helloWorldPOJO = webResource.accept(MediaType.APPLICATION_JSON).get(HelloWorldPOJO.class);
        System.out.println(helloWorldPOJO.getGreeting());
        response = webResource.accept(MediaType.APPLICATION_XML).get(String.class);
        System.out.println("Received: " + response);
        helloWorldPOJO = webResource.accept(MediaType.APPLICATION_XML).get(HelloWorldPOJO.class);
        System.out.println("Received: " + helloWorldPOJO.getGreeting());
        */
        String response = webResource.path("/itineraries").accept(MediaType.APPLICATION_XML).get(String.class);
        System.out.println(response);
        response = webResource.path("/itineraries").accept(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(response);
    }
}
