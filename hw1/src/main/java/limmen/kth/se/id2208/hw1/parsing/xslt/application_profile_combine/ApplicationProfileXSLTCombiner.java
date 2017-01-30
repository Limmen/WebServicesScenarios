package limmen.kth.se.id2208.hw1.parsing.xslt.application_profile_combine;

import limmen.kth.se.id2208.hw1.validation.SchemaValidator;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * Combines the reduced xml files into application_generated_task2.xml
 * This class simply uses the Transformer class from javax.xml.transform package to transform
 * a given source-tree into a result-tree and finally to output result into a XML file.
 *
 * @author Kim Hammar on 2017-01-27.
 */
public class ApplicationProfileXSLTCombiner {
    private final TransformerFactory transformerFactory;
    private static final String XML_SOURCE = "xml/documents/reduced_transcript.xml";
    private static final String STYLESHEET = "xml/stylesheets/application_profile_combine.xsl";
    private static final String OUTPUT = "xml/documents/application_profile_generated_task3.xml";
    private static final String SCHEMA = "xml/schemas/application_profile.xsd";
    private StreamSource xmlSource;
    private StreamSource stylesheet;
    private StreamResult streamResult;
    private Transformer transformer;

    /**
     * Class constructor
     *
     * @param transformerFactory
     */
    public ApplicationProfileXSLTCombiner(TransformerFactory transformerFactory){
        this.transformerFactory = transformerFactory;
    }

    /**
     * Initizialization to prepare for transformations
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
     * Performs the transformation and combines the documents into application_generated_task2.xml
     * @throws TransformerException
     */
    public void combine() throws TransformerException {
        transformer.transform(xmlSource, streamResult);
        SchemaValidator.validate(SCHEMA, OUTPUT);
    }
}
