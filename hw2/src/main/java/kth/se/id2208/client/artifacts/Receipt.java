
package kth.se.id2208.client.artifacts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for receipt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="receipt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CreditCardNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ReceiptId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Tickets" type="{http://flight_reservation}ticket" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "receipt", propOrder = {
    "creditCardNumber",
    "receiptId",
    "tickets"
})
public class Receipt {

    @XmlElement(name = "CreditCardNumber")
    protected int creditCardNumber;
    @XmlElement(name = "ReceiptId")
    protected int receiptId;
    @XmlElement(name = "Tickets")
    protected List<Ticket> tickets;

    /**
     * Gets the value of the creditCardNumber property.
     * 
     */
    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * Sets the value of the creditCardNumber property.
     * 
     */
    public void setCreditCardNumber(int value) {
        this.creditCardNumber = value;
    }

    /**
     * Gets the value of the receiptId property.
     * 
     */
    public int getReceiptId() {
        return receiptId;
    }

    /**
     * Sets the value of the receiptId property.
     * 
     */
    public void setReceiptId(int value) {
        this.receiptId = value;
    }

    /**
     * Gets the value of the tickets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tickets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTickets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ticket }
     * 
     * 
     */
    public List<Ticket> getTickets() {
        if (tickets == null) {
            tickets = new ArrayList<Ticket>();
        }
        return this.tickets;
    }

}
