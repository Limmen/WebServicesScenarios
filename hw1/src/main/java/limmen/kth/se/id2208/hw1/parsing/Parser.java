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
 * Main Parser API for this homework. Uses DOMParser, JAXParser, PojoMerger, XSLTParser and generated POJO classes
 * to provide two API calls for parsing the application_profile in different ways.
 *
 * @author Kim Hammar on 2017-01-26.
 */
public class Parser {
    private final DOMParser domParser = new DOMParser();
    private final SAXParser saxParser = new SAXParser();
    private final JAXBParser jaxbParser = new JAXBParser();
    private final PojoMerger pojoMerger = new PojoMerger();
    private final XSLTParser xsltParser = new XSLTParser();

    /**
     * Parses the different xml files (short_cv, employment_record, company_info, transcript) with SAX, JAX, DOM
     * into in-memory datastructures, transforms it, and finally produces the application_profile_generated_task1.xml file
     */
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

    /**
     * Parses and transforms the different xml files (short_cv, employment_record, company_info, transcript) with XSLT
     * and produces the application_profile_generated_task2.xml
     */
    public void buildWithXSLT(){
        try {
            xsltParser.combineApplicationProfile();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
