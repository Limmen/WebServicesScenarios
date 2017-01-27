package limmen.kth.se.id2208.hw1.parsing.sax.employment_record;

import limmen.kth.se.id2208.hw1.parsing.generated_pojos.employment_record.EmploymentRecord;
import limmen.kth.se.id2208.hw1.parsing.generated_pojos.employment_record.ObjectFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;

/**
 *
 * Uses SAX API to parse employment_record.xml
 *
 * @author Kim Hammar on 2017-01-26.
 */
public class EmploymentRecordSAXParser {
    private final SchemaFactory schemaFactory;
    private final SAXParserFactory saxParserFactory;
    private static final String SCHEMA = "xml/schemas/employment_record.xsd";
    private static final String DOCUMENT = "xml/documents/employment_record.xml";
    private Schema employmentRecordSchema;
    private File employmentRecordDocument;
    private SAXParser saxParser;
    private XMLReader xmlReader;
    private EmploymentRecord employmentRecord;
    private ObjectFactory objectFactory;

    /**
     * Class constructor
     *
     * @param schemaFactory
     * @param saxParserFactory
     */
    public EmploymentRecordSAXParser(SchemaFactory schemaFactory, SAXParserFactory saxParserFactory) {
        this.schemaFactory = schemaFactory;
        this.saxParserFactory = saxParserFactory;
    }

    /**
     * Initialization to prepare for parsing
     *
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public void init() throws SAXException, ParserConfigurationException {
        employmentRecordSchema = schemaFactory.newSchema(new File(SCHEMA));
        employmentRecordDocument = new File(DOCUMENT);
        saxParserFactory.setNamespaceAware(true);
        saxParserFactory.setSchema(employmentRecordSchema);
        saxParser = saxParserFactory.newSAXParser();
        xmlReader = saxParser.getXMLReader();
        xmlReader.setContentHandler(new MainHandler());
    }

    /**
     * Parses the file into a POJO
     *
     * @return EmploymentRecord employmentRecord
     * @throws IOException
     * @throws SAXException
     */
    public EmploymentRecord createPOJO() throws IOException, SAXException {
        objectFactory = new ObjectFactory();
        employmentRecord = objectFactory.createEmploymentRecord();
        InputStream inputStream = new FileInputStream(employmentRecordDocument);
        Reader reader = new InputStreamReader(inputStream, "UTF-8");
        InputSource inputSource = new InputSource(reader);
        inputSource.setEncoding("UTF-8");
        xmlReader.parse(inputSource);
        return employmentRecord;
    }

    /**
     * Main handler for the SAX parsing
     */
    private class MainHandler extends DefaultHandler {
        private EmploymentRecord.Employee employee;
        private EmploymentRecord.EmploymentHistory employmentHistory;
        private EmploymentRecord.EmploymentHistory.Employment employment;

        boolean employeeFirstName = false;
        boolean employeeLastName = false;
        boolean employeeCivicRegNumber = false;
        boolean employeeEmail = false;
        boolean employmentStartDate = false;
        boolean employmentEndDate = false;
        boolean employmentCompany = false;
        boolean employmentTitle = false;

        /**
         * Called at the beginning of document
         */
        @Override
        public void startDocument() {
            employee = objectFactory.createEmploymentRecordEmployee();
            employmentHistory = objectFactory.createEmploymentRecordEmploymentHistory();
            employment = objectFactory.createEmploymentRecordEmploymentHistoryEmployment();
        }

        /**
         * Called at the beginning of an element.
         *
         * @param namespaceURI
         * @param localName
         * @param qName
         * @param atts
         * @throws SAXException
         */
        @Override
        public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
            if (qName.equalsIgnoreCase("FirstName")) {
                employeeFirstName = true;
            }
            if (qName.equalsIgnoreCase("LastName")) {
                employeeLastName = true;
            }
            if (qName.equalsIgnoreCase("CivicRegistratioNnumber")) {
                employeeCivicRegNumber = true;
            }
            if (qName.equalsIgnoreCase("Email")) {
                employeeEmail = true;
            }
            if (qName.equalsIgnoreCase("StartDate")) {
                employmentStartDate = true;
            }
            if (qName.equalsIgnoreCase("EndDate")) {
                employmentEndDate = true;
            }
            if (qName.equalsIgnoreCase("Company")) {
                employmentCompany = true;
            }
            if (qName.equalsIgnoreCase("Title")) {
                employmentTitle = true;
            }
        }

        /**
         *  Called at the end of an element.
         */
        @Override
        public void endDocument(){
            employmentRecord.setEmployee(employee);
            employmentRecord.setEmploymentHistory(employmentHistory);
        }

        /**
         * Called when character data is encountered.
         * @param ch
         * @param start
         * @param length
         * @throws SAXException
         */
        @Override
        public void characters(char ch[], int start, int length) throws SAXException {

            String data = new String(ch, start, length);
            if (employeeFirstName) {
                employee.setFirstName(data);
                employeeFirstName = false;
            }
            if (employeeLastName) {
                employee.setLastName(data);
                employeeLastName = false;
            }
            if (employeeCivicRegNumber) {
                employee.setCivicRegistrationNumber(data);
                employeeCivicRegNumber = false;
            }
            if (employeeEmail) {
                employee.setEmail(data);
                employeeEmail = false;
            }
            if (employmentStartDate) {
                try {
                    employment.setStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(data));
                } catch (DatatypeConfigurationException e) {
                    e.printStackTrace();
                }
                employmentStartDate = false;
            }
            if (employmentEndDate) {
                try {
                    employment.setEndDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(data));
                } catch (DatatypeConfigurationException e) {
                    e.printStackTrace();
                }
                employmentEndDate = false;
            }
            if (employmentCompany) {
                employment.setCompany(data);
                employmentCompany = false;
            }
            if (employmentTitle) {
                employment.setTitle(data);
                employmentTitle = false;
                employmentHistory.getEmployment().add(employment);
                employment = objectFactory.createEmploymentRecordEmploymentHistoryEmployment();
            }
        }
    }
}
