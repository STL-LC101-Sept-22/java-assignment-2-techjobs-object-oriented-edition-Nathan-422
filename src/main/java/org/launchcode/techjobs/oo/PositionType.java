package org.launchcode.techjobs.oo;

import java.util.Objects;

public class PositionType extends JobField {

    private static int nextId = 1;

    public PositionType() {
        super(nextId);
        nextId++;
    }

    public PositionType(String location) {
        this();
        super.setValue(location);
    }

}
