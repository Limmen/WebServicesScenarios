package limmen.kth.se.id2208.hw1.parsing.merger;

import limmen.kth.se.id2208.hw1.parsing.generated_pojos.application_profile.ApplicationProfile;
import limmen.kth.se.id2208.hw1.parsing.generated_pojos.application_profile.ObjectFactory;
import limmen.kth.se.id2208.hw1.parsing.generated_pojos.company_info.CompaniesInfo;
import limmen.kth.se.id2208.hw1.parsing.generated_pojos.employment_record.EmploymentRecord;
import limmen.kth.se.id2208.hw1.parsing.generated_pojos.short_cv.ShortCV;
import limmen.kth.se.id2208.hw1.parsing.generated_pojos.transcript.Transcript;

/**
 * @author Kim Hammar on 2017-01-26.
 */
public class PojoMerger {

    public ApplicationProfile mergePojosToApplicationProfile(ShortCV shortCV, Transcript transcript, EmploymentRecord employmentRecord, CompaniesInfo companiesInfo) {
        ObjectFactory objectFactory = new ObjectFactory();
        ApplicationProfile applicationProfile = objectFactory.createApplicationProfile();
        ApplicationProfile.PersonalInformation personalInformation = objectFactory.createApplicationProfilePersonalInformation();
        personalInformation.setMotivationLetter(shortCV.getMotivationLetter());
        personalInformation.setPreferences(processPreferences(objectFactory, shortCV.getPreferences()));
        personalInformation.setPerson(processPerson(objectFactory, shortCV.getPersonalInformation()));
        applicationProfile.setPersonalInformation(personalInformation);
        applicationProfile.setDegrees(processDegrees(objectFactory, transcript.getDegrees(), transcript.getCourses()));
        applicationProfile.setWorkingExperience(processWorkingExperience(objectFactory, employmentRecord.getEmploymentHistory(), companiesInfo));
        return applicationProfile;
    }


    private float calculateGPA(Transcript.Degrees.Degree degree, Transcript.Courses courses) {
        float sum = 0;
        float totalCredits = 0;
        for (Transcript.Courses.Course course : courses.getCourse()) {
            if (course.getDegree() != null && course.getDegree().equalsIgnoreCase(degree.getDegreeId())) {
                totalCredits = totalCredits + course.getCredits();
                sum = sum + course.getCredits() * course.getGrade().floatValue();
            }
        }
        float gpa = 0;
        if (totalCredits != 0)
            gpa = sum / totalCredits;
        return gpa;
    }

    private ApplicationProfile.PersonalInformation.Preferences processPreferences(ObjectFactory objectFactory, ShortCV.Preferences preferences) {
        ApplicationProfile.PersonalInformation.Preferences applicationProfilePreferences = objectFactory.createApplicationProfilePersonalInformationPreferences();
        applicationProfilePreferences.setJobInterest(preferences.getJobInterest());
        applicationProfilePreferences.setJobType(preferences.getJobType());
        ApplicationProfile.PersonalInformation.Preferences.Locations applicationProfileLocations = objectFactory.createApplicationProfilePersonalInformationPreferencesLocations();
        for (String location : preferences.getLocations().getLocation()) {
            applicationProfileLocations.getLocation().add(location);

        }
        applicationProfilePreferences.setLocations(applicationProfileLocations);
        return applicationProfilePreferences;
    }

    private ApplicationProfile.PersonalInformation.Person processPerson(ObjectFactory objectFactory, ShortCV.PersonalInformation personalInformation) {
        ApplicationProfile.PersonalInformation.Person person = objectFactory.createApplicationProfilePersonalInformationPerson();
        person.setFirstName(personalInformation.getFirstName());
        person.setCivicRegistrationNumber(personalInformation.getCivicRegistrationNumber());
        person.setLastName(personalInformation.getLastName());
        return person;
    }

    private ApplicationProfile.WorkingExperience processWorkingExperience(ObjectFactory objectFactory, EmploymentRecord.EmploymentHistory employmentHistory, CompaniesInfo companiesInfo) {
        ApplicationProfile.WorkingExperience workingExperience = objectFactory.createApplicationProfileWorkingExperience();
        for (EmploymentRecord.EmploymentHistory.Employment employment : employmentHistory.getEmployment()) {
            ApplicationProfile.WorkingExperience.Employment applicationEmployment = objectFactory.createApplicationProfileWorkingExperienceEmployment();
            applicationEmployment.setStartDate(employment.getStartDate());
            applicationEmployment.setEndDate(employment.getEndDate());
            applicationEmployment.setTitle(employment.getTitle());
            ApplicationProfile.WorkingExperience.Employment.Company applicationCompany = objectFactory.createApplicationProfileWorkingExperienceEmploymentCompany();
            for (CompaniesInfo.Company company : companiesInfo.getCompany()) {
                if (company.getName().equalsIgnoreCase(employment.getCompany())) {
                    applicationCompany.setName(company.getName());
                    applicationCompany.setAbout(company.getAbout());
                    applicationCompany.setWebsite(company.getWebsite());
                }
            }
            applicationEmployment.setCompany(applicationCompany);
            workingExperience.getEmployment().add(applicationEmployment);
        }
        return workingExperience;
    }

    private ApplicationProfile.Degrees processDegrees(ObjectFactory objectFactory, Transcript.Degrees degrees, Transcript.Courses courses) {
        ApplicationProfile.Degrees applicationProfileDegrees = objectFactory.createApplicationProfileDegrees();
        for (Transcript.Degrees.Degree degree : degrees.getDegree()) {
            ApplicationProfile.Degrees.Degree applicationDegree = objectFactory.createApplicationProfileDegreesDegree();
            applicationDegree.setCredits(degree.getCredits());
            applicationDegree.setStartDate(degree.getStartDate());
            applicationDegree.setDateOfCompletion(degree.getDateOfCompletion());
            applicationDegree.setName(degree.getName());
            applicationDegree.setGPA(calculateGPA(degree, courses));
            applicationProfileDegrees.getDegree().add(applicationDegree);
        }
        return applicationProfileDegrees;
    }
}
