package kth.se.id2208.top_down.generated.model;

import kth.se.id2208.top_down.generated.artifacts.AuthorizationException;
import kth.se.id2208.top_down.generated.artifacts.AuthorizationException_Exception;

/**
 * AuthenticationManager handles login and authorization
 *
 * @author Kim Hammar on 2017-02-03.
 */
public class AuthenticationManager {

    private static String SECRET_TOKEN = "ID2208_AUTH_TOKEN";

    /**
     * Login operaiton, validates username and passwords and returns token if correct
     * @param username
     * @param pw
     * @return Security token
     * @throws AuthorizationException thrown if credentials where wrong
     */
    public String login(String username, String pw) throws kth.se.id2208.top_down.generated.artifacts.AuthorizationException_Exception{
        if (username.equalsIgnoreCase("kim") || username.equalsIgnoreCase("mallu")) {
            if (pw.equalsIgnoreCase("id2208"))
                return SECRET_TOKEN;
            else
                throw new AuthorizationException_Exception("invalid credentials", new AuthorizationException());
        } else
            throw new AuthorizationException_Exception("invalid credentials", new AuthorizationException());
    }

    /**
     * Authorizes a given security token
     *
     * @param token
     * @return true
     * @throws AuthorizationException thrown if token was invalid.
     */
    public boolean authorize(String token) throws AuthorizationException_Exception{
        if(token.equals(SECRET_TOKEN))
            return true;
        throw new AuthorizationException_Exception("invalid credentials", new AuthorizationException());
    }
}
