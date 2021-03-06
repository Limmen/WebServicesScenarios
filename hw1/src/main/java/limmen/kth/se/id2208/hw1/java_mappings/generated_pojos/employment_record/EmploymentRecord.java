//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.26 at 02:57:21 PM CET 
//


package limmen.kth.se.id2208.hw1.java_mappings.generated_pojos.employment_record;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="Employee">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="FirstName">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="LastName">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CivicRegistrationNumber">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;pattern value="\d{6}-\d{4}"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Email">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;pattern value="[^@]+@[^\.]+\..+"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="EmploymentHistory">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Employment" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="Company">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;minLength value="1"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
@XmlType(name = "", propOrder = {
    "employee",
    "employmentHistory"
})
@XmlRootElement(name = "EmploymentRecord", namespace = "http://www.limmen.kth.se.id2208.hw1.employment_record")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class EmploymentRecord {

    @XmlElement(name = "Employee", namespace = "http://www.limmen.kth.se.id2208.hw1.employment_record", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected EmploymentRecord.Employee employee;
    @XmlElement(name = "EmploymentHistory", namespace = "http://www.limmen.kth.se.id2208.hw1.employment_record", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected EmploymentRecord.EmploymentHistory employmentHistory;

    /**
     * Gets the value of the employee property.
     * 
     * @return
     *     possible object is
     *     {@link EmploymentRecord.Employee }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public EmploymentRecord.Employee getEmployee() {
        return employee;
    }

    /**
     * Sets the value of the employee property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmploymentRecord.Employee }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setEmployee(EmploymentRecord.Employee value) {
        this.employee = value;
    }

    /**
     * Gets the value of the employmentHistory property.
     * 
     * @return
     *     possible object is
     *     {@link EmploymentRecord.EmploymentHistory }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public EmploymentRecord.EmploymentHistory getEmploymentHistory() {
        return employmentHistory;
    }

    /**
     * Sets the value of the employmentHistory property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmploymentRecord.EmploymentHistory }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setEmploymentHistory(EmploymentRecord.EmploymentHistory value) {
        this.employmentHistory = value;
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
     *         &lt;element name="FirstName">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="LastName">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CivicRegistrationNumber">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;pattern value="\d{6}-\d{4}"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Email">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;pattern value="[^@]+@[^\.]+\..+"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
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
    @XmlType(name = "", propOrder = {
        "firstName",
        "lastName",
        "civicRegistrationNumber",
        "email"
    })
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public static class Employee {

        @XmlElement(name = "FirstName", namespace = "http://www.limmen.kth.se.id2208.hw1.employment_record", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String firstName;
        @XmlElement(name = "LastName", namespace = "http://www.limmen.kth.se.id2208.hw1.employment_record", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String lastName;
        @XmlElement(name = "CivicRegistrationNumber", namespace = "http://www.limmen.kth.se.id2208.hw1.employment_record", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String civicRegistrationNumber;
        @XmlElement(name = "Email", namespace = "http://www.limmen.kth.se.id2208.hw1.employment_record", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String email;

        /**
         * Gets the value of the firstName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getFirstName() {
            return firstName;
        }

        /**
         * Sets the value of the firstName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setFirstName(String value) {
            this.firstName = value;
        }

        /**
         * Gets the value of the lastName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getLastName() {
            return lastName;
        }

        /**
         * Sets the value of the lastName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setLastName(String value) {
            this.lastName = value;
        }

        /**
         * Gets the value of the civicRegistrationNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getCivicRegistrationNumber() {
            return civicRegistrationNumber;
        }

        /**
         * Sets the value of the civicRegistrationNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setCivicRegistrationNumber(String value) {
            this.civicRegistrationNumber = value;
        }

        /**
         * Gets the value of the email property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getEmail() {
            return email;
        }

        /**
         * Sets the value of the email property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setEmail(String value) {
            this.email = value;
        }

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
     *         &lt;element name="Employment" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;element name="Company">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="1"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    @XmlType(name = "", propOrder = {
        "employment"
    })
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public static class EmploymentHistory {

        @XmlElement(name = "Employment", namespace = "http://www.limmen.kth.se.id2208.hw1.employment_record")
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected List<EmploymentRecord.EmploymentHistory.Employment> employment;

        /**
         * Gets the value of the employment property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the employment property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEmployment().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link EmploymentRecord.EmploymentHistory.Employment }
         * 
         * 
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public List<EmploymentRecord.EmploymentHistory.Employment> getEmployment() {
            if (employment == null) {
                employment = new ArrayList<EmploymentRecord.EmploymentHistory.Employment>();
            }
            return this.employment;
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
         *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *         &lt;element name="Company">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "startDate",
            "endDate",
            "company",
            "title"
        })
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public static class Employment {

            @XmlElement(name = "StartDate", namespace = "http://www.limmen.kth.se.id2208.hw1.employment_record", required = true)
            @XmlSchemaType(name = "date")
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            protected XMLGregorianCalendar startDate;
            @XmlElement(name = "EndDate", namespace = "http://www.limmen.kth.se.id2208.hw1.employment_record", required = true)
            @XmlSchemaType(name = "date")
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            protected XMLGregorianCalendar endDate;
            @XmlElement(name = "Company", namespace = "http://www.limmen.kth.se.id2208.hw1.employment_record", required = true)
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            protected String company;
            @XmlElement(name = "Title", namespace = "http://www.limmen.kth.se.id2208.hw1.employment_record", required = true)
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            protected String title;

            /**
             * Gets the value of the startDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            public XMLGregorianCalendar getStartDate() {
                return startDate;
            }

            /**
             * Sets the value of the startDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            public void setStartDate(XMLGregorianCalendar value) {
                this.startDate = value;
            }

            /**
             * Gets the value of the endDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            public XMLGregorianCalendar getEndDate() {
                return endDate;
            }

            /**
             * Sets the value of the endDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            public void setEndDate(XMLGregorianCalendar value) {
                this.endDate = value;
            }

            /**
             * Gets the value of the company property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            public String getCompany() {
                return company;
            }

            /**
             * Sets the value of the company property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            public void setCompany(String value) {
                this.company = value;
            }

            /**
             * Gets the value of the title property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            public String getTitle() {
                return title;
            }

            /**
             * Sets the value of the title property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-01-26T02:57:21+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            public void setTitle(String value) {
                this.title = value;
            }

        }

    }

}
