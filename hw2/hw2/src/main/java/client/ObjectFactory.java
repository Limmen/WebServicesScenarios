
package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SayHelloWorldFromResponse_QNAME = new QName("http://flight_reservation", "sayHelloWorldFromResponse");
    private final static QName _Login_QNAME = new QName("http://flight_reservation", "login");
    private final static QName _SayHelloWorldFrom_QNAME = new QName("http://flight_reservation", "sayHelloWorldFrom");
    private final static QName _LoginResponse_QNAME = new QName("http://flight_reservation", "loginResponse");
    private final static QName _AuthorizationException_QNAME = new QName("http://flight_reservation", "AuthorizationException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link AuthorizationException }
     * 
     */
    public AuthorizationException createAuthorizationException() {
        return new AuthorizationException();
    }

    /**
     * Create an instance of {@link SayHelloWorldFromResponse }
     * 
     */
    public SayHelloWorldFromResponse createSayHelloWorldFromResponse() {
        return new SayHelloWorldFromResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link SayHelloWorldFrom }
     * 
     */
    public SayHelloWorldFrom createSayHelloWorldFrom() {
        return new SayHelloWorldFrom();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloWorldFromResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "sayHelloWorldFromResponse")
    public JAXBElement<SayHelloWorldFromResponse> createSayHelloWorldFromResponse(SayHelloWorldFromResponse value) {
        return new JAXBElement<SayHelloWorldFromResponse>(_SayHelloWorldFromResponse_QNAME, SayHelloWorldFromResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloWorldFrom }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "sayHelloWorldFrom")
    public JAXBElement<SayHelloWorldFrom> createSayHelloWorldFrom(SayHelloWorldFrom value) {
        return new JAXBElement<SayHelloWorldFrom>(_SayHelloWorldFrom_QNAME, SayHelloWorldFrom.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthorizationException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "AuthorizationException")
    public JAXBElement<AuthorizationException> createAuthorizationException(AuthorizationException value) {
        return new JAXBElement<AuthorizationException>(_AuthorizationException_QNAME, AuthorizationException.class, null, value);
    }

}