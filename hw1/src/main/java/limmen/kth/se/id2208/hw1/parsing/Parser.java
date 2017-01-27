package limmen.kth.se.id2208.hw1.parsing;

import limmen.kth.se.id2208.hw1.parsing.dom.DOMParser;
import limmen.kth.se.id2208.hw1.parsing.generated_pojos.application_profile.ApplicationProfile;
import limmen.kth.se.id2208.hw1.parsing.generated_pojos.company_info.CompaniesInfo;
import limmen.kth.se.id2208.hw1.parsing.generated_pojos.employment_record.EmploymentRecord;
import limmen.kth.se.id2208.hw1.parsing.generated_pojos.short_cv.ShortCV;
import limmen.kth.se.id2208.hw1.parsing.generated_pojos.transcript.Transcript;
import limmen.kth.se.id2208.hw1.parsing.jaxb.JAXBParser;
import limmen.kth.se.id2208.hw1.parsing.merger.PojoMerger;
import limmen.kth.se.id2208.hw1.parsing.sax.SAXParser;
import limmen.kth.se.id2208.hw1.parsing.xslt.XSLTParser;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * @author Kim Hammar on 2017-01-26.
 */
public class Parser {
    private final DOMParser domParser = new DOMParser();
    private final SAXParser saxParser = new SAXParser();
    private final JAXBParser jaxbParser = new JAXBParser();
    private final PojoMerger pojoMerger = new PojoMerger();
    private final XSLTParser xsltParser = new XSLTParser();

    public void parseWithDOM_SAX_JAXB(){
        try {
            CompaniesInfo companiesInfo = domParser.parseCompaniesInfo();
            EmploymentRecord employmentRecord = saxParser.parseEmploymentRecord();
            Transcript transcript = jaxbParser.parseTranscript();
            ShortCV shortCV = jaxbParser.parseShortCV();
            ApplicationProfile applicationProfile = pojoMerger.mergePojosToApplicationProfile(shortCV, transcript, employmentRecord, companiesInfo);
            jaxbParser.generateApplicationProfileDocument(applicationProfile);

        } catch (IOException | SAXException | ParserConfigurationException | DatatypeConfigurationException | JAXBException e) {
            e.printStackTrace();
        }

    }

    public void combineWithXSLT(){
        try {
            xsltParser.combineApplicationProfile();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public void buildWithXSLT(){

    }
}
