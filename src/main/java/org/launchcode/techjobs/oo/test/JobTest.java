package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals("job1 and job2 should not have the same unique ID", job1, job2);

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        String jobName = "Product tester";
        Employer employer = new Employer("ACME");
        Location location = new Location("Desert");
        PositionType pt = new PositionType("Quality control");
        CoreCompetency cc = new CoreCompetency("Persistence");

        Job job = new Job(jobName, employer, location, pt, cc);

        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality() {
        String jobName = "Product tester";
        Employer employer = new Employer("ACME");
        Location location = new Location("Desert");
        PositionType pt = new PositionType("Quality control");
        CoreCompetency cc = new CoreCompetency("Persistence");

        Job job1 = new Job(jobName, employer, location, pt, cc);
        Job job2 = new Job(jobName, employer, location, pt, cc);

        org.junit.Assert.assertFalse(job1.equals(job2));
    }

    // Part 5

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job();
        String jobPrint = job.toString();

//        "toString should start with a new line character",
//        "toString should end with a new line character",
        assertEquals('\n', jobPrint.charAt(0));
        assertEquals('\n', jobPrint.charAt(jobPrint.length() - 1));
        assertFalse("Job's toString should be at least two characters", jobPrint.length() < 2);

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String jobName = "Product tester";
        Employer employer = new Employer("ACME");
        Location location = new Location("Desert");
        PositionType pt = new PositionType("Quality control");
        CoreCompetency cc = new CoreCompetency("Persistence");

        Job job = new Job(jobName, employer, location, pt, cc);


        String jobPrint = job.toString();
        String expected = "\nID: " + job.getId() +
                            "\nName: Product tester" +
                            "\nEmployer: ACME" +
                            "\nLocation: Desert" +
                            "\nPosition Type: Quality control" +
                            "\nCore Competency: Persistence\n";

        assertEquals(expected, jobPrint);

        assertTrue("toString prints ID field", jobPrint.contains("\nID: " + job.getId()));
        assertTrue("toString prints Name field", jobPrint.contains("\nName: Product tester"));
        assertTrue("toString prints Employer field", jobPrint.contains("\nEmployer: ACME"));
        assertTrue("toString prints Location field", jobPrint.contains("\nLocation: Desert"));
        assertTrue("toString prints Position Type field", jobPrint.contains("\nPosition Type: Quality control"));
        assertTrue("toString prints Core Competency field", jobPrint.contains("\nCore Competency: Persistence"));

    }

    @Test
    public void testToStringHandlesNullField() {
        Job job = new Job();
        String jobPrint = job.toString();

        String spec;
        String expected;
        String actual = jobPrint;



        expected = "\nName: Data not available\n";
        spec = "Spec: null name prints \"Data not available\" after the label:" +
                "\nExpected:" + expected +
                "\nActual: " + actual;
        assertTrue(spec, jobPrint.contains(expected));

        assertTrue("null Employer prints \"Data not available\" after the label", jobPrint.contains("\nEmployer: Data not available\n"));
        assertTrue("null Location prints \"Data not available\" after the label", jobPrint.contains("\nLocation: Data not available\n"));
        assertTrue("null Position Type prints \"Data not available\" after the label", jobPrint.contains("\nPosition Type: Data not available\n"));
        assertTrue("null Core Competency prints \"Data not available\" after the label", jobPrint.contains("\nCore Competency: Data not available\n"));

    }

    @Test
    public void testToStringHandlesEmptyField() {
        String jobName = "Product tester";
        Employer employer = new Employer("");
        Location location = new Location("Desert");
        PositionType pt = new PositionType("");
        CoreCompetency cc = new CoreCompetency("Persistence");

        Job job = new Job(jobName, employer, location, pt, cc);

        String actual = job.toString();
        String expected;
        String spec;


        expected = "\nID: " + job.getId() +
                "\nName: Product tester" +
                "\nEmployer: Data not available" +
                "\nLocation: Desert" +
                "\nPosition Type: Data not available" +
                "\nCore Competency: Persistence\n";

        spec = "Spec: empty fields read \"Data not available\" after the label:" +
                "\nExpected:" + expected +
                "\nActual: " + actual;

        assertEquals(expected, actual);


    }


}
