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
        applicationProfile.setMotivationLetter(shortCV.getMotivationLetter());
        applicationProfile.setPreferences(processPreferences(objectFactory, shortCV.getPreferences()));
        applicationProfile.setPerson(processPerson(objectFactory, shortCV.getPersonalInformation()));
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
                sum = sum + course.getCredits() * getGradePoints(course.getGrade());
            }
        }
        float gpa = 0;
        if (totalCredits != 0)
            gpa = sum / totalCredits;
        return gpa;
    }

    private float getGradePoints(String grade) {
        if (grade.equalsIgnoreCase("A"))
            return (float) 5.0;
        if (grade.equalsIgnoreCase("B"))
            return (float) 4.0;
        if (grade.equalsIgnoreCase("C"))
            return (float) 3.0;
        if (grade.equalsIgnoreCase("D"))
            return (float) 2.0;
        if (grade.equalsIgnoreCase("E"))
            return (float) 1.0;

        return (float) 0.0;
    }

    private ApplicationProfile.Preferences processPreferences(ObjectFactory objectFactory, ShortCV.Preferences preferences) {
        ApplicationProfile.Preferences applicationProfilePreferences = objectFactory.createApplicationProfilePreferences();
        applicationProfilePreferences.setJobInterest(preferences.getJobInterest());
        applicationProfilePreferences.setJobType(preferences.getJobType());
        ApplicationProfile.Preferences.Locations applicationProfileLocations = objectFactory.createApplicationProfilePreferencesLocations();
        for (String location : preferences.getLocations().getLocation()) {
            applicationProfileLocations.getLocation().add(location);

        }
        applicationProfilePreferences.setLocations(applicationProfileLocations);
        return applicationProfilePreferences;
    }

    private ApplicationProfile.Person processPerson(ObjectFactory objectFactory, ShortCV.PersonalInformation personalInformation) {
        ApplicationProfile.Person person = objectFactory.createApplicationProfilePerson();
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
            applicationDegree.setDateOfCompletion(degree.getDateOfCompletion());
            applicationDegree.setName(degree.getName());
            applicationDegree.setGPA(calculateGPA(degree, courses)); //TODO
            applicationProfileDegrees.getDegree().add(applicationDegree);
        }
        return applicationProfileDegrees;
    }
}
