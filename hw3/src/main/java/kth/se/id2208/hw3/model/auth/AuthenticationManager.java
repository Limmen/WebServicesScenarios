package kth.se.id2208.hw3.model.auth;

import kth.se.id2208.hw3.model.faults.AuthorizationException;

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
    public String login(String username, String pw) throws AuthorizationException {
        if (username.equalsIgnoreCase("kim") || username.equalsIgnoreCase("mallu")) {
            if (pw.equalsIgnoreCase("id2208"))
                return SECRET_TOKEN;
            else
                throw new AuthorizationException("wrong credentials");
        } else
            throw new AuthorizationException("wrong credentials");
    }

    /**
     * Authorizes a given security token
     *
     * @param token
     * @return true
     * @throws AuthorizationException thrown if token was invalid.
     */
    public boolean authorize(String token) throws AuthorizationException{
        if(token.equals(SECRET_TOKEN))
            return true;
        else throw new AuthorizationException("Invalid token");
    }
}
