package com.hackathon.ecoair.model;

public class Value {

    public Value(String unit, String value) {
        this.unit = unit;
        this.value = value;
    }

    private String unit;
    private String value;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
