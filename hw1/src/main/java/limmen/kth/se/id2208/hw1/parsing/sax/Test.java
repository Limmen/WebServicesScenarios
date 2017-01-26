package limmen.kth.se.id2208.hw1.parsing.sax;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @author Kim Hammar on 2017-01-23.
 */
public class Test {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            saxParserFactory.setNamespaceAware(true);

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema transcriptSchema = schemaFactory.newSchema(new File("xml/schemas/transcript.xsd"));

            saxParserFactory.setSchema(transcriptSchema);
            SAXParser saxParser = null;
            saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(new MainHandler());
            xmlReader.setErrorHandler(new MyErrorHandler(System.err));

            File transcriptDocument = new File("xml/documents/transcript.xml");
            InputStream inputStream= new FileInputStream(transcriptDocument);
            Reader reader = new InputStreamReader(inputStream,"UTF-8");
            InputSource inputSource = new InputSource(reader);
            inputSource.setEncoding("UTF-8");

            xmlReader.parse(inputSource);

            System.out.println("Finnishing");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static class MainHandler extends DefaultHandler {

        private Hashtable tags;

        private MainHandler() {
        }

        public void startDocument() throws SAXException {
            tags = new Hashtable();
        }

        public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException{
            String key = localName;
            Object value = tags.get(key);

            if(value == null){
                tags.put(key, new Integer(1));
            } else {
                int count = ((Integer)value).intValue();
                count++;
                tags.put(key, new Integer(count));
            }
        }

        public void endDocument() throws SAXException {
            Enumeration enumeration = tags.keys();
            while (enumeration.hasMoreElements()) {
                String tag = (String) enumeration.nextElement();
                int count = ((Integer) tags.get(tag)).intValue();
                System.out.println("Local Name \"" + tag + "\" occurs " + count + " times");
            }
        }

        public void characters(char ch[], int start, int length)
                throws SAXException {

            System.out.println("char processing: " + new String(ch, start, length));

        }

    }

    private static class MyErrorHandler implements ErrorHandler {
        private PrintStream out;

        MyErrorHandler(PrintStream out) {
            this.out = out;
        }

        private String getParseExceptionInfo(SAXParseException spe) {
            String systemId = spe.getSystemId();

            if (systemId == null) {
                systemId = "null";
            }

            String info = "URI=" + systemId + " Line="
                    + spe.getLineNumber() + ": " + spe.getMessage();

            return info;
        }

        public void warning(SAXParseException spe) throws SAXException {
            out.println("Warning: " + getParseExceptionInfo(spe));
        }

        public void error(SAXParseException spe) throws SAXException {
            String message = "Error: " + getParseExceptionInfo(spe);
            throw new SAXException(message);
        }

        public void fatalError(SAXParseException spe) throws SAXException {
            String message = "Fatal Error: " + getParseExceptionInfo(spe);
            throw new SAXException(message);
        }
    }
}
