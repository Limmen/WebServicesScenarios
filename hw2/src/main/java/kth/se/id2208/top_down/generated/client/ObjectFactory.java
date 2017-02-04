
package kth.se.id2208.top_down.generated.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the kth.se.id2208.top_down.generated.client package. 
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

    private final static QName _GetPriceListResponse_QNAME = new QName("http://flight_reservation", "getPriceListResponse");
    private final static QName _Login_QNAME = new QName("http://flight_reservation", "login");
    private final static QName _LoginResponse_QNAME = new QName("http://flight_reservation", "loginResponse");
    private final static QName _GetItineraries_QNAME = new QName("http://flight_reservation", "getItineraries");
    private final static QName _GetPriceList_QNAME = new QName("http://flight_reservation", "getPriceList");
    private final static QName _GetItinerariesResponse_QNAME = new QName("http://flight_reservation", "getItinerariesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: kth.se.id2208.top_down.generated.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPriceListResponse }
     * 
     */
    public GetPriceListResponse createGetPriceListResponse() {
        return new GetPriceListResponse();
    }

    /**
     * Create an instance of {@link ItineraryType }
     * 
     */
    public ItineraryType createItineraryType() {
        return new ItineraryType();
    }

    /**
     * Create an instance of {@link AuthorizationException }
     * 
     */
    public AuthorizationException createAuthorizationException() {
        return new AuthorizationException();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link GetItineraries }
     * 
     */
    public GetItineraries createGetItineraries() {
        return new GetItineraries();
    }

    /**
     * Create an instance of {@link GetPriceList }
     * 
     */
    public GetPriceList createGetPriceList() {
        return new GetPriceList();
    }

    /**
     * Create an instance of {@link GetItinerariesResponse }
     * 
     */
    public GetItinerariesResponse createGetItinerariesResponse() {
        return new GetItinerariesResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link GetPriceListResponse.Return }
     * 
     */
    public GetPriceListResponse.Return createGetPriceListResponseReturn() {
        return new GetPriceListResponse.Return();
    }

    /**
     * Create an instance of {@link ItineraryType.Flights }
     * 
     */
    public ItineraryType.Flights createItineraryTypeFlights() {
        return new ItineraryType.Flights();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPriceListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "getPriceListResponse")
    public JAXBElement<GetPriceListResponse> createGetPriceListResponse(GetPriceListResponse value) {
        return new JAXBElement<GetPriceListResponse>(_GetPriceListResponse_QNAME, GetPriceListResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetItineraries }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "getItineraries")
    public JAXBElement<GetItineraries> createGetItineraries(GetItineraries value) {
        return new JAXBElement<GetItineraries>(_GetItineraries_QNAME, GetItineraries.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPriceList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "getPriceList")
    public JAXBElement<GetPriceList> createGetPriceList(GetPriceList value) {
        return new JAXBElement<GetPriceList>(_GetPriceList_QNAME, GetPriceList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetItinerariesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "getItinerariesResponse")
    public JAXBElement<GetItinerariesResponse> createGetItinerariesResponse(GetItinerariesResponse value) {
        return new JAXBElement<GetItinerariesResponse>(_GetItinerariesResponse_QNAME, GetItinerariesResponse.class, null, value);
    }

}
