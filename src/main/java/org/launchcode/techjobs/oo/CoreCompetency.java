package org.launchcode.techjobs.oo;

import java.util.Objects;

public class CoreCompetency extends JobField {

    private static int nextId = 1;

    public CoreCompetency() {
        super(nextId);
        nextId++;
    }

    public CoreCompetency(String location) {
        this();
        super.setValue(location);
    }
}
