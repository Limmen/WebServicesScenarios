package limmen.kth.se.id2208.hw1.parsing.jaxb.short_cv;

import limmen.kth.se.id2208.hw1.parsing.generated_pojos.short_cv.ShortCV;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

/**
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

    public ShortCVJAXBParser(SchemaFactory schemaFactory) {
        this.schemaFactory = schemaFactory;
    }

    public void init() throws SAXException, JAXBException {
        shortCVSchema = schemaFactory.newSchema(new File(SCHEMA));
        shortCVDocument = new File(DOCUMENT);
        jaxbContext = JAXBContext.newInstance(ShortCV.class);
        unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setSchema(shortCVSchema);
    }

    public ShortCV createPOJO() throws JAXBException {
        return (ShortCV) unmarshaller.unmarshal(shortCVDocument);
    }
}
