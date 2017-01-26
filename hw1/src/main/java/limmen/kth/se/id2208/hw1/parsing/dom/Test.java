package limmen.kth.se.id2208.hw1.parsing.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

/**
 * @author Kim Hammar on 2017-01-22.
 */
public class Test {

    public static void main(String[] args) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema transcriptSchema = schemaFactory.newSchema(new File("xml/schemas/transcript.xsd"));

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true); //Specify that namespaces should be supported
            documentBuilderFactory.setSchema(transcriptSchema); //Specify schema for validation
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document transcriptDocument = documentBuilder.parse(new File("xml/documents/transcript.xml"));

            Element rootElement = transcriptDocument.getDocumentElement(); //root element
            System.out.println("Root element is: " + rootElement.toString());
            NodeList courses = transcriptDocument.getElementsByTagName("Course");
            for(int i = 0; i < courses.getLength(); i++){
                NodeList courseData = courses.item(i).getChildNodes();
                for(int j = 0; j < courseData.getLength(); j++){
                    System.out.println(courseData.item(j).getNodeName());
                    System.out.println(courseData.item(j).getTextContent());
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
