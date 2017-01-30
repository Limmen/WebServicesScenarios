package limmen.kth.se.id2208.hw1.parsing.jaxb.short_cv;

import limmen.kth.se.id2208.hw1.java_mappings.generated_pojos.short_cv.ShortCV;
import limmen.kth.se.id2208.hw1.validation.SchemaValidator;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

/**
 * Parses the short_cv.xml file with JAXB into an in-memory POJO representation
 * This class simply uses the ready Unmarshaller created by the JAXB Context to unmarshall the xml file
 * into java-pojo.
 *
 * @author Kim Hammar on 2017-01-26.
 */
public class ShortCVJAXBParser {
    private static final String SCHEMA = "xml/schemas/short_cv.xsd";
    private static final String DOCUMENT = "xml/documents/short_cv.xml";
    private final SchemaFactory schemaFactory;
    private JAXBContext jaxbContext;
    private File shortCVDocument;
    private Schema shortCVSchema;
    private Unmarshaller unmarshaller;

    /**
     * Class constructor
     *
     * @param schemaFactory
     */
    public ShortCVJAXBParser(SchemaFactory schemaFactory) {
        this.schemaFactory = schemaFactory;
    }

    /**
     * Initialization to prepare for the unmarshalling
     *
     * @throws SAXException
     * @throws JAXBException
     */
    public void init() throws SAXException, JAXBException {
        SchemaValidator.validate(SCHEMA, DOCUMENT);
        shortCVSchema = schemaFactory.newSchema(new File(SCHEMA));
        shortCVDocument = new File(DOCUMENT);
        jaxbContext = JAXBContext.newInstance(ShortCV.class);
        unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setSchema(shortCVSchema);
    }

    /**
     * Unmarshals short_cv.xml into an in-memory representation
     *
     * @return Object representation of short_cv.xml
     * @throws JAXBException
     */
    public ShortCV createPOJO() throws JAXBException {
        return (ShortCV) unmarshaller.unmarshal(shortCVDocument);
    }
}
