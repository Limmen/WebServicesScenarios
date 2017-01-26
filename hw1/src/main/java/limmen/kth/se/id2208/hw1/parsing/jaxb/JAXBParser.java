package limmen.kth.se.id2208.hw1.parsing.jaxb;

import limmen.kth.se.id2208.hw1.parsing.generated_pojos.application_profile.ApplicationProfile;
import limmen.kth.se.id2208.hw1.parsing.generated_pojos.short_cv.ShortCV;
import limmen.kth.se.id2208.hw1.parsing.generated_pojos.transcript.Transcript;
import limmen.kth.se.id2208.hw1.parsing.jaxb.application_profile.ApplicationProfileParser;
import limmen.kth.se.id2208.hw1.parsing.jaxb.short_cv.ShortCVJAXBParser;
import limmen.kth.se.id2208.hw1.parsing.jaxb.transcript.TranscriptJAXBParser;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.validation.SchemaFactory;

/**
 * @author Kim Hammar on 2017-01-26.
 */
public class JAXBParser {
    private static final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

    public Transcript parseTranscript() throws JAXBException, SAXException {
        TranscriptJAXBParser transcriptJAXBParser = new TranscriptJAXBParser(schemaFactory);
        transcriptJAXBParser.init();
        return transcriptJAXBParser.createPOJO();
    }

    public ShortCV parseShortCV() throws JAXBException, SAXException {
        ShortCVJAXBParser shortCVJAXBParser = new ShortCVJAXBParser(schemaFactory);
        shortCVJAXBParser.init();
        return shortCVJAXBParser.createPOJO();
    }

    public void generateApplicationProfileDocument(ApplicationProfile applicationProfile) throws JAXBException, SAXException {
        ApplicationProfileParser applicationProfileParser = new ApplicationProfileParser(schemaFactory);
        applicationProfileParser.init();
        applicationProfileParser.generateApplicationProfileDocument(applicationProfile);
    }
}
