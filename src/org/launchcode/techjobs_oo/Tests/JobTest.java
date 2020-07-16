package org.launchcode.techjobs_oo.Tests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.CoreCompetency;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Job;
import org.launchcode.techjobs_oo.Location;
import org.launchcode.techjobs_oo.PositionType;


public class JobTest {
    Job testJob1;
    Job testJob2;
    Employer testEmployer1;
    Employer testEmployer2;
    Location testLocation1;
    Location testLocation2;
    PositionType testPositionType1;
    PositionType testPositionType2;
    CoreCompetency testCoreCompetency1;
    CoreCompetency testCoreCompetency2;
    Job testJob1Clone;
    Job testJob2Clone;
    @Before
    public void testJobs(){
        testEmployer1 = new Employer("testEmployer1");
        testEmployer2 = new Employer("testEmployer2");
        testLocation1 = new Location("testLocation1");
        testLocation2 = new Location("testLocation2");
        testPositionType1 = new PositionType("testPositionType1");
        testPositionType2 = new PositionType("testPositionType2");
        testCoreCompetency1 = new CoreCompetency("testCoreCompetency1");
        testCoreCompetency2 = new CoreCompetency("testCoreCompetency2");
        testJob1 = new Job("testJob1", testEmployer1, testLocation1, testPositionType1, testCoreCompetency1 );
        testJob2 = new Job("testJob2", testEmployer2, testLocation2, testPositionType2, testCoreCompetency2);
        testJob1Clone = new Job("testJob1Clone", testEmployer1, testLocation1, testPositionType1, testCoreCompetency1);
        testJob2Clone = new Job("testJob2Clone", testEmployer2, testLocation2, testPositionType2, testCoreCompetency2);
    }

    @Test
    public void testSettingJobId(){
        Assert.assertEquals(testJob1.getId()+1, testJob2.getId(), .01);
        Assert.assertEquals(testJob1.getId()+2, testJob1Clone.getId(), .01);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job thisJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
Assert.assertEquals("Product tester", thisJob.getName());
        Assert.assertEquals("ACME", thisJob.getEmployer().getValue());
        Assert.assertEquals("Desert", thisJob.getLocation().getValue());
        Assert.assertEquals("Quality control", thisJob.getPositionType().getValue());
        Assert.assertEquals("Persistence", thisJob.getCoreCompetency().getValue());

        Assert.assertTrue(thisJob.getName() instanceof String);
        Assert.assertTrue(thisJob.getEmployer() instanceof Employer);
        Assert.assertTrue(thisJob.getLocation() instanceof Location);
        Assert.assertTrue(thisJob.getPositionType() instanceof  PositionType);
        Assert.assertTrue(thisJob.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality(){
        Assert.assertNotEquals(testJob1, testJob1Clone);
        Assert.assertNotEquals(testJob2, testJob2Clone);
    }

    @Test
    public void testToStringSyntax(){
        //job toString creates a line before and after the printed fields
        Assert.assertTrue(testJob1.toString().startsWith("\n") && testJob1.toString().endsWith("\n"));

        String idLabel = "ID: "; String nameLabel = "Name: "; String employerLabel = "Employer: "; String locationLabel = "Location: "; String positionTypeLabel = "Position Type: "; String coreCompetencyLabel = "Core Competency: ";
        String idString = testJob1.getId().toString(); String nameString = testJob1.getName(); String employerString = testJob1.getEmployer().toString(); String locationString = testJob1.getLocation().toString(); String positionTypeString = testJob1.getPositionType().toString(); String coreCompetencyString = testJob1.getCoreCompetency().toString();

        //the string must contain a label for each field, followed by the data stored in that field
        Assert.assertEquals(testJob1.toString().indexOf(idLabel), (testJob1.toString().indexOf(idString) - idLabel.length()));
        Assert.assertEquals(testJob1.toString().indexOf(nameLabel), (testJob1.toString().indexOf(nameString) - nameLabel.length()));
        Assert.assertEquals(testJob1.toString().indexOf(employerLabel), (testJob1.toString().indexOf(employerString) - employerLabel.length()));
        Assert.assertEquals(testJob1.toString().indexOf(locationLabel), (testJob1.toString().indexOf(locationString) - locationLabel.length()));
        Assert.assertEquals(testJob1.toString().indexOf(positionTypeLabel), (testJob1.toString().indexOf(positionTypeString) - positionTypeLabel.length()));
        Assert.assertEquals(testJob1.toString().indexOf(coreCompetencyLabel), (testJob1.toString().indexOf(coreCompetencyString) - coreCompetencyLabel.length()));
    }

    @Test
    public void testJobFieldsDataValidationForNull(){
        String idLabel = "ID: "; String nameLabel = "Name: "; String employerLabel = "Employer: "; String locationLabel = "Location: "; String positionTypeLabel = "Position Type: "; String coreCompetencyLabel = "Core Competency: ";
        Job emptyJob = new Job();
        emptyJob.setName("Job has name!");
        String noData = "Data not available";

        Assert.assertTrue(emptyJob.getEmployer() == null && emptyJob.toString().contains(employerLabel + noData));
        Assert.assertTrue(emptyJob.getLocation() == null && emptyJob.toString().contains(locationLabel + noData));
        Assert.assertTrue(emptyJob.getPositionType() == null && emptyJob.toString().contains(positionTypeLabel + noData));
        Assert.assertTrue(emptyJob.getCoreCompetency() == null && emptyJob.toString().contains(coreCompetencyLabel + noData));
    }

    @Test
    public void testJobFieldsDataValidationForEmpty(){
        String idLabel = "ID: "; String nameLabel = "Name: "; String employerLabel = "Employer: "; String locationLabel = "Location: "; String positionTypeLabel = "Position Type: "; String coreCompetencyLabel = "Core Competency: ";
        Job emptyJob3 = new Job("",new Employer(""),new Location("location name"), new PositionType(""), new CoreCompetency(""));
        String noData = "Data not available";

        Assert.assertTrue(emptyJob3.getName().equals("") && emptyJob3.toString().contains(nameLabel + noData));
        Assert.assertTrue(emptyJob3.getEmployer().getValue().equals("") && emptyJob3.toString().contains(employerLabel + noData));
        Assert.assertTrue(emptyJob3.getPositionType().getValue().isEmpty() && emptyJob3.toString().contains(positionTypeLabel + noData));
        Assert.assertTrue(emptyJob3.getCoreCompetency().getValue().isEmpty() && emptyJob3.toString().contains(coreCompetencyLabel + noData));
    }
    //4. If a job only contains data for the id field the method returns "OOPS! This job does not seem to exist"
    @Test
    public void testForEmptyJob(){
        Job emptyJob2 = new Job();
        Assert.assertTrue(emptyJob2.toString().equals("OOPS! This job does not seem to exist"));
    }
}
