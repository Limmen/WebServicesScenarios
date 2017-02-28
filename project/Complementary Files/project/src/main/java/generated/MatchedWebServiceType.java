
package generated;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MatchedWebServiceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MatchedWebServiceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OutputServiceName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InputServiceName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MacthedOperation" type="{http://www.kth.se/ict/id2208/Matching}MatchedOperationType" maxOccurs="unbounded"/>
 *         &lt;element name="WsScore" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MatchedWebServiceType", propOrder = {
    "outputServiceName",
    "inputServiceName",
    "macthedOperation",
    "wsScore"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class MatchedWebServiceType {

    @XmlElement(name = "OutputServiceName", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String outputServiceName;
    @XmlElement(name = "InputServiceName", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String inputServiceName;
    @XmlElement(name = "MacthedOperation", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<MatchedOperationType> macthedOperation;
    @XmlElement(name = "WsScore")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected double wsScore;

    /**
     * Gets the value of the outputServiceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getOutputServiceName() {
        return outputServiceName;
    }

    /**
     * Sets the value of the outputServiceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setOutputServiceName(String value) {
        this.outputServiceName = value;
    }

    /**
     * Gets the value of the inputServiceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getInputServiceName() {
        return inputServiceName;
    }

    /**
     * Sets the value of the inputServiceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setInputServiceName(String value) {
        this.inputServiceName = value;
    }

    /**
     * Gets the value of the macthedOperation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the macthedOperation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMacthedOperation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MatchedOperationType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<MatchedOperationType> getMacthedOperation() {
        if (macthedOperation == null) {
            macthedOperation = new ArrayList<MatchedOperationType>();
        }
        return this.macthedOperation;
    }

    /**
     * Gets the value of the wsScore property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public double getWsScore() {
        return wsScore;
    }

    /**
     * Sets the value of the wsScore property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setWsScore(double value) {
        this.wsScore = value;
    }

}
