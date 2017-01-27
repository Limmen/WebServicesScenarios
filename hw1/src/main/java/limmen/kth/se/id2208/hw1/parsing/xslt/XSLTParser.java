package limmen.kth.se.id2208.hw1.parsing.xslt;

import limmen.kth.se.id2208.hw1.parsing.xslt.application_profile_combine.ApplicationProfileXSLTCombiner;
import limmen.kth.se.id2208.hw1.parsing.xslt.employment_record_company_reducer.EmploymentRecordCompanyXSLTReducer;
import limmen.kth.se.id2208.hw1.parsing.xslt.short_cv_reducer.ShortCVXSLTReducer;
import limmen.kth.se.id2208.hw1.parsing.xslt.transcript_reducer.TranscriptXSLTReducer;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

/**
 * @author Kim Hammar on 2017-01-27.
 */
public class XSLTParser {
    private static final TransformerFactory transformerFactory = TransformerFactory.newInstance();

    public void reduceTranscript() throws TransformerException {
        TranscriptXSLTReducer transcriptXSLTReducer = new TranscriptXSLTReducer(transformerFactory);
        transcriptXSLTReducer.init();
        transcriptXSLTReducer.reduce();
    }

    public void reduceShortCV() throws TransformerException {
        ShortCVXSLTReducer shortCVXSLTReducer = new ShortCVXSLTReducer(transformerFactory);
        shortCVXSLTReducer.init();
        shortCVXSLTReducer.reduce();
    }

    public void reduceEmploymentRecordCompany() throws TransformerException {
        EmploymentRecordCompanyXSLTReducer employmentRecordCompanyXSLTReducer = new EmploymentRecordCompanyXSLTReducer(transformerFactory);
        employmentRecordCompanyXSLTReducer.init();
        employmentRecordCompanyXSLTReducer.reduce();
    }

    public void combineApplicationProfile() throws TransformerException {
        reduceTranscript();
        reduceShortCV();
        reduceEmploymentRecordCompany();
        ApplicationProfileXSLTCombiner applicationProfileXSLTCombiner = new ApplicationProfileXSLTCombiner(transformerFactory);
        applicationProfileXSLTCombiner.init();
        applicationProfileXSLTCombiner.combine();
    }
}
