package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {

    private final int id;
    private String value;

    public JobField(int id) {
        this.id = id;
    }

    public JobField(int id, String value) {
        this(id);
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobField that = (JobField) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return value;
    }

    // Getters and Setters:

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
