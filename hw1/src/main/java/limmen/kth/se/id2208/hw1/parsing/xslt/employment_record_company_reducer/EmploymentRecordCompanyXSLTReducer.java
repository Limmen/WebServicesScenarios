package limmen.kth.se.id2208.hw1.parsing.xslt.employment_record_company_reducer;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * Transforms the employment_record.xml and company_info.xml document and only keeps the information relevant to
 * application_profile.xml.
 *
 * @author Kim Hammar on 2017-01-27.
 */
public class EmploymentRecordCompanyXSLTReducer {
    private final TransformerFactory transformerFactory;
    private static final String XML_SOURCE = "xml/documents/employment_record.xml";
    private static final String STYLESHEET = "xml/stylesheets/employment_record_and_company.xsl";
    private static final String OUTPUT = "xml/documents/reduced_employment_record_company.xml";
    private StreamSource xmlSource;
    private StreamSource stylesheet;
    private StreamResult streamResult;
    private Transformer transformer;

    /**
     * Class constructor
     *
     * @param transformerFactory
     */
    public EmploymentRecordCompanyXSLTReducer(TransformerFactory transformerFactory){
        this.transformerFactory = transformerFactory;
    }

    /**
     * Initialization to prepare for transformations
     *
     * @throws TransformerConfigurationException
     */
    public void init() throws TransformerConfigurationException {
        xmlSource = new StreamSource(new File(XML_SOURCE));
        stylesheet = new StreamSource(new File(STYLESHEET));
        streamResult = new StreamResult(new File(OUTPUT));
        transformer = transformerFactory.newTransformer(stylesheet);
    }

    /**
     * Performs the transformation and writes the result to employment_record_and_company.xml
     *
     * @throws TransformerException
     */
    public void reduce() throws TransformerException {
        transformer.transform(xmlSource, streamResult);
    }
}
