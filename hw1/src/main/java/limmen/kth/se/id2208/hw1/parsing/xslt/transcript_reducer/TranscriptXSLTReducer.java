package limmen.kth.se.id2208.hw1.parsing.xslt.transcript_reducer;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * Transforms the transcript.xml document and only keeps the information relevant to application_profile.xml, also
 * computes and adds the GPA for each degree.
 *
 * This class simply uses the Transformer class from javax.xml.transform package to transform
 * a given source-tree into a result-tree and finally to output result into a XML file.
 *
 * @author Kim Hammar on 2017-01-27.
 */
public class TranscriptXSLTReducer {
    private final TransformerFactory transformerFactory;
    private static final String XML_SOURCE = "xml/documents/transcript.xml";
    private static final String STYLESHEET = "xml/stylesheets/transcript.xsl";
    private static final String OUTPUT = "xml/documents/reduced_transcript.xml";
    private StreamSource xmlSource;
    private StreamSource stylesheet;
    private StreamResult streamResult;
    private Transformer transformer;

    /**
     * Class constructor for initialization
     *
     * @param transformerFactory
     */

    public TranscriptXSLTReducer(TransformerFactory transformerFactory){
        this.transformerFactory = transformerFactory;
    }

    /**
     * Initialization to set up things before transformations
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
     * Performs the actual transformation and writes it to reduced_transcript.xml
     *
     * @throws TransformerException
     */
    public void reduce() throws TransformerException {
        transformer.transform(xmlSource, streamResult);
    }
}
