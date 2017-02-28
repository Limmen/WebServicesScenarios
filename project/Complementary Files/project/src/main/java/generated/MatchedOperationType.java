
package generated;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for MatchedOperationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MatchedOperationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OutputOperationName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InputOperationName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OpScore" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="MacthedElement" type="{http://www.kth.se/ict/id2208/Matching}MatchedElementType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MatchedOperationType", propOrder = {
    "outputOperationName",
    "inputOperationName",
    "opScore",
    "macthedElement"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class MatchedOperationType {

    @XmlElement(name = "OutputOperationName", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String outputOperationName;
    @XmlElement(name = "InputOperationName", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String inputOperationName;
    @XmlElement(name = "OpScore")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected double opScore;
    @XmlElement(name = "MacthedElement", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<MatchedElementType> macthedElement;

    /**
     * Gets the value of the outputOperationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getOutputOperationName() {
        return outputOperationName;
    }

    /**
     * Sets the value of the outputOperationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setOutputOperationName(String value) {
        this.outputOperationName = value;
    }

    /**
     * Gets the value of the inputOperationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getInputOperationName() {
        return inputOperationName;
    }

    /**
     * Sets the value of the inputOperationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setInputOperationName(String value) {
        this.inputOperationName = value;
    }

    /**
     * Gets the value of the opScore property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public double getOpScore() {
        return opScore;
    }

    /**
     * Sets the value of the opScore property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setOpScore(double value) {
        this.opScore = value;
    }

    /**
     * Gets the value of the macthedElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the macthedElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMacthedElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MatchedElementType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<MatchedElementType> getMacthedElement() {
        if (macthedElement == null) {
            macthedElement = new ArrayList<MatchedElementType>();
        }
        return this.macthedElement;
    }

}
