package limmen.kth.se.id2208.hw1.parsing.jaxb.transcript;

import limmen.kth.se.id2208.hw1.java_mappings.generated_pojos.transcript.Transcript;
import limmen.kth.se.id2208.hw1.validation.SchemaValidator;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

/**
 * Parses the transcript.xml file with JAXB into an in-memory POJO representation.
 * This class simply uses the ready Unmarhaller from JAXB Context to unmarshall the XML file into
 * a Java POJO.
 *
 * @author Kim Hammar on 2017-01-26.
 */
public class TranscriptJAXBParser {
    private static final String SCHEMA = "xml/schemas/transcript.xsd";
    private static final String DOCUMENT = "xml/documents/transcript.xml";
    private final SchemaFactory schemaFactory;
    private JAXBContext jaxbContext;
    private File transcriptDocument;
    private Schema transcriptSchema;
    private Unmarshaller unmarshaller;

    /**
     * Class constructor
     *
     * @param schemaFactory
     */
    public TranscriptJAXBParser(SchemaFactory schemaFactory) {
        this.schemaFactory = schemaFactory;
    }

    /**
     * Initialization to prepare for parsing
     *
     * @throws SAXException
     * @throws JAXBException
     */
    public void init() throws SAXException, JAXBException {
        SchemaValidator.validate(SCHEMA, DOCUMENT);
        transcriptSchema = schemaFactory.newSchema(new File(SCHEMA));
        transcriptDocument = new File(DOCUMENT);
        jaxbContext = JAXBContext.newInstance(Transcript.class);
        unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setSchema(transcriptSchema);
    }

    /**
     * Unmarshalls the XML document into an in-memory representation
     *
     * @return Transcript Object
     * @throws JAXBException
     */
    public Transcript createPOJO() throws JAXBException {
        return (Transcript) unmarshaller.unmarshal(transcriptDocument);
    }
}
