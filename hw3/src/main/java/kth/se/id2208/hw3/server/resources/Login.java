package kth.se.id2208.hw3.server.resources;

import kth.se.id2208.hw3.server.model.auth.AuthenticationManager;
import kth.se.id2208.hw3.server.model.data.records.LoginRequest;
import kth.se.id2208.hw3.server.model.faults.AuthorizationException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * REST resource, relative path: /login
 *
 * @author Kim Hammar on 2017-02-09.
 */
@Path("/login")
public class Login {

    private AuthenticationManager authenticationManager = AuthenticationManager.getInstance();

    @POST
    @Path("/")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String login(LoginRequest loginRequest) {
        System.out.println(loginRequest.getPassword() + " "+ loginRequest.getUsername());
        try {
            String token = authenticationManager.login(loginRequest.getUsername(), loginRequest.getPassword());
            return token;
        } catch (AuthorizationException e) {
            throw new WebApplicationException(401); //401-Unauthorized
        }
    }

}
