package org.launchcode.techjobs.oo;

public class Employer extends JobField {

    private static int nextId = 1;

    public Employer() {
        super(nextId);
        nextId++;
    }

    public Employer(String location) {
        this();
        super.setValue(location);
    }

}
