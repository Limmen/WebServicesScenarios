package kth.se.id2208.hw3.server.resources;

import kth.se.id2208.hw3.server.model.HelloWorldPOJO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Kim Hammar on 2017-02-07.
 */

@Path("/hello")
public class HelloWorld {
    @Path("/")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        return "Hello world Root!";
    }

    @Path("/helloNested")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getNestedMessage() {
        return "Hello world Nested!";
    }

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public HelloWorldPOJO getMessageJson() {
        HelloWorldPOJO helloWorldPOJO = new HelloWorldPOJO("Hello JSON!");
        return helloWorldPOJO;

    }

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public HelloWorldPOJO getMessageXML() {
        HelloWorldPOJO helloWorldPOJO = new HelloWorldPOJO("Hello XML");
        return helloWorldPOJO;
    }
}