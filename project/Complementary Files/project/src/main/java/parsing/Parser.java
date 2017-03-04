package parsing;

import generated.WSMatchingType;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.wsdl.*;
import javax.wsdl.extensions.schema.Schema;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Parser API on top of WSDL4J and JAXB. Provides necessary methods to extract information to do semantic and syntactic
 * matchings.
 *
 * @author Kim Hammar on 2017-02-28.
 */
public class Parser {
    private final DocumentBuilderFactory documentBuilderFactory;
    private final DocumentBuilder documentBuilder;
    private final WSDLFactory wsdlFactory;
    private final WSDLReader wsdlReader;
    private final ArrayList<String> basicTypes = new ArrayList<>();

    /**
     * Class constructor, initialize things.
     *
     * @throws ParserConfigurationException
     * @throws WSDLException
     */
    public Parser() throws ParserConfigurationException, WSDLException {
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilder = documentBuilderFactory.newDocumentBuilder();
        wsdlFactory = WSDLFactory.newInstance();
        wsdlReader = wsdlFactory.newWSDLReader();
        basicTypes.add("string");
        basicTypes.add("boolean");
        basicTypes.add("decimal");
        basicTypes.add("float");
        basicTypes.add("double");
        basicTypes.add("duration");
        basicTypes.add("dateTime");
        basicTypes.add("time");
        basicTypes.add("date");
        basicTypes.add("gYearMonth");
        basicTypes.add("gYear");
        basicTypes.add("gMonthDay");
        basicTypes.add("gDay");
        basicTypes.add("gMonth");
        basicTypes.add("hexBinary");
        basicTypes.add("base64Binary");
        basicTypes.add("anyURI");
        basicTypes.add("QName");
        basicTypes.add("NOTATION");
    }

    /**
     * Parses a given WSDL document
     *
     * @param document
     * @return
     * @throws WSDLException
     */
    public Definition parse(String document) throws WSDLException {
        return wsdlReader.readWSDL(document);
    }

    /**
     * Parses a set of filenames and returns a hashmap of <FileName, ParsedResult>
     *
     * @param files
     * @return
     * @throws WSDLException
     */
    public HashMap<String, Definition> parse(File[] files) throws WSDLException {
        HashMap<String, Definition> parsed = new HashMap<>();
        for (int i = 0; i < files.length; i++) {
            String wsdl = files[i].getPath();
            parsed.put(wsdl, parse(wsdl));
        }
        return parsed;
    }

    /**
     * Get schemaElement of a WSDL file
     *
     * @param wsdl
     * @return
     */
    public Element getSchemaElement(Definition wsdl) {
        Types types = wsdl.getTypes();
        return ((Schema) types.getExtensibilityElements().get(0)).getElement();
    }

    /**
     * Check if a given element is annotated
     *
     * @param element
     * @return
     */
    public boolean isAnnotated(Element element) {
        return element.hasAttribute("sawsdl:modelReference");
    }

    /**
     * Get semantic class of a element
     *
     * @param element
     * @return
     */
    public String getClass(Element element){
        String modelRef = element.getAttribute("sawsdl:modelReference");
        String semClass = modelRef.substring(modelRef.lastIndexOf("#")+1, modelRef.length());
        return semClass;
    }

    /**
     * Get all elements of a schema
     *
     * @param schemaElement
     * @return
     */
    public NodeList getElementsOfSchema(Element schemaElement) {
        return schemaElement.getElementsByTagNameNS("http://www.w3.org/2001/XMLSchema", "element");
    }

    /**
     * Get a list of complex types of a schema element
     *
     * @param schemaElement
     * @return
     */
    public NodeList getComplexTypesOfSchema(Element schemaElement) {
        return schemaElement.getElementsByTagNameNS("http://www.w3.org/2001/XMLSchema", "complexType");
    }

    /**
     * Get a list of simpletypes of a schema element
     *
     * @param schemaElement
     * @return
     */
    public NodeList getSimpleTypesOfSchema(Element schemaElement) {
        return schemaElement.getElementsByTagNameNS("http://www.w3.org/2001/XMLSchema", "simpleType");
    }

    /**
     * Utility function to get element in schema by attribute value
     *
     * @param attrValue
     * @param attrName
     * @param schemaElement
     * @return
     */
    public Element getElementInSchemaByAttribute(String attrValue, String attrName, Element schemaElement) {
        return com.ibm.wsdl.util.xml.DOMUtils.findChildElementWithAttribute(schemaElement, attrName, attrValue);
    }

    /**
     * Get a given element based on its name among a set of elements.
     *
     * @param name
     * @param elements
     * @return
     */
    public Element getElementInSchema(String name, NodeList elements) {
        for (int i = 0; i < elements.getLength(); i++) {
            Element element = (Element) elements.item(i);
            if (element.getAttribute("name").equals(name))
                return element;
        }
        return null;
    }

    /**
     * Returns a list of all operations given a WSDL file.
     *
     * @param wsdl
     * @return
     */
    public ArrayList<Operation> getOperations(Definition wsdl) {
        Map portTypes = wsdl.getPortTypes();
        ArrayList<Operation> operations = new ArrayList();
        for (Object object : portTypes.keySet()) {
            PortType portType = (PortType) portTypes.get(object);
            portType.getOperations();
            operations.addAll(portType.getOperations());
        }
        return operations;
    }

    /**
     * Method that returns the highest level semantically annotated element from the given root element.
     * If there exist multiple annotations at the same level all of them are returned.
     *
     * @param element root element
     * @param schemaElement Schema element where the types are
     * @return List of higest-level annotated files.
     */
    public ArrayList<Element> getHighestLevelAnnotated(Element element, Element schemaElement) {
        ArrayList<Element> annotatedElements = new ArrayList<>();
        return getHighestLevelAnnotated(element, annotatedElements, schemaElement);
    }

    /**
     * Method that returns the highest level semantically annotated element from the given root element.
     * If there exist multiple annotations at the same level all of them are returned.
     *
     * @param element root element
     * @param annotatedElements Recursive accumulator
     * @param schemaElement Schema element where the types are
     * @return List of higest-level annotated files.
     */
    public ArrayList<Element> getHighestLevelAnnotated(Element element, ArrayList<Element> annotatedElements, Element schemaElement) {
        if(element != null) {
            if (isAnnotated(element)) {
                annotatedElements.add(element);
            } else if (element.hasAttribute("type")) {
                Element type = getElementInSchemaByAttribute(element.getAttribute("type"), "name", schemaElement);
                getHighestLevelAnnotated(type, annotatedElements, schemaElement);
                //if(isAnnotated(type))
                //annotatedElements.add(type);
            } else {
                NodeList children = element.getChildNodes();
                for (int i = 0; i < children.getLength(); i++) {
                    if (children.item(i).getNodeType() == Element.ELEMENT_NODE) {
                        Element child = (Element) children.item(i);
                        if (isAnnotated(child)) {
                            System.out.println("Child was annotated, name: " + child.getAttribute("name"));
                            annotatedElements.add(child);
                        } else {
                            System.out.println("Child was not annotated, name: " + child.getAttribute("name"));
                            getHighestLevelAnnotated((Element) children.item(i), annotatedElements, schemaElement);
                        }
                    }
                }
            }
        }
        return annotatedElements;
    }

    /**
     * Flatten a given element and get all basic elements.
     *
     * @param element Element to be flattened
     * @param schemaElement schema where the types are
     * @return list of basic elements.
     */
    public ArrayList<Element> getBasicElements(Element element, Element schemaElement) {
        ArrayList<Element> basicElements = new ArrayList<>();
        return getBasicElements(element, basicElements, schemaElement);
    }

    /**
     * Flatten a given element and get all basic elements.
     *
     * @param element Element to be flattened.
     * @param basicElements Recursive accumulator
     * @param schemaElement Schema where the types are
     * @return List of basic elements
     */
    public ArrayList<Element> getBasicElements(Element element, ArrayList<Element> basicElements, Element schemaElement) {
        if (element != null) {
            if (element.hasAttribute("type") || element.hasAttribute("base")) {
                if (isBasicType(element.getAttribute("type"), schemaElement.getPrefix()) || isBasicType(element.getAttribute("base"), schemaElement.getPrefix())) {
                    Element addedElem;
                    if (element.hasAttribute("base"))
                        addedElem = (Element) element.getParentNode();
                    else
                        addedElem = element;
                    basicElements.add(addedElem);
                    return basicElements;
                } else if (element.hasAttribute("type")) {
                    Element type = getElementInSchemaByAttribute(element.getAttribute("type"), "name", schemaElement);
                    getBasicElements(type, basicElements, schemaElement);
                }
            } else {
                NodeList children = element.getChildNodes();
                for (int i = 0; i < children.getLength(); i++) {
                    if (children.item(i).getNodeType() == Element.ELEMENT_NODE) {
                        getBasicElements((Element) children.item(i), basicElements, schemaElement);
                    }
                }
            }
        }
        return basicElements;
    }

    /**
     * Check if a given type is a basic type or not
     *
     * @param type
     * @param schemaPrefix
     * @return boolean
     */
    public boolean isBasicType(String type, String schemaPrefix) {
        if (basicTypes.contains(type))
            return true;
        if (type.length() < 3)
            return false;
        else {
            int prefixDelim = type.indexOf(":");
            if (prefixDelim > 0 && prefixDelim <= type.length()) {
                String prefix = type.substring(0, prefixDelim);
                return prefix.equals("xsd") || prefix.equals("xs") || prefix.equals(schemaPrefix);
            } else return false;
        }
    }

    /**
     * Marshall WSMatching to doc with relativeSchema and namespace
     *
     * @param relativeSchema
     * @param namespace
     * @param doc
     * @param WSMatching
     */
    public void marshal(String relativeSchema, String namespace, String doc, WSMatchingType WSMatching) {

        try {
            File file = new File(doc);
            JAXBContext jaxbContext = JAXBContext.newInstance(WSMatchingType.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); //Specify output should be formatted with linefeeds and indentation
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8"); //Specify encoding of output
            marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, namespace + " " + relativeSchema); //Specify xsi:schemaLocation attribute in output
            marshaller.marshal(WSMatching, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }


}
