package limmen.kth.se.id2208.hw1.parsing.xslt.short_cv_reducer;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
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

    public ShortCVXSLTReducer(TransformerFactory transformerFactory){
        this.transformerFactory = transformerFactory;
    }

    public void init() throws TransformerConfigurationException {
        xmlSource = new StreamSource(new File(XML_SOURCE));
        stylesheet = new StreamSource(new File(STYLESHEET));
        streamResult = new StreamResult(new File(OUTPUT));
        transformer = transformerFactory.newTransformer(stylesheet);
    }

    public void reduce() throws TransformerException {
        transformer.transform(xmlSource, streamResult);
    }
}
