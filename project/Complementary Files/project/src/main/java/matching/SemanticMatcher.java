package matching;

import generated.MatchedElementType;
import generated.MatchedOperationType;
import generated.MatchedWebServiceType;
import generated.WSMatchingType;
import org.mindswap.pellet.owlapi.Reasoner;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;
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
 * Semantic matcher, parse files in DIR and then finds all syntactic matchings over THRESHOLD.
 *
 * @author Kim Hammar on 2017-02-28.
 */
public class SemanticMatcher {
    private static final String DIR = "data/SAWSDL/";
    private static final String SEMANTIC_OUTPUT = "data/output/semantic_matching.xml";
    private static final String SEMANTIC_RELATIVE_SCHEMA = "./Output.xsd";
    private static final String SEMANTIC_NAMESPACE = "http://www.kth.se/ict/id2208/Matching";
    private static final double EXACT = 1.;
    private static final double SUBSUMPTION = 0.8;
    private static final double PLUG_IN = 0.6;
    private static final double STRUCTURAL = 0.5;
    private static final double NOT_MATCHED = 0.0;
    private static final double THRESHOLD = 0.5;
    private final Parser parser;
    private final OWLOntologyManager manager;
    private final OWLOntology ontology;
    private final Reasoner reasoner;
    private final HashMap<String, OWLClass> owlClasses;
    private final ontology.MyOntManager ontsum;
    private static String ontLocation = "file:///home/kim/workspace/java/WebServicesScenarios/project/Complementary%20Files/project/data/owl/SUMO.owl";
    //private static String ontLocation = "file:///hdd/workspace/java/WebServicesScenarios/project/Complementary%20Files/project/data/owl/SUMO.owl";

    public SemanticMatcher() throws ParserConfigurationException, WSDLException {
        parser = new Parser();
        ontsum = new ontology.MyOntManager();
        manager = ontsum.initializeOntologyManager();
        ontology = ontsum.initializeOntology(manager, ontLocation);
        reasoner = ontsum.initializeReasoner(ontology, manager);
        owlClasses = ontsum.loadClasses(reasoner);
    }

    /**
     * Calculate the matchings and marshall the output to SEMANTIC_OUTPUT
     *
     * @throws WSDLException
     */
    public void calculateMatchings() throws WSDLException {
        HashMap<String, Definition> wsdls = parser.parse(getWSDLFileNames());
        System.out.println("Calculating semantic matches of " + wsdls.size() +" (SA)WSDL files...");
        WSMatchingType matches = getSemanticMatches(wsdls);
        System.out.println("Found " + matches.getMacthing().size() + " matches");
        System.out.println("Marshalling output to: " + SEMANTIC_OUTPUT);
        parser.marshal(SEMANTIC_RELATIVE_SCHEMA, SEMANTIC_NAMESPACE, SEMANTIC_OUTPUT, matches);
        System.out.println("Done");
    }

    private WSMatchingType getSemanticMatches(HashMap<String, Definition> wsdls) {
        WSMatchingType wsMatchingType = new WSMatchingType();
        List<MatchedWebServiceType> matches = wsMatchingType.getMacthing();
        HashMap<String, Definition> temp = new HashMap(wsdls);
        for (String wsdl : wsdls.keySet()) {
            temp.remove(wsdl);
            for (String wsdl2 : temp.keySet()) {
                getSemanticMatches(wsdl, wsdl2, wsdls, matches);
            }
        }
        return wsMatchingType;
    }

    private void getSemanticMatches(String wsdl1, String wsdl2, HashMap<String, Definition> wsdls, List<MatchedWebServiceType> matches) {
        Definition wsdlDef1 = wsdls.get(wsdl1);
        Definition wsdlDef2 = wsdls.get(wsdl2);
        ArrayList<Operation> operations1 = parser.getOperations(wsdlDef1);
        ArrayList<Operation> operations2 = parser.getOperations(wsdlDef2);
        MatchedWebServiceType match = null;
        for (Operation op1 : operations1) {
            for (Operation op2 : operations2) {
                Element schemaElement1 = parser.getSchemaElement(wsdlDef1);
                Element schemaElement2 = parser.getSchemaElement(wsdlDef2);
                MatchedOperationType matchedOperationType1 = getSemanticMatches(op1, op2, schemaElement1, schemaElement2);
                MatchedOperationType matchedOperationType2 = getSemanticMatches(op2, op1, schemaElement2, schemaElement1);
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

    private MatchedOperationType getSemanticMatches(Operation op1, Operation op2, Element schemaElement1, Element schemaElement2) {
        ArrayList<MatchedElementType> matchedElementTypes = new ArrayList<>();
        Map parts1 = op1.getInput().getMessage().getParts();
        Map parts2 = op2.getOutput().getMessage().getParts();
        for (Object key1 : parts1.keySet()) {
            Part part1 = (Part) parts1.get(key1);
            for (Object key2 : parts2.keySet()) {
                Part part2 = (Part) parts2.get(key2);
                if (part1.getTypeName() != null && part2.getTypeName() != null) {
                    Element type1 = parser.getElementInSchemaByAttribute(part1.getTypeName().getLocalPart(), "name", schemaElement1);
                    if (type1 == null)
                        type1 = parser.getElementInSchemaByAttribute(part1.getTypeName().getPrefix() + ":" + part1.getTypeName().getLocalPart(), "name", schemaElement1);
                    Element type2 = parser.getElementInSchemaByAttribute(part2.getTypeName().getLocalPart(), "name", schemaElement2);
                    if (type2 == null)
                        type2 = parser.getElementInSchemaByAttribute(part2.getTypeName().getPrefix() + ":" + part2.getTypeName().getLocalPart(), "name", schemaElement2);
                    ArrayList<MatchedElementType> matches = getSemanticMatches(type1, type2, schemaElement1, schemaElement2);
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

    private ArrayList<MatchedElementType> getSemanticMatches(Element type1, Element type2, Element schemaElement1, Element schemaElement2) {
        ArrayList<MatchedElementType> matches = new ArrayList<>();
        ArrayList<Element> annotatedElements1 = parser.getHighestLevelAnnotated(type1, schemaElement1);
        ArrayList<Element> annotatedElements2 = parser.getHighestLevelAnnotated(type2, schemaElement2);
        for (Element element1 : annotatedElements1) {
            for (Element element2 : annotatedElements2) {
                MatchedElementType match = getSemanticMatches(element1, element2);
                if (match != null)
                    matches.add(match);
            }
        }
        return matches;
    }


    private MatchedElementType getSemanticMatches(Element annotatedType1, Element annotatedType2) {
        MatchedElementType matchedElementType = null;
        String semClass1 = parser.getClass(annotatedType1);
        String semClass2 = parser.getClass(annotatedType2);
        double score = semanticScore(semClass1, semClass2);
        if (score >= THRESHOLD) {
            matchedElementType = new MatchedElementType();
            matchedElementType.setInputElement(annotatedType1.getAttribute("name"));
            matchedElementType.setOutputElement(annotatedType2.getAttribute("name"));
            matchedElementType.setScore(score);
        }
        return matchedElementType;
    }

    private double semanticScore(String semClass1, String semClass2) {
        if (isSameAs(semClass1, semClass2))
            return EXACT;
        if(isSubClassOf(semClass1, semClass2))
            return SUBSUMPTION;
        if(isSubClassOf(semClass2, semClass1))
            return PLUG_IN;
        if(hasRelationWith(semClass2, semClass1))
            return STRUCTURAL;
        return NOT_MATCHED;
    }

    private File[] getWSDLFileNames() {
        File folder = new File(DIR);
        return folder.listFiles();
    }

    private boolean isSameAs(String semClass1, String semClass2) {
        return semClass1.equals(semClass2);
    }

    private boolean isSubClassOf(String semClass1, String semClass2) {
        OWLClass owlClass1 = owlClasses.get(semClass1.toLowerCase());
        OWLClass owlClass2 = owlClasses.get(semClass2.toLowerCase());
        if (owlClass1 != null && owlClass2 != null)
            return reasoner.isSubClassOf(owlClass1, owlClass2);
        else
            return false;
    }

    private boolean hasRelationWith(String semClass1, String semClass2) {
        OWLClass owlClass1 = owlClasses.get(semClass1.toLowerCase());
        OWLClass owlClass2 = owlClasses.get(semClass2.toLowerCase());
        if (owlClass1 != null && owlClass2 != null)
            return ontsum.findRelationship(owlClass1, owlClass2, reasoner).size() > 0;
        else
            return false;
    }

}
