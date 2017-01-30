package limmen.kth.se.id2208.hw1.parsing.dom.company_info;

import limmen.kth.se.id2208.hw1.java_mappings.generated_pojos.company_info.CompaniesInfo;
import limmen.kth.se.id2208.hw1.java_mappings.generated_pojos.company_info.ObjectFactory;
import limmen.kth.se.id2208.hw1.validation.SchemaValidator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

/**
 * Parses the company_info.xml into a DOM tree and then maps it into a POJO.
 * This class simply uses the DocumentBuilderFactory that gives a ready-parser that produces DOM object trees
 *
 *
 * @author Kim Hammar on 2017-01-26.
 */
public class CompanyInfoDOMParser {
    private final SchemaFactory schemaFactory;
    private final DocumentBuilderFactory documentBuilderFactory;
    private DocumentBuilder documentBuilder;
    private static final String SCHEMA = "xml/schemas/company_info.xsd";
    private static final String DOCUMENT = "xml/documents/company_info.xml";
    private Schema companyInfoSchema;
    private Document companyInfoDocument;

    /**
     * Class constructor
     *
     * @param schemaFactory
     * @param documentBuilderFactory
     */
    public CompanyInfoDOMParser(SchemaFactory schemaFactory, DocumentBuilderFactory documentBuilderFactory) {
        this.documentBuilderFactory = documentBuilderFactory;
        this.schemaFactory = schemaFactory;
    }

    /**
     * Initializes to prepare for the parsing
     *
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws IOException
     */
    public void init() throws SAXException, ParserConfigurationException, IOException {
        SchemaValidator.validate(SCHEMA, DOCUMENT);
        companyInfoSchema = schemaFactory.newSchema(new File(SCHEMA));
        documentBuilderFactory.setNamespaceAware(true); //Specifies that produced parser will provide support for XML namespaces
        documentBuilderFactory.setSchema(companyInfoSchema);
        documentBuilder = documentBuilderFactory.newDocumentBuilder();
        companyInfoDocument = documentBuilder.parse(new File(DOCUMENT));
    }

    /**
     * Parses the company_info.xml into a DOM tree and maps it into a POJO
     *
     * @return CompaniesInfo POJO
     * @throws DatatypeConfigurationException
     */
    public CompaniesInfo createPOJO() throws DatatypeConfigurationException {
        ObjectFactory objectFactory = new ObjectFactory();
        CompaniesInfo companiesInfo = objectFactory.createCompaniesInfo();
        NodeList companyNodes = companyInfoDocument.getElementsByTagName("Company");
        for (int i = 0; i < companyNodes.getLength(); i++) {
            Element companyElement = (Element) companyNodes.item(i);
            CompaniesInfo.Company company = objectFactory.createCompaniesInfoCompany();
            company.setName(companyElement.getElementsByTagName("Name").item(0).getTextContent());
            company.setAddress(companyElement.getElementsByTagName("Address").item(0).getTextContent());
            company.setAnno(DatatypeFactory.newInstance().newXMLGregorianCalendar(companyElement.getElementsByTagName("Anno").item(0).getTextContent()));
            Element contactElement = (Element) companyElement.getElementsByTagName("Contact").item(0);
            CompaniesInfo.Company.Contact contact = objectFactory.createCompaniesInfoCompanyContact();
            if(contactElement.getElementsByTagName("Phone").getLength() == 1)
                contact.setPhone(contactElement.getElementsByTagName("Phone").item(0).getTextContent());
            contact.setEmail(contactElement.getElementsByTagName("Email").item(0).getTextContent());
            company.setContact(contact);
            company.setAbout(companyElement.getElementsByTagName("About").item(0).getTextContent());
            company.setWebsite(companyElement.getElementsByTagName("Website").item(0).getTextContent());
            companiesInfo.getCompany().add(company);
        }
        return companiesInfo;
    }
}
