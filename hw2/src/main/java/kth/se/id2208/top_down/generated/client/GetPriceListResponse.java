
package kth.se.id2208.top_down.generated.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getPriceListResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getPriceListResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Itinerary" type="{http://id2208.se.kth.top_down.FlightTicketReservationServiceTopDown}ItineraryType" minOccurs="0"/>
 *                   &lt;element name="Price" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPriceListResponse", propOrder = {
    "_return"
})
public class GetPriceListResponse {

    @XmlElement(name = "return")
    protected List<GetPriceListResponse.Return> _return;

    /**
     * Gets the value of the return property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the return property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReturn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetPriceListResponse.Return }
     * 
     * 
     */
    public List<GetPriceListResponse.Return> getReturn() {
        if (_return == null) {
            _return = new ArrayList<GetPriceListResponse.Return>();
        }
        return this._return;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Itinerary" type="{http://id2208.se.kth.top_down.FlightTicketReservationServiceTopDown}ItineraryType" minOccurs="0"/>
     *         &lt;element name="Price" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "itinerary",
        "price"
    })
    public static class Return {

        @XmlElement(name = "Itinerary")
        protected ItineraryType itinerary;
        @XmlElement(name = "Price")
        protected float price;

        /**
         * Gets the value of the itinerary property.
         * 
         * @return
         *     possible object is
         *     {@link ItineraryType }
         *     
         */
        public ItineraryType getItinerary() {
            return itinerary;
        }

        /**
         * Sets the value of the itinerary property.
         * 
         * @param value
         *     allowed object is
         *     {@link ItineraryType }
         *     
         */
        public void setItinerary(ItineraryType value) {
            this.itinerary = value;
        }

        /**
         * Gets the value of the price property.
         * 
         */
        public float getPrice() {
            return price;
        }

        /**
         * Sets the value of the price property.
         * 
         */
        public void setPrice(float value) {
            this.price = value;
        }

    }

}
