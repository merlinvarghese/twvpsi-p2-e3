package com.tw.vapasi;

import java.util.Objects;

//Understands quantifiable property of object in various units
class Measurement {
    protected final Unit unit;
    protected final double value;

    protected Measurement(Unit unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    static Measurement centigrade(double magnitude) {
        return new Measurement(Unit.C, magnitude);
    }

    static Measurement fahrenheit(double magnitude) {
        return new Measurement(Unit.F, magnitude);
    }

    static Measurement kelvin(double magnitude) {
        return new Measurement(Unit.K, magnitude);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if ((otherObject == null)) {
            return false;
        }
        if (this.getClass() != otherObject.getClass()) {
            return false;
        }

        Measurement otherMeasurement = (Measurement) otherObject;
        if (this.isDifferentMeasurementType(otherMeasurement)) {
            return false;
        }
        return convertToBaseUnit() == otherMeasurement.convertToBaseUnit();
    }

    private boolean isDifferentMeasurementType(Measurement otherMeasurement) {
        return !unit.isUnitTypeEqualTo(otherMeasurement.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.unit.hashCode(), this.value);
    }

    private double convertToBaseUnit() {
        return unit.convertToBase(value);
    }

    @Override
    public String toString() {
        return "" + this.unit + ":" + this.value;
    }
}
