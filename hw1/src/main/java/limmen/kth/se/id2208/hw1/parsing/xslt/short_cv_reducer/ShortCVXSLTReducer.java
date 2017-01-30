package limmen.kth.se.id2208.hw1.parsing.xslt.short_cv_reducer;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 *  Transforms the short_cv.xml document and only keeps the information relevant to application_profile.xml.
 *
 * This class simply uses the Transformer class from javax.xml.transform package to transform
 * a given source-tree into a result-tree and finally to output result into a XML file.
 *
 * @author Kim Hammar on 2017-01-27.
 */
public class ShortCVXSLTReducer {
    private final TransformerFactory transformerFactory;
    private static final String XML_SOURCE = "xml/documents/short_cv.xml";
    private static final String STYLESHEET = "xml/stylesheets/short_cv.xsl";
    private static final String OUTPUT = "xml/documents/reduced_short_cv.xml";
    private StreamSource xmlSource;
    private StreamSource stylesheet;
    private StreamResult streamResult;
    private Transformer transformer;

    /**
     * Class constructor
     *
     * @param transformerFactory
     */
    public ShortCVXSLTReducer(TransformerFactory transformerFactory){
        this.transformerFactory = transformerFactory;
    }

    /**
     * Initialization to perpare for transformations
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
     * Performs the transformation and writes result to reduced_short_cv.xml
     *
     * @throws TransformerException
     */
    public void reduce() throws TransformerException {
        transformer.transform(xmlSource, streamResult);
    }
}
