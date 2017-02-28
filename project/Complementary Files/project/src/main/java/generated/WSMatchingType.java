
package generated;

import javax.annotation.Generated;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for WSMatchingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSMatchingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Macthing" type="{http://www.kth.se/ict/id2208/Matching}MatchedWebServiceType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "WSMatching")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSMatchingType", propOrder = {
    "macthing"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class WSMatchingType {

    @XmlElement(name = "Macthing", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<MatchedWebServiceType> macthing;

    /**
     * Gets the value of the macthing property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the macthing property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMacthing().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MatchedWebServiceType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-02-20T12:35:45+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<MatchedWebServiceType> getMacthing() {
        if (macthing == null) {
            macthing = new ArrayList<MatchedWebServiceType>();
        }
        return this.macthing;
    }

}
