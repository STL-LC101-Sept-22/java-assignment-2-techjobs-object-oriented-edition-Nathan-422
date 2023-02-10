package org.launchcode.techjobs.oo;

public class Location extends JobField {

    private static int nextId = 1;

    public Location() {
        super(nextId);
        nextId++;
    }

    public Location(String location) {
        this();
        super.setValue(location);
    }

}
