package limmen.kth.se.id2208.hw1.validation;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * @author Kim Hammar on 2017-01-30.
 */
public class SchemaValidator {

    public static boolean validate(String schemaPath, String documentPath){
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(schemaPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(documentPath)));
        } catch (SAXException | IOException e) {
            return false;
        }
        return true;
    }
}
