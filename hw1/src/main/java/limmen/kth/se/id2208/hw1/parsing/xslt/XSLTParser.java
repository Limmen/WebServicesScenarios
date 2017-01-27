package limmen.kth.se.id2208.hw1.parsing.xslt;

import limmen.kth.se.id2208.hw1.parsing.xslt.application_profile_combine.ApplicationProfileXSLTCombiner;
import limmen.kth.se.id2208.hw1.parsing.xslt.employment_record_company_reducer.EmploymentRecordCompanyXSLTReducer;
import limmen.kth.se.id2208.hw1.parsing.xslt.short_cv_reducer.ShortCVXSLTReducer;
import limmen.kth.se.id2208.hw1.parsing.xslt.transcript_reducer.TranscriptXSLTReducer;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

/**
 *
 * XSLTParser, uses the TransformerFactory to parse and transform XML files using XSLT version 2.
 *
 * @author Kim Hammar on 2017-01-27.
 */
public class XSLTParser {
    private static final TransformerFactory transformerFactory = TransformerFactory.newInstance();

    /**
     * Transforms the transcript.xml document into a new document only containing the information relevant to the
     * application profile. Also computes the GPA. Uses transcript.xsl stylesheet
     *
     * @throws TransformerException
     */
    public void reduceTranscript() throws TransformerException {
        TranscriptXSLTReducer transcriptXSLTReducer = new TranscriptXSLTReducer(transformerFactory);
        transcriptXSLTReducer.init();
        transcriptXSLTReducer.reduce();
    }

    /**
     * Transforms the short_cv.xml document into a new document only containing the information relevant to the
     * application profile. Uses short_cv.xsl stylesheet
     *
     * @throws TransformerException
     */
    public void reduceShortCV() throws TransformerException {
        ShortCVXSLTReducer shortCVXSLTReducer = new ShortCVXSLTReducer(transformerFactory);
        shortCVXSLTReducer.init();
        shortCVXSLTReducer.reduce();
    }

    /**
     * Transforms the employment_record.xml and company_info.xml document into a new document only containing the
     * information relevant to the application profile. Uses employment_record_and_company.xsl stylesheet
     *
     * @throws TransformerException
     */
    public void reduceEmploymentRecordCompany() throws TransformerException {
        EmploymentRecordCompanyXSLTReducer employmentRecordCompanyXSLTReducer = new EmploymentRecordCompanyXSLTReducer(transformerFactory);
        employmentRecordCompanyXSLTReducer.init();
        employmentRecordCompanyXSLTReducer.reduce();
    }

    /**
     * Builds the application_profile_generated_task2.xml by extracting the relevant information from short_cv.xml
     * transcript.xml, company_info.xml, employment_record.xml and combines it to produce application_profile_generated_task2.xml.
     * Uses application_profile_combine.xsl stylesheet
     *
     * @throws TransformerException
     */
    public void combineApplicationProfile() throws TransformerException {
        reduceTranscript();
        reduceShortCV();
        reduceEmploymentRecordCompany();
        ApplicationProfileXSLTCombiner applicationProfileXSLTCombiner = new ApplicationProfileXSLTCombiner(transformerFactory);
        applicationProfileXSLTCombiner.init();
        applicationProfileXSLTCombiner.combine();
    }
}
