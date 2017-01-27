package limmen.kth.se.id2208.hw1.parsing.dom;

import limmen.kth.se.id2208.hw1.parsing.dom.company_info.CompanyInfoDOMParser;
import limmen.kth.se.id2208.hw1.parsing.generated_pojos.company_info.CompaniesInfo;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;

/**
 * DOMParser
 *
 * @author Kim Hammar on 2017-01-26.
 */
public class DOMParser {
    private static final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    private static final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

    /**
     * Parses the company_info.xml into DOM-tree and then maps it into a POJO
     *
     * @return CompaniesInfo object
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws DatatypeConfigurationException
     */
    public CompaniesInfo parseCompaniesInfo() throws IOException, SAXException, ParserConfigurationException, DatatypeConfigurationException {
        CompanyInfoDOMParser companyInfoDOMParser = new CompanyInfoDOMParser(schemaFactory, documentBuilderFactory);
        companyInfoDOMParser.init();
        CompaniesInfo companiesInfo = companyInfoDOMParser.createPOJO();
        return companiesInfo;
    }
}
