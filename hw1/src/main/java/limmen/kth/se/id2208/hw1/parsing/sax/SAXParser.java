package limmen.kth.se.id2208.hw1.parsing.sax;

import limmen.kth.se.id2208.hw1.java_mappings.generated_pojos.employment_record.EmploymentRecord;
import limmen.kth.se.id2208.hw1.parsing.sax.employment_record.EmploymentRecordSAXParser;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;

/**
 * SAXParser, uses SAXPArserFactory to parse XML files with SAX
 *
 * @author Kim Hammar on 2017-01-26.
 */
public class SAXParser {
    private static final SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    private static final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

    /**
     * Parses the employmen_record.xml into in-memory POJO
     *
     * @return employmentrecord, result of parsing file into POJO
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public EmploymentRecord parseEmploymentRecord() throws ParserConfigurationException, SAXException, IOException {
        EmploymentRecordSAXParser employmentRecordSAXParser = new EmploymentRecordSAXParser(schemaFactory, saxParserFactory);
        employmentRecordSAXParser.init();
        return employmentRecordSAXParser.createPOJO();
    }
}
