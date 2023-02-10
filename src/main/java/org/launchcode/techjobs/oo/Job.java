package org.launchcode.techjobs.oo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // getters and setters

    @Override
    public String toString() {

        int id = this.getId();

        String dataNotAvailable = "Data not available";

        String name;
        String employer;
        String location;
        String positionType;
        String coreCompetency;

        // null checks

        if (this.getName() == null) {
            name = dataNotAvailable;
        } else {
            name = this.getName();
        }

        try {
            employer = this.getEmployer().getValue();
        } catch (NullPointerException e) {
            employer = dataNotAvailable;
        }

        try {
            location = this.getLocation().getValue();
        } catch (NullPointerException e) {
            location = dataNotAvailable;
        }

        try {
            positionType = this.getPositionType().getValue();
        } catch (NullPointerException e) {
            positionType = dataNotAvailable;
        }

        try {
            coreCompetency = this.getCoreCompetency().getValue();
        } catch (NullPointerException e) {
            coreCompetency = dataNotAvailable;
        }

        // empty checks

        if (name.isBlank()) name = dataNotAvailable;
        if (employer.isBlank()) employer = dataNotAvailable;
        if (location.isBlank()) location = dataNotAvailable;
        if (positionType.isBlank()) positionType = dataNotAvailable;
        if (coreCompetency.isBlank()) coreCompetency = dataNotAvailable;


        return "\nID: " + id +
                "\nName: " + name +
                "\nEmployer: " + employer +
                "\nLocation: " + location +
                "\nPosition Type: " + positionType +
                "\nCore Competency: " + coreCompetency +
                "\n";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    // equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
