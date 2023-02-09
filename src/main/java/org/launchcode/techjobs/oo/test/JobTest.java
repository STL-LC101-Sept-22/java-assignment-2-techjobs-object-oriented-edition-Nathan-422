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

        assertTrue("Job name is of type String", job.getName() instanceof String);
        assertTrue("Job employer is of type Employer", job.getEmployer() instanceof Employer);
        assertTrue("Job location is of type Location", job.getLocation() instanceof Location);
        assertTrue("Job positionType is of type PositionType", job.getPositionType() instanceof PositionType);
        assertTrue("Job coreCompetency is of type CoreCompetency", job.getCoreCompetency() instanceof CoreCompetency);


        assertEquals("Job name is properly set by the constructor", "Product tester", job.getName());
        assertEquals("Job Employer is properly set by the constructor", "ACME", job.getEmployer().getValue());
        assertEquals("Job Location is properly set by the constructor", "Desert", job.getLocation().getValue());
        assertEquals("Job PositionType is properly set by the constructor", "Quality control", job.getPositionType().getValue());
        assertEquals("Job CoreCompetency is properly set by the constructor", "Persistence", job.getCoreCompetency().getValue());

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

        assertFalse("Jobs should have different IDs despite all other factors", job1.equals(job2));
    }

}
