package matching;

import edistance.EditDistance;
import generated.MatchedElementType;
import generated.MatchedOperationType;
import generated.MatchedWebServiceType;
import generated.WSMatchingType;
import org.w3c.dom.Element;
import parsing.Parser;

import javax.wsdl.Definition;
import javax.wsdl.Operation;
import javax.wsdl.Part;
import javax.wsdl.WSDLException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Syntactic matcher, parse files in DIR and then finds all syntactic matchings over THRESHOLD.
 *
 * @author Kim Hammar on 2017-02-28.
 */
public class SyntacticMatcher {
    private static final String DIR = "data/WSDLs/";
    private static final String SYNTACTIC_OUTPUT = "data/output/syntactic_matching.xml";
    private static final String SYNTACTIC_RELATIVE_SCHEMA = "./Output.xsd";
    private static final String SYNTACTIC_NAMESPACE = "http://www.kth.se/ict/id2208/Matching";
    private static final double THRESHOLD = 0.8;
    private final Parser parser;

    public SyntacticMatcher() throws ParserConfigurationException, WSDLException {
        parser = new Parser();
    }

    /**
     * Calculate the matchings and marshall the output to SYNTACTIC_OUTPUT
     *
     * @throws WSDLException
     */
    public void calculateMatchings() throws WSDLException {
        HashMap<String, Definition> wsdls = parser.parse(getWSDLFileNames());
        System.out.println("Calculating syntactic matches of " + wsdls.size() +" WSDL files...");
        WSMatchingType matches = getSyntacticMatches(wsdls);
        System.out.println("Found " + matches.getMacthing().size() + " matches");
        System.out.println("Marshalling output to: " + SYNTACTIC_OUTPUT);
        parser.marshal(SYNTACTIC_RELATIVE_SCHEMA, SYNTACTIC_NAMESPACE, SYNTACTIC_OUTPUT, matches);
        System.out.println("Done");
    }

    private WSMatchingType getSyntacticMatches(HashMap<String, Definition> wsdls) {
        WSMatchingType wsMatchingType = new WSMatchingType();
        List<MatchedWebServiceType> matches = wsMatchingType.getMacthing();
        HashMap<String, Definition> temp = new HashMap(wsdls);
        for (String wsdl : wsdls.keySet()) {
            temp.remove(wsdl);
            for (String wsdl2 : temp.keySet()) {
                syntacticMatch(wsdl, wsdl2, wsdls, matches);
            }
        }
        return wsMatchingType;
    }

    private void syntacticMatch(String wsdl1, String wsdl2, HashMap<String, Definition> wsdls, List<MatchedWebServiceType> matches) {
        Definition wsdlDef1 = wsdls.get(wsdl1);
        Definition wsdlDef2 = wsdls.get(wsdl2);
        ArrayList<Operation> operations1 = parser.getOperations(wsdlDef1);
        ArrayList<Operation> operations2 = parser.getOperations(wsdlDef2);
        MatchedWebServiceType match = null;
        for (Operation op1 : operations1) {
            for (Operation op2 : operations2) {
                Element schemaElement1 = parser.getSchemaElement(wsdlDef1);
                Element schemaElement2 = parser.getSchemaElement(wsdlDef2);
                MatchedOperationType matchedOperationType1 = syntacticMatch(op1, op2, schemaElement1, schemaElement2);
                MatchedOperationType matchedOperationType2 = syntacticMatch(op2, op1, schemaElement2, schemaElement1);
                if (matchedOperationType1 != null || matchedOperationType2 != null) {
                    match = new MatchedWebServiceType();
                    if (matchedOperationType1 != null) {
                        match.setInputServiceName(wsdl1);
                        match.setOutputServiceName(wsdl2);
                        match.getMacthedOperation().add(matchedOperationType1);
                    }
                    if (matchedOperationType2 != null) {
                        match.setInputServiceName(wsdl2);
                        match.setOutputServiceName(wsdl1);
                        match.getMacthedOperation().add(matchedOperationType2);
                    }
                }
            }
        }
        if (match != null) {
            double tot = 0;
            for (MatchedOperationType matchedOperationType : match.getMacthedOperation()) {
                tot = tot + matchedOperationType.getOpScore();
            }
            match.setWsScore(tot / match.getMacthedOperation().size());
            matches.add(match);
        }
    }

    private MatchedOperationType syntacticMatch(Operation op1, Operation op2, Element schemaElement1, Element schemaElement2) {
        ArrayList<MatchedElementType> matchedElementTypes = new ArrayList<>();
        Map parts1 = op1.getInput().getMessage().getParts();
        Map parts2 = op2.getOutput().getMessage().getParts();
        for (Object key1 : parts1.keySet()) {
            Part part1 = (Part) parts1.get(key1);
            for (Object key2 : parts2.keySet()) {
                Part part2 = (Part) parts2.get(key2);
                if (part1.getTypeName() != null && part2.getTypeName() != null) {
                    ArrayList<MatchedElementType> matches = new ArrayList();
                    if (parser.isBasicType(part1.getTypeName().getLocalPart(), schemaElement1.getPrefix()) && parser.isBasicType(part2.getTypeName().getLocalPart(), schemaElement2.getPrefix()))
                        matches = syntacticMatch(part1.getName(), part2.getName(), schemaElement1, schemaElement2);
                    if (!parser.isBasicType(part1.getTypeName().getLocalPart(), schemaElement1.getPrefix()) && !parser.isBasicType(part2.getTypeName().getLocalPart(), schemaElement2.getPrefix())) {
                        Element type1 = parser.getElementInSchemaByAttribute(part1.getTypeName().getLocalPart(), "name", schemaElement1);
                        if(type1 == null)
                            type1 = parser.getElementInSchemaByAttribute(part1.getTypeName().getPrefix() + ":" + part1.getTypeName().getLocalPart(), "name", schemaElement1);
                        Element type2 = parser.getElementInSchemaByAttribute(part2.getTypeName().getLocalPart(), "name", schemaElement2);
                        if(type2 == null)
                            type2 = parser.getElementInSchemaByAttribute(part2.getTypeName().getPrefix() + ":" + part2.getTypeName().getLocalPart(), "name", schemaElement2);
                        matches = syntacticMatch(type1, type2, schemaElement1, schemaElement2);
                    }
                    matchedElementTypes.addAll(matches);
                }
            }
        }
        if (matchedElementTypes.size() > 0) {
            MatchedOperationType matchedOperationType = new MatchedOperationType();
            matchedOperationType.setInputOperationName(op1.getName());
            matchedOperationType.setOutputOperationName(op2.getName());
            double tot = 0;
            for (MatchedElementType matchedElementType : matchedElementTypes) {
                tot = tot + matchedElementType.getScore();
            }
            matchedOperationType.setOpScore(tot / matchedElementTypes.size());
            matchedOperationType.getMacthedElement().addAll(matchedElementTypes);
            return matchedOperationType;
        } else {
            return null;
        }
    }

    private ArrayList<MatchedElementType> syntacticMatch(String type1, String type2, Element schemaElement1, Element schemaElement2) {
        ArrayList<MatchedElementType> matches = new ArrayList<>();
        MatchedElementType match = syntacticMatch(type1, type2);
        if (match != null)
            matches.add(match);
        return matches;
    }

    private ArrayList<MatchedElementType> syntacticMatch(Element type1, Element type2, Element schemaElement1, Element schemaElement2) {
        ArrayList<MatchedElementType> matches = new ArrayList<>();
        ArrayList<Element> basicElements1 = parser.getBasicElements(type1, schemaElement1);
        ArrayList<Element> basicElements2 = parser.getBasicElements(type2, schemaElement2);
        for (Element element1 : basicElements1) {
            for (Element element2 : basicElements2) {
                MatchedElementType match = syntacticMatch(element1, element2);
                if (match != null)
                    matches.add(match);
            }
        }
        return matches;
    }

    private MatchedElementType syntacticMatch(Element basicType1, Element basicType2) {
        return syntacticMatch(basicType1.getAttribute("name"), basicType2.getAttribute("name"));
    }

    private MatchedElementType syntacticMatch(String basicType1, String basicType2) {
        MatchedElementType matchedElementType = null;
        double dist = EditDistance.getSimilarity(basicType1, basicType2);
        if (dist >= THRESHOLD) {
            matchedElementType = new MatchedElementType();
            matchedElementType.setInputElement(basicType1);
            matchedElementType.setOutputElement(basicType2);
            matchedElementType.setScore(dist);
        }
        return matchedElementType;
    }

    private File[] getWSDLFileNames() {
        File folder = new File(DIR);
        return folder.listFiles();
    }
}
