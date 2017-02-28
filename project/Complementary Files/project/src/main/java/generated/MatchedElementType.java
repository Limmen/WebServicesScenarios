
package generated;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MatchedElementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MatchedElementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OutputElement" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InputElement" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Score" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MatchedElementType", propOrder = {
    "outputElement",
    "inputElement",
    "score"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class MatchedElementType {

    @XmlElement(name = "OutputElement", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String outputElement;
    @XmlElement(name = "InputElement", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String inputElement;
    @XmlElement(name = "Score")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected double score;

    /**
     * Gets the value of the outputElement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getOutputElement() {
        return outputElement;
    }

    /**
     * Sets the value of the outputElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setOutputElement(String value) {
        this.outputElement = value;
    }

    /**
     * Gets the value of the inputElement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getInputElement() {
        return inputElement;
    }

    /**
     * Sets the value of the inputElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setInputElement(String value) {
        this.inputElement = value;
    }

    /**
     * Gets the value of the score property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public double getScore() {
        return score;
    }

    /**
     * Sets the value of the score property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setScore(double value) {
        this.score = value;
    }

}
