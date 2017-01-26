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
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @author Kim Hammar on 2017-01-26.
 */
public class Parser {
    private DOMParser domParser = new DOMParser();
    private SAXParser saxParser = new SAXParser();
    private JAXBParser jaxbParser = new JAXBParser();
    private PojoMerger pojoMerger = new PojoMerger();

    public void createApplicationProfile(){
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
}
