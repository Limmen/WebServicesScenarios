package kth.se.id2208.bottom_up.model.auth;

import kth.se.id2208.bottom_up.faults.AuthorizationException;

/**
 * @author Kim Hammar on 2017-02-03.
 */
public class AuthenticationManager {

    private static String SECRET_TOKEN = "ID2208_AUTH_TOKEN";

    public String login(String username, String pw) throws AuthorizationException{
        if (username.equalsIgnoreCase("kim") || username.equalsIgnoreCase("mallu")) {
            if (pw.equalsIgnoreCase("id2208"))
                return SECRET_TOKEN;
            else
                throw new AuthorizationException("wrong credentials");
        } else
            throw new AuthorizationException("wrong credentials");
    }

    public boolean authorize(String token) throws AuthorizationException{
        if(token.equals(SECRET_TOKEN))
            return true;
        else throw new AuthorizationException("Invalid token");
    }
}
