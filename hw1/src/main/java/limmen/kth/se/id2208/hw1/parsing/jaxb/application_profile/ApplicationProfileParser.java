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
 * Marshalls the ApplicationProfile in-memory representation into application_profile_generated_task1.xml
 *
 * @author Kim Hammar on 2017-01-26.
 */
public class ApplicationProfileParser {
    private static final String SCHEMA = "xml/schemas/application_profile.xsd";
    private static final String RELATIVE_SCHEMA = "../schemas/application_profile.xsd";
    private static final String NAMESPACE = "http://www.limmen.kth.se.id2208.hw1.application_profile";
    private static final String DOCUMENT = "xml/documents/application_profile_generated_task1.xml";
    private final SchemaFactory schemaFactory;
    private JAXBContext jaxbContext;
    private Schema applicationProfileSchema;
    private File applicationProfileDocument;
    private Marshaller marshaller;

    /**
     * Class constructor
     * @param schemaFactory
     */
    public ApplicationProfileParser(SchemaFactory schemaFactory) {
        this.schemaFactory = schemaFactory;
    }

    /**
     * Initialization to prepare for the marshalling
     *
     * @throws SAXException
     * @throws JAXBException
     */
    public void init() throws SAXException, JAXBException {
        applicationProfileSchema = schemaFactory.newSchema(new File(SCHEMA));
        applicationProfileDocument = new File(DOCUMENT);
        jaxbContext = JAXBContext.newInstance(ApplicationProfile.class);
        marshaller = jaxbContext.createMarshaller();
        marshaller.setSchema(applicationProfileSchema);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, NAMESPACE + " " + RELATIVE_SCHEMA);
    }

    /**
     * Marshalls the ApplicationProfile object into application_profile_generated_task1.xml
     *
     * @param applicationProfile
     * @throws JAXBException
     */
    public void generateApplicationProfileDocument(ApplicationProfile applicationProfile) throws JAXBException {
        marshaller.marshal(applicationProfile, applicationProfileDocument);
    }
}
