
package kth.se.id2208.client.artifacts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the kth.se.id2208.client.artifacts package. 
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

    private final static QName _IssueTicketsResponse_QNAME = new QName("http://flight_reservation", "issueTicketsResponse");
    private final static QName _Itinerary_QNAME = new QName("http://flight_reservation", "Itinerary");
    private final static QName _GetPriceListResponse_QNAME = new QName("http://flight_reservation", "getPriceListResponse");
    private final static QName _IssueTickets_QNAME = new QName("http://flight_reservation", "issueTickets");
    private final static QName _BookTicketsResponse_QNAME = new QName("http://flight_reservation", "bookTicketsResponse");
    private final static QName _GetItineraries_QNAME = new QName("http://flight_reservation", "getItineraries");
    private final static QName _BookTickets_QNAME = new QName("http://flight_reservation", "bookTickets");
    private final static QName _GetAvailableTicketsResponse_QNAME = new QName("http://flight_reservation", "getAvailableTicketsResponse");
    private final static QName _PurchasedTicket_QNAME = new QName("http://flight_reservation", "PurchasedTicket");
    private final static QName _Login_QNAME = new QName("http://flight_reservation", "login");
    private final static QName _PriceEntry_QNAME = new QName("http://flight_reservation", "PriceEntry");
    private final static QName _Receipt_QNAME = new QName("http://flight_reservation", "Receipt");
    private final static QName _LoginResponse_QNAME = new QName("http://flight_reservation", "loginResponse");
    private final static QName _Ticket_QNAME = new QName("http://flight_reservation", "Ticket");
    private final static QName _Flight_QNAME = new QName("http://flight_reservation", "Flight");
    private final static QName _GetPriceList_QNAME = new QName("http://flight_reservation", "getPriceList");
    private final static QName _AuthorizationException_QNAME = new QName("http://flight_reservation", "AuthorizationException");
    private final static QName _GetAvailableTickets_QNAME = new QName("http://flight_reservation", "getAvailableTickets");
    private final static QName _GetItinerariesResponse_QNAME = new QName("http://flight_reservation", "getItinerariesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: kth.se.id2208.client.artifacts
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link GetItinerariesResponse }
     * 
     */
    public GetItinerariesResponse createGetItinerariesResponse() {
        return new GetItinerariesResponse();
    }

    /**
     * Create an instance of {@link Flight }
     * 
     */
    public Flight createFlight() {
        return new Flight();
    }

    /**
     * Create an instance of {@link PurchasedTicket }
     * 
     */
    public PurchasedTicket createPurchasedTicket() {
        return new PurchasedTicket();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link BookTicketsResponse }
     * 
     */
    public BookTicketsResponse createBookTicketsResponse() {
        return new BookTicketsResponse();
    }

    /**
     * Create an instance of {@link GetItineraries }
     * 
     */
    public GetItineraries createGetItineraries() {
        return new GetItineraries();
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
     * Create an instance of {@link Itinerary }
     * 
     */
    public Itinerary createItinerary() {
        return new Itinerary();
    }

    /**
     * Create an instance of {@link GetPriceListResponse }
     * 
     */
    public GetPriceListResponse createGetPriceListResponse() {
        return new GetPriceListResponse();
    }

    /**
     * Create an instance of {@link IssueTicketsResponse }
     * 
     */
    public IssueTicketsResponse createIssueTicketsResponse() {
        return new IssueTicketsResponse();
    }

    /**
     * Create an instance of {@link IssueTickets }
     * 
     */
    public IssueTickets createIssueTickets() {
        return new IssueTickets();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Itinerary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "Itinerary")
    public JAXBElement<Itinerary> createItinerary(Itinerary value) {
        return new JAXBElement<Itinerary>(_Itinerary_QNAME, Itinerary.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetItineraries }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "getItineraries")
    public JAXBElement<GetItineraries> createGetItineraries(GetItineraries value) {
        return new JAXBElement<GetItineraries>(_GetItineraries_QNAME, GetItineraries.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link PurchasedTicket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "PurchasedTicket")
    public JAXBElement<PurchasedTicket> createPurchasedTicket(PurchasedTicket value) {
        return new JAXBElement<PurchasedTicket>(_PurchasedTicket_QNAME, PurchasedTicket.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link PriceEntry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "PriceEntry")
    public JAXBElement<PriceEntry> createPriceEntry(PriceEntry value) {
        return new JAXBElement<PriceEntry>(_PriceEntry_QNAME, PriceEntry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Receipt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "Receipt")
    public JAXBElement<Receipt> createReceipt(Receipt value) {
        return new JAXBElement<Receipt>(_Receipt_QNAME, Receipt.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Ticket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "Ticket")
    public JAXBElement<Ticket> createTicket(Ticket value) {
        return new JAXBElement<Ticket>(_Ticket_QNAME, Ticket.class, null, value);
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetItinerariesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flight_reservation", name = "getItinerariesResponse")
    public JAXBElement<GetItinerariesResponse> createGetItinerariesResponse(GetItinerariesResponse value) {
        return new JAXBElement<GetItinerariesResponse>(_GetItinerariesResponse_QNAME, GetItinerariesResponse.class, null, value);
    }

}
