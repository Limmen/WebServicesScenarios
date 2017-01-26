package limmen.kth.se.id2208.hw1.parsing.jaxb.application_profile;

import limmen.kth.se.id2208.hw1.parsing.generated_pojos.application_profile.ApplicationProfile;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

/**
 * @author Kim Hammar on 2017-01-26.
 */
public class ApplicationProfileParser {
    private static final String SCHEMA = "xml/schemas/application_profile.xsd";
    private static final String DOCUMENT = "xml/documents/application_profile.xml";
    private final SchemaFactory schemaFactory;
    private JAXBContext jaxbContext;
    private Schema applicationProfileSchema;
    private Marshaller marshaller;

    public ApplicationProfileParser(SchemaFactory schemaFactory) {
        this.schemaFactory = schemaFactory;
    }

    public void init() throws SAXException, JAXBException {
        applicationProfileSchema = schemaFactory.newSchema(new File(SCHEMA));
        jaxbContext = JAXBContext.newInstance(ApplicationProfile.class);
        marshaller = jaxbContext.createMarshaller();
        marshaller.setSchema(applicationProfileSchema);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    }

    public void generateApplicationProfileDocument(ApplicationProfile applicationProfile) throws JAXBException {
        marshaller.marshal(applicationProfile, System.out);
    }
}
