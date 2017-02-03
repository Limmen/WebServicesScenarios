
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

    private final static QName _GetInitiaries2Response_QNAME = new QName("http://flight_reservation", "getInitiaries2Response");
    private final static QName _GetInitiariesResponse_QNAME = new QName("http://flight_reservation", "getInitiariesResponse");
    private final static QName _IssueTicketsResponse_QNAME = new QName("http://flight_reservation", "issueTicketsResponse");
    private final static QName _GetFlightsResponse_QNAME = new QName("http://flight_reservation", "getFlightsResponse");
    private final static QName _GetPriceListResponse_QNAME = new QName("http://flight_reservation", "getPriceListResponse");
    private final static QName _GetInitiaries3Response_QNAME = new QName("http://flight_reservation", "getInitiaries3Response");
    private final static QName _IssueTickets_QNAME = new QName("http://flight_reservation", "issueTickets");
    private final static QName _BookTicketsResponse_QNAME = new QName("http://flight_reservation", "bookTicketsResponse");
    private final static QName _GetInitiaries2_QNAME = new QName("http://flight_reservation", "getInitiaries2");
    private final static QName _BookTickets_QNAME = new QName("http://flight_reservation", "bookTickets");
    private final static QName _GetAvailableTicketsResponse_QNAME = new QName("http://flight_reservation", "getAvailableTicketsResponse");
    private final static QName _GetInitiaries3_QNAME = new QName("http://flight_reservation", "getInitiaries3");
    private final static QName _GetFlight_QNAME = new QName("http://flight_reservation", "getFlight");
    private final static QName _Initiary_QNAME = new QName("http://flight_reservation", "Initiary");
    private final static QName _GetInitiaries_QNAME = new QName("http://flight_reservation", "getInitiaries");
    private final static QName _Login_QNAME = new QName("http://flight_reservation", "login");
    private final static QName _LoginResponse_QNAME = new QName("http://flight_reservation", "loginResponse");
    private final static QName _GetFlightResponse_QNAME = new QName("http://flight_reservation", "getFlightResponse");
    private final static QName _GetFlights_QNAME = new QName("http://flight_reservation", "getFlights");
    private final static QName _Flight_QNAME = new QName("http://flight_reservation", "Flight");
    private final static QName _GetPriceList_QNAME = new QName("http://flight_reservation", "getPriceList");
    private final static QName _AuthorizationException_QNAME = new QName("http://flight_reservation", "AuthorizationException");
    private final static QName _GetAvailableTickets_QNAME = new QName("http://flight_reservation", "getAvailableTickets");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFlightResponse }
     * 
     */
    public GetFlightResponse createGetFlightResponse() {
        return new GetFlightResponse();
    }

    /**
     * Create an instance of {@link GetFlights }
     * 
     */
    public GetFlights createGetFlights() {
        return new GetFlights();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link GetPriceList }
     * 
     */
    public GetPriceList createGetPriceList() {
        return new GetPriceList();
    }

    /**
     * Create an instance of {@link AuthorizationException }
     * 
     */
    public AuthorizationException createAuthorizationException() {
        return new AuthorizationException();
    }

    /**
     * Create an instance of {@link GetAvailableTickets }
     * 
     */
    public GetAvailableTickets createGetAvailableTickets() {
        return new GetAvailableTickets();
    }

    /**
     * Create an instance of {@link Flight }
     * 
     */
    public Flight createFlight() {
        return new Flight();
    }

    /**
     * Create an instance of {@link GetInitiaries3 }
     * 
     */
    public GetInitiaries3 createGetInitiaries3() {
        return new GetInitiaries3();
    }

    /**
     * Create an instance of {@link Initiary }
     * 
     */
    public Initiary createInitiary() {
        return new Initiary();
    }

    /**
     * Create an instance of {@link GetInitiaries }
     * 
     */
    public GetInitiaries createGetInitiaries() {
        return new GetInitiaries();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link GetFlight }
     * 
     */
    public GetFlight createGetFlight() {
        return new GetFlight();
    }

    /**
     * Create an instance of {@link BookTicketsResponse }
     * 
     */
    public BookTicketsResponse createBookTicketsResponse() {
        return new BookTicketsResponse();
    }

    /**
     * Create an instance of {@link BookTickets }
     * 
     */
    public BookTickets createBookTickets() {
        return new BookTickets();
    }

    /**
     * Create an instance of {@link GetAvailableTicketsResponse }
     * 
     */
    public GetAvailableTicketsResponse createGetAvailableTicketsResponse() {
        return new GetAvailableTicketsResponse();
    }

    /**
     * Create an instance of {@link GetInitiaries2 }
     * 
     */
    public GetInitiaries2 createGetInitiaries2() {
        return new GetInitiaries2();
    }

    /**
     * Create an instance of {@link GetPriceListResponse }
     * 
     */
    public GetPriceListResponse createGetPriceListResponse() {
        return new GetPriceListResponse();
    }

    /**
     * Create an instance of {@link GetInitiaries2Response }
     * 
     */
    public GetInitiaries2Response createGetInitiaries2Response() {
        return new GetInitiaries2Response();
    }

    /**
     * Create an instance of {@link GetInitiariesResponse }
     * 
     */
    public GetInitiariesResponse createGetInitiariesResponse() {
        return new GetInitiariesResponse();
    }

    /**
     * Create an instance of {@link IssueTicketsResponse }
     * 
     */
    public IssueTicketsResponse createIssueTicketsResponse() {
        return new IssueTicketsResponse();
    }

    /**
     * Create an instance of {@link GetFlightsResponse }
     * 
     */
    public GetFlightsResponse createGetFlightsResponse() {
        return new GetFlightsResponse();
    }

    /**
     * Create an instance of {@link GetInitiaries3Response }
     * 
     */
    public GetInitiaries3Response createGetInitiaries3Response() {
        return new GetInitiaries3Response();
    }

    /**
     * Create an instance of {@link IssueTickets }
     * 
     */
    public IssueTickets createIssueTickets() {
        return new IssueTickets();
    }

    /**
     * Create an instance of {@link PurchasedTicket }
     * 
     */
    public PurchasedTicket createPurchasedTicket() {
        return new PurchasedTicket();
    }

    /**
     * Create an instance of {@link Ticket }
     * 
     */
    public Ticket createTicket() {
        return new Ticket();
    }

    /**
     * Create an instance of {@link PriceEntry }
     * 
     */
    public PriceEntry createPriceEntry() {
        return new PriceEntry();
    }

    /**
     * Create an instance of {@link Receipt }
     * 
     */
    public Receipt createReceipt() {
        return new Receipt();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInitiaries2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "getInitiaries2Response")
    public JAXBElement<GetInitiaries2Response> createGetInitiaries2Response(GetInitiaries2Response value) {
        return new JAXBElement<GetInitiaries2Response>(_GetInitiaries2Response_QNAME, GetInitiaries2Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInitiariesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "getInitiariesResponse")
    public JAXBElement<GetInitiariesResponse> createGetInitiariesResponse(GetInitiariesResponse value) {
        return new JAXBElement<GetInitiariesResponse>(_GetInitiariesResponse_QNAME, GetInitiariesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IssueTicketsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "issueTicketsResponse")
    public JAXBElement<IssueTicketsResponse> createIssueTicketsResponse(IssueTicketsResponse value) {
        return new JAXBElement<IssueTicketsResponse>(_IssueTicketsResponse_QNAME, IssueTicketsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "getFlightsResponse")
    public JAXBElement<GetFlightsResponse> createGetFlightsResponse(GetFlightsResponse value) {
        return new JAXBElement<GetFlightsResponse>(_GetFlightsResponse_QNAME, GetFlightsResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInitiaries3Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "getInitiaries3Response")
    public JAXBElement<GetInitiaries3Response> createGetInitiaries3Response(GetInitiaries3Response value) {
        return new JAXBElement<GetInitiaries3Response>(_GetInitiaries3Response_QNAME, GetInitiaries3Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IssueTickets }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "issueTickets")
    public JAXBElement<IssueTickets> createIssueTickets(IssueTickets value) {
        return new JAXBElement<IssueTickets>(_IssueTickets_QNAME, IssueTickets.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookTicketsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "bookTicketsResponse")
    public JAXBElement<BookTicketsResponse> createBookTicketsResponse(BookTicketsResponse value) {
        return new JAXBElement<BookTicketsResponse>(_BookTicketsResponse_QNAME, BookTicketsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInitiaries2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "getInitiaries2")
    public JAXBElement<GetInitiaries2> createGetInitiaries2(GetInitiaries2 value) {
        return new JAXBElement<GetInitiaries2>(_GetInitiaries2_QNAME, GetInitiaries2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookTickets }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "bookTickets")
    public JAXBElement<BookTickets> createBookTickets(BookTickets value) {
        return new JAXBElement<BookTickets>(_BookTickets_QNAME, BookTickets.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvailableTicketsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "getAvailableTicketsResponse")
    public JAXBElement<GetAvailableTicketsResponse> createGetAvailableTicketsResponse(GetAvailableTicketsResponse value) {
        return new JAXBElement<GetAvailableTicketsResponse>(_GetAvailableTicketsResponse_QNAME, GetAvailableTicketsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInitiaries3 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "getInitiaries3")
    public JAXBElement<GetInitiaries3> createGetInitiaries3(GetInitiaries3 value) {
        return new JAXBElement<GetInitiaries3>(_GetInitiaries3_QNAME, GetInitiaries3 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlight }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "getFlight")
    public JAXBElement<GetFlight> createGetFlight(GetFlight value) {
        return new JAXBElement<GetFlight>(_GetFlight_QNAME, GetFlight.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Initiary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "Initiary")
    public JAXBElement<Initiary> createInitiary(Initiary value) {
        return new JAXBElement<Initiary>(_Initiary_QNAME, Initiary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInitiaries }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "getInitiaries")
    public JAXBElement<GetInitiaries> createGetInitiaries(GetInitiaries value) {
        return new JAXBElement<GetInitiaries>(_GetInitiaries_QNAME, GetInitiaries.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "getFlightResponse")
    public JAXBElement<GetFlightResponse> createGetFlightResponse(GetFlightResponse value) {
        return new JAXBElement<GetFlightResponse>(_GetFlightResponse_QNAME, GetFlightResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlights }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "getFlights")
    public JAXBElement<GetFlights> createGetFlights(GetFlights value) {
        return new JAXBElement<GetFlights>(_GetFlights_QNAME, GetFlights.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Flight }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "Flight")
    public JAXBElement<Flight> createFlight(Flight value) {
        return new JAXBElement<Flight>(_Flight_QNAME, Flight.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthorizationException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "AuthorizationException")
    public JAXBElement<AuthorizationException> createAuthorizationException(AuthorizationException value) {
        return new JAXBElement<AuthorizationException>(_AuthorizationException_QNAME, AuthorizationException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvailableTickets }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "getAvailableTickets")
    public JAXBElement<GetAvailableTickets> createGetAvailableTickets(GetAvailableTickets value) {
        return new JAXBElement<GetAvailableTickets>(_GetAvailableTickets_QNAME, GetAvailableTickets.class, null, value);
    }

}
