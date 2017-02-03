package bottom_up.faults;

/**
 * @author Kim Hammar on 2017-02-03.
 */
public class AuthorizationException extends Exception {
    private static final long serialVersionUID = -314439670131687936L;

    public AuthorizationException(String reason){
        super(reason);
    }
}
