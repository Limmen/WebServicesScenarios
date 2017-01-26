package limmen.kth.se.id2208.hw1.parsing.jaxb.transcript;

import limmen.kth.se.id2208.hw1.parsing.generated_pojos.transcript.Transcript;
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
public class TranscriptJAXBParser {
    private static final String SCHEMA = "xml/schemas/transcript.xsd";
    private static final String DOCUMENT = "xml/documents/transcript.xml";
    private final SchemaFactory schemaFactory;
    private JAXBContext jaxbContext;
    private File transcriptDocument;
    private Schema transcriptSchema;
    private Unmarshaller unmarshaller;

    public TranscriptJAXBParser(SchemaFactory schemaFactory) {
        this.schemaFactory = schemaFactory;
    }

    public void init() throws SAXException, JAXBException {
        transcriptSchema = schemaFactory.newSchema(new File(SCHEMA));
        transcriptDocument = new File(DOCUMENT);
        jaxbContext = JAXBContext.newInstance(Transcript.class);
        unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setSchema(transcriptSchema);
    }

    public Transcript createPOJO() throws JAXBException {
        return (Transcript) unmarshaller.unmarshal(transcriptDocument);
    }
}
